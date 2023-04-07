package com.fact;

import java.util.Optional;

public class StringMiddle {
    public String extractMiddleCharsOfString(String input) {
        return Optional.ofNullable(input).map(str -> {
            int length = str.length();
            if (str.equals("")) {
                return "";
            } else if (length % 2 == 1) {
                return str.substring(length / 2, length / 2 + 1);
            } else {
                return str.substring(length / 2 - 1, length / 2 + 1);
            }
        }).orElse("");
    }
}
