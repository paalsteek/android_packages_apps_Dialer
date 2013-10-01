package com.android.dialer.dialpad.util;

import android.text.TextUtils;

public class NameToNumberChinese extends NameToNumber implements NameLatinizer {
    public NameToNumberChinese(String t9Chars, String t9Digits) {
        super(t9Chars, t9Digits);
    }

    @Override
    public String[] getNameLatinizations(String name) {
        final HanziToPinyin pinyin = HanziToPinyin.getInstance();
        String hzFirstPinYin = pinyin.getFirstPinYin(name).toLowerCase();

        if (TextUtils.isEmpty(hzFirstPinYin)) {
            return new String[] {
                this.convertToT9(name)
            };
        }

        String firstPinYinT9 = this.convertToT9(hzFirstPinYin);

        // Append the full ping yin at the end of the first ping yin
        String hzFullPinYin = pinyin.getFullPinYin(name).toLowerCase();
        if (!TextUtils.isEmpty(hzFullPinYin)) {
            return new String[] {
                    firstPinYinT9, this.convertToT9(hzFullPinYin)
            };
        } else {
            return new String[] {
                firstPinYinT9
            };
        }
    }
}
