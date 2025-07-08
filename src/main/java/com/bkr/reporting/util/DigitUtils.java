package com.bkr.reporting.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

@Component
public class DigitUtils {
    public static String format(String sequence, int length){
        if(StringUtils.isBlank(sequence)) return " ".repeat(length);
        sequence = StringUtils.substring(sequence, 0, length);
        return StringUtils.rightPad(sequence, length);
    }

    public static String toCurrency(Double amount){
        if(amount == null) return "";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRENCH);
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.FRENCH);
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(amount);
    }

    public static String toDays(Integer days){
        if(days == null) days = 0;
        if(days < 10) {
            if(days < 2){
                return "0" + days + " jour";
            }
            return "0" + days + " jours";
        }
        return days + " jours";
    }
}
