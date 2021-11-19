package com.nth;

import static com.nth.Ansi.colorize;
import static com.nth.Attribute.BACK_COLOR;
import static com.nth.Attribute.BLUE_BACK;
import static com.nth.Attribute.BOLD;
import static com.nth.Attribute.BRIGHT_MAGENTA_BACK;
import static com.nth.Attribute.BRIGHT_YELLOW_TEXT;
import static com.nth.Attribute.CYAN_TEXT;
import static com.nth.Attribute.GREEN_BACK;
import static com.nth.Attribute.GREEN_TEXT;
import static com.nth.Attribute.MAGENTA_BACK;
import static com.nth.Attribute.RED_BACK;
import static com.nth.Attribute.RED_TEXT;
import static com.nth.Attribute.TEXT_COLOR;
import static com.nth.Attribute.YELLOW_BACK;
import static com.nth.Attribute.YELLOW_TEXT;
import java.util.Random;

/**
 *
 * @author HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com>
 */
public class FormatString {

    public static int randomInt(int upperLimit) {
        return new Random().nextInt(upperLimit);
    }

    public static void main(String[] args) {
        System.out.println(colorize("This text will be yellow on magenta", YELLOW_TEXT(), MAGENTA_BACK()));
        System.out.println("\n");

        Attribute[] myFormat = new Attribute[]{RED_TEXT(), YELLOW_BACK(), BOLD()};
        System.out.println(colorize("This text will be red on yellow", myFormat));
        System.out.println("\n");

        AnsiFormat fWarning = new AnsiFormat(GREEN_TEXT(), BLUE_BACK(), BOLD());
        System.out.println(colorize("AnsiFormat is just a pretty way to declare formats", fWarning));
        System.out.println(fWarning.format("...and use those formats without calling colorize() directly"));
        System.out.println("\n");

        AnsiFormat fInfo = new AnsiFormat(CYAN_TEXT());
        AnsiFormat fError = new AnsiFormat(YELLOW_TEXT(), RED_BACK());
        System.out.println(fInfo.format("This info message will be cyan"));
        System.out.println("This normal message will not be formatted");
        System.out.println(fError.format("This error message will be yellow on red"));
        System.out.println("\n");

        AnsiFormat fNormal = new AnsiFormat(MAGENTA_BACK(), YELLOW_TEXT());
        AnsiFormat fBright = new AnsiFormat(BRIGHT_MAGENTA_BACK(), BRIGHT_YELLOW_TEXT());
        System.out.println(fNormal.format("You can use normal colors ") + fBright.format(" and bright colors too"));

        System.out.println("Any 8-bit color (0-255), as long as your terminal supports it:");
        for (int i = 0; i <= 255; i++) {
            Attribute txtColor = TEXT_COLOR(i);
            System.out.print(colorize(String.format("%4d", i), txtColor));
        }
        System.out.println("\n");

        System.out.println("Any TrueColor (RGB), as long as your terminal supports it:");
        for (int i = 0; i <= 300; i++) {
            Attribute bkgColor = BACK_COLOR(randomInt(255), randomInt(255), randomInt(255));
            System.out.print(colorize("   ", bkgColor));
        }
        System.out.println("\n");

        System.out.print("This example used JColor 5.0.0   ");
        System.out.print(colorize("\tMADE ", BOLD(), BRIGHT_YELLOW_TEXT(), GREEN_BACK()));
        System.out.println(colorize("IN PORTUGAL\t", BOLD(), BRIGHT_YELLOW_TEXT(), RED_BACK()));
        System.out.println("I hope you find it useful ;)");

    }

}
