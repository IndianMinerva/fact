package org.example;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDHeaderParser {

    private static final Pattern MD_HEADER_REGEX = Pattern.compile("(^#{1,6}\\s)\\S.*");
    private static final Pattern LEADING_STRINGS = Pattern.compile("^\\s+");
    private static final Pattern TRAILING_SPACES = Pattern.compile("\\s+$");
    private static final Pattern LEADING_HASH_CHARACTERS = Pattern.compile("^#+");

    //https://www.regextester.com/
    public String getParsedHtml(String mdHeader) {
        //(?<=(^#{1,6})\s).*
        //(^#{1,6}\s)\S.*
        Optional.ofNullable(mdHeader).map(header -> {
            if (MD_HEADER_REGEX.matcher(mdHeader.trim()).matches()) {

            } else {

            }
            return null;
        }).orElse("");
        return "";
    }

    private String getLeadingSpaces(String str) {
        Matcher leadingMatcher = LEADING_STRINGS.matcher(str);
        return leadingMatcher.find() ? leadingMatcher.group(0) : "";
    }

    private String getLeadingHashCharacters(String str) {
        Matcher leadingMatcher = LEADING_HASH_CHARACTERS.matcher(str);
        return leadingMatcher.find() ? leadingMatcher.group(0) : "";
    }

    private String getTrailingSpaces(String str) {
        Matcher trailingMatcher = TRAILING_SPACES.matcher(str);
        return trailingMatcher.find() ? trailingMatcher.group(0) : "";
    }
}
