package com.codeinshort.java;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class MultiValueMap_Example {
    public static void main(String[] args) {
        MultiValueMap<Integer, Integer> map = new LinkedMultiValueMap<>();
        map.put(1, Arrays.asList(1,2,3,4,5));
        System.out.println(map);
    }
}
