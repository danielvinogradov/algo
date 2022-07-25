package com.codewars.stripcomments;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {

    public static String stripComments(final String text, final String[] commentSymbols) {
        final String[] strings = text.split("\\n");

        final String regex = String.format("(%s).*", Arrays.stream(commentSymbols)
                .map(el -> String.format("\\%s", el))
                .collect(Collectors.joining("|")));

        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll(regex, "").stripTrailing();
        }

        return String.join("\n", strings);
    }

    public static void main(String[] args) {
//        var result = stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"});
//        System.out.println(result);

        var result = stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"});
        System.out.println(result);
    }

}
