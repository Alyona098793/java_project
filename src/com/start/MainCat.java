package com.start;

import com.start.current.Cat;

import java.text.NumberFormat;

public class MainCat {
    public static void main(String[] args) {
        java.text.NumberFormat nf = java.text.NumberFormat. getPercentInstance();
        nf.setMinimumFractionDigits(2);
        String s  =nf.format(2.0055);
        System.out.println(s);



    }
}
