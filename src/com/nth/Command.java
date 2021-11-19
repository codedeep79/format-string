package com.nth;

/**
 * Abstracts ANSI codes with intuitive names. It maps a command (e.g.
 * CLEAR_SCREEN) with a code.
 * 
 * @author HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com>
 */
public class Command {

    private final String _code;

    Command(String code) {
        _code = code;
    }

    public static Command CLEAR_SCREEN() {
        return new Command("2J");
    }

    @Override
    public String toString() {
        return _code;
    }
}
