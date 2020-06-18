package com.codeinshort.stringjoiner;

import java.util.StringJoiner;

/*StringJoiner is used for joining string making use of delimiter, prefix and suffix*/
public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("Akash")
                .add("Deep");

        System.out.println(joiner.toString());

        StringJoiner joiner1 = new StringJoiner(",","(", ")");
        joiner1.add("A")
                .add("B");

        System.out.println(joiner1.toString());
    }
}
