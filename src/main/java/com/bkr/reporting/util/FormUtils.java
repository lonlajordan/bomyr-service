package com.bkr.reporting.util;

import com.bkr.reporting.constant.Extension;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FormUtils {
    public static ResponseEntity<ByteArrayResource> generateReport(TemplateEngine engine, String template, Object form) {
        return generateReport(engine, template, form, Extension.PDF);
    }

    public static ResponseEntity<ByteArrayResource> generateReport(TemplateEngine engine, String template, Object form, Extension extension) {
        Context context = new Context();
        context.setVariable("form", form);
        String html = engine.process(template, context);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(stream);
        String fileName = "form.pdf";
        MediaType contentType = MediaType.APPLICATION_PDF;
        if(!Extension.PDF.equals(extension)){
            PDDocument document;
            try {
                document = PDDocument.load(stream.toByteArray());
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                if(document.getNumberOfPages() > 0){
                    BufferedImage image = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
                    fileName = "form." + extension.name().toLowerCase();
                    contentType = extension.getType();
                    stream = new ByteArrayOutputStream();
                    ImageIOUtil.writeImage(image, extension.name().toLowerCase(), stream, 300);
                }
                document.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        HttpHeaders header = new HttpHeaders();
        header.setContentType(contentType);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.OK);
    }
}
