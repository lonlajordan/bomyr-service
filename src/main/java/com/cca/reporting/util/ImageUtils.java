package com.cca.reporting.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageUtils {

    public static String getImage(String text){
        String base64 = text;
        /*
            if(StringUtils.isBlank(base64)){
                try {
                    base64 = readFileContents("static/images/signature.txt");
                } catch (IOException ignored) { }
            }
        */
        if(StringUtils.isNotBlank(base64) && !base64.contains(",")) base64 = "data:image/png;base64," + base64;
        return base64;
    }

    public static String readFileContents(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return String.join("\n", lines);
    }
}
