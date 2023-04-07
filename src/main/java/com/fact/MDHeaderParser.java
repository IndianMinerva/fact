package com.fact;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDHeaderParser {

    private static final Pattern MD_HEADER_REGEX = Pattern.compile("(^#{1,6}\\s)\\S.*");
    private static final Pattern LEADING_STRINGS_REGEX = Pattern.compile("^\\s+");
    private static final Pattern TRAILING_SPACES_REGEX = Pattern.compile("\\s+$");
    private static final Pattern LEADING_HASH_CHARACTERS_REGEX = Pattern.compile("^#+");

    private static final Pattern TEXT_REGEX = Pattern.compile("\\w.*");

    //https://www.regextester.com/
    public String getParsedHtml(String mdHeader) {
        //(?<=(^#{1,6})\s).*
        //(^#{1,6}\s)\S.*
        return Optional.ofNullable(mdHeader).map(header -> {
            String leadingSpaces = getLeadingSpaces(header);
            String trailingSpaces = getTrailingSpaces(header);
            String hashCharacters = getLeadingHashCharacters(header);
            int hashCharacterCount = hashCharacters.length();

            if (MD_HEADER_REGEX.matcher(mdHeader.trim()).matches()) {
                return leadingSpaces + "<h" + hashCharacterCount + ">" + getText(header) + "</h" + hashCharacterCount + ">" + trailingSpaces;
            } else {
                if (hashCharacterCount > 6)
                    return leadingSpaces + getText(header) + trailingSpaces;
                else if(hashCharacterCount == 0)
                    return header;
                else if (header.trim().replace("#", "").startsWith("  "))
                    return header;
                else return "";
            }
        }).orElse("");
    }

    private String getLeadingSpaces(String str) {
        Matcher leadingMatcher = LEADING_STRINGS_REGEX.matcher(str);
        return leadingMatcher.find() ? leadingMatcher.group(0) : "";
    }

    private String getLeadingHashCharacters(String str) {
        Matcher leadingMatcher = LEADING_HASH_CHARACTERS_REGEX.matcher(str.trim());
        return leadingMatcher.find() ? leadingMatcher.group(0) : "";
    }

    private String getTrailingSpaces(String str) {
        Matcher trailingMatcher = TRAILING_SPACES_REGEX.matcher(str);
        return trailingMatcher.find() ? trailingMatcher.group(0) : "";
    }

    private String getText(String str) {
        Matcher textMatcher = TEXT_REGEX.matcher(str.trim());
        return textMatcher.find() ? textMatcher.group(0) : "";
    }
}
