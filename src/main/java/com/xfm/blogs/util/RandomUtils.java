package com.xfm.blogs.util;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.Random;

public class RandomUtils {
    private static final char[] RANDOM_ARRAY = {'0','1','2','3','4','5','6','7','8','9',
                                                'a','b','c','d','e','g','h','i','j','k',
                                                'l','m','n','o','p','q','r','s','t','u',
                                                'v','w','x','y','z','A','B','C','D','E',
                                                'F','G','H','I', 'J','K','L','M','N','O',
                                                'P','Q','R','S','T','U','V','W','X','Y','Z'};
    private Random random = new Random();
    public static String generate16String(){
        StringBuffer randomstr = new StringBuffer();
        for(int i=0; i<16; i++){
            randomstr.append(RANDOM_ARRAY[(int)(Math.random()*RANDOM_ARRAY.length)]);
        }
        return randomstr.toString();
    }
}
