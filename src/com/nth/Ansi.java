package com.nth;

/**
 *
 * @author HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com>
 */
public class Ansi {

    private static final char ESC = 27;
    private static final String NEWLINE = System.getProperty("line.separator");

    public static final String PREFIX = ESC + "[";

    public static final String SEPARATOR = ";";

    public static final String POSTFIX = "m";

    public static final String RESET = PREFIX + Attribute.CLEAR() + POSTFIX;

    public static String generateCode(Attribute... attributes) {
        StringBuilder builder = new StringBuilder();

        builder.append(PREFIX);
        for (Object option : attributes) {
            String code = option.toString();
            if (code.equals("")) {
                continue;
            }
            builder.append(code);
            builder.append(SEPARATOR);
        }
        builder.append(POSTFIX);

        return builder.toString().replace(SEPARATOR + POSTFIX, POSTFIX);
    }

    public static String generateCode(AnsiFormat attributes) {
        return generateCode(attributes.toArray());
    }

    public static String generateCode(Command command) {
        return PREFIX + command;
    }

    public static String colorize(Command command) {
        return generateCode(command);
    }

    public static String colorize(String text, String ansiCode) {
        StringBuilder output = new StringBuilder();

        output.append(ansiCode);

        String enclosedFormatting = text.replace(NEWLINE, RESET + NEWLINE + ansiCode);
        output.append(enclosedFormatting);
        output.append(RESET);
        return output.toString();
    }

    public static String colorize(String text, Attribute... attributes) {
        String ansiCode = generateCode(attributes);
        return colorize(text, ansiCode);
    }

    public static String colorize(String text, AnsiFormat attributes) {
        return colorize(text, attributes.toArray());
    }

    public static String makeItFabulous(String text, Attribute... attributes) {
        return colorize(text, attributes);
    }

}
