package com.bkr.reporting.util;

import org.apache.commons.lang3.StringUtils;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.SimpleXmlSerializer;

public class HtmlUtils {
    public static String clean(String html) {
        if(StringUtils.isBlank(html)) return "";
        CleanerProperties cleanerProperties = new CleanerProperties();
        cleanerProperties.setOmitHtmlEnvelope(true);
        cleanerProperties.setOmitXmlDeclaration(true);
        cleanerProperties.setUseEmptyElementTags(false);
        return new SimpleXmlSerializer(cleanerProperties).getAsString(html);
    }
}
