package com.nth;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com>
 */
public class AnsiFormat {

    private final ArrayList<Attribute> _attributes = new ArrayList<>(2);

    public AnsiFormat(Attribute... attributes) {
        _attributes.addAll(Arrays.asList(attributes));
    }

    public String format(String text) {
        return Ansi.colorize(text, this.toArray());
    }

    protected Attribute[] toArray() {
        return _attributes.toArray(new Attribute[0]);
    }
}
