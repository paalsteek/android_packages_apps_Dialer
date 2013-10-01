package com.android.dialer.dialpad.util;

public class NameToNumber implements NameLatinizer {
    protected String t9Chars;
    protected String t9Digits;

    public NameToNumber(String t9Chars, String t9Digits) {
        this.t9Chars = t9Chars;
        this.t9Digits = t9Digits;
    }

    public String convertToT9(String name) {
        int len = name.length();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            int pos = t9Chars.indexOf(Character.toLowerCase(name.charAt(i)));
            if (pos == -1) {
                pos = 0;
            }
            sb.append(t9Digits.charAt(pos));
        }
        return sb.toString();
    }

    @Override
    public String[] getNameLatinizations(String name) {
        // TODO Auto-generated method stub
        return new String[] {
            this.convertToT9(name)
        };
    }

}
