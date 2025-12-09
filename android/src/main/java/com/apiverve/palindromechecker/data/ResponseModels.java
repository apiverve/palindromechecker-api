// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     PalindromeCheckerData data = Converter.fromJsonString(jsonString);

package com.apiverve.palindromechecker.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static PalindromeCheckerData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(PalindromeCheckerData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(PalindromeCheckerData.class);
        writer = mapper.writerFor(PalindromeCheckerData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// PalindromeCheckerData.java

package com.apiverve.palindromechecker.data;

import com.fasterxml.jackson.annotation.*;

public class PalindromeCheckerData {
    private String text;
    private boolean isPalindrome;
    private String cleanedText;
    private String reversedText;
    private long length;
    private Options options;
    private String longestPalindromeSubstring;
    private long longestPalindromeLength;

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }

    @JsonProperty("is_palindrome")
    public boolean getIsPalindrome() { return isPalindrome; }
    @JsonProperty("is_palindrome")
    public void setIsPalindrome(boolean value) { this.isPalindrome = value; }

    @JsonProperty("cleaned_text")
    public String getCleanedText() { return cleanedText; }
    @JsonProperty("cleaned_text")
    public void setCleanedText(String value) { this.cleanedText = value; }

    @JsonProperty("reversed_text")
    public String getReversedText() { return reversedText; }
    @JsonProperty("reversed_text")
    public void setReversedText(String value) { this.reversedText = value; }

    @JsonProperty("length")
    public long getLength() { return length; }
    @JsonProperty("length")
    public void setLength(long value) { this.length = value; }

    @JsonProperty("options")
    public Options getOptions() { return options; }
    @JsonProperty("options")
    public void setOptions(Options value) { this.options = value; }

    @JsonProperty("longest_palindrome_substring")
    public String getLongestPalindromeSubstring() { return longestPalindromeSubstring; }
    @JsonProperty("longest_palindrome_substring")
    public void setLongestPalindromeSubstring(String value) { this.longestPalindromeSubstring = value; }

    @JsonProperty("longest_palindrome_length")
    public long getLongestPalindromeLength() { return longestPalindromeLength; }
    @JsonProperty("longest_palindrome_length")
    public void setLongestPalindromeLength(long value) { this.longestPalindromeLength = value; }
}

// Options.java

package com.apiverve.palindromechecker.data;

import com.fasterxml.jackson.annotation.*;

public class Options {
    private boolean ignoreCase;
    private boolean ignoreSpaces;
    private boolean ignorePunctuation;

    @JsonProperty("ignore_case")
    public boolean getIgnoreCase() { return ignoreCase; }
    @JsonProperty("ignore_case")
    public void setIgnoreCase(boolean value) { this.ignoreCase = value; }

    @JsonProperty("ignore_spaces")
    public boolean getIgnoreSpaces() { return ignoreSpaces; }
    @JsonProperty("ignore_spaces")
    public void setIgnoreSpaces(boolean value) { this.ignoreSpaces = value; }

    @JsonProperty("ignore_punctuation")
    public boolean getIgnorePunctuation() { return ignorePunctuation; }
    @JsonProperty("ignore_punctuation")
    public void setIgnorePunctuation(boolean value) { this.ignorePunctuation = value; }
}