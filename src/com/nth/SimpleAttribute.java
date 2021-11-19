package com.nth;

/**
 *
 * @author HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com>
 */
class SimpleAttribute extends Attribute {

    private final String _code;

    SimpleAttribute(String code) {
        _code = code;
    }

    @Override
    public String toString() {
        return _code;
    }

}
