package io.github.achan1g;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    private static final String LOG_PATTERN = "\\[(.*?)\\] \\[([A-Z]+)\\] \\[([a-zA-Z0-9_-]+)\\] ([a-zA-Z0-9_.-]+) - (.*)";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public List<LogEntry> parse(List<String> logLines) {
        List<LogEntry> entries = new ArrayList<>();
        Pattern pattern = Pattern.compile(LOG_PATTERN);

        for (String line : logLines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                LocalDateTime timestamp = LocalDateTime.parse(matcher.group(1), DATE_TIME_FORMATTER);
                LogLevel level = LogLevel.valueOf(matcher.group(2));
                String thread = matcher.group(3);
                String logger = matcher.group(4);
                String message = matcher.group(5);
                entries.add(new LogEntry(timestamp, level, thread, logger, message));
            }
        }
        return entries;
    }
}
