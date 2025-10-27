package io.github.achan1g;

import org.junit.Test;
import io.github.achan1g.LogAnalyzer;
import io.github.achan1g.LogEntry;
import io.github.achan1g.LogLevel;
import io.github.achan1g.LogParser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LogAnalyzerTest {

    @Test
    public void testCountByLevel() {
        List<String> logLines = Arrays.asList(
                "[2025-10-27 21:45:00.123] [INFO] [main] com.example.MyClass - This is a log message.",
                "[2025-10-27 21:46:00.234] [WARN] [thread-1] com.example.AnotherClass - This is a warning.",
                "[2025-10-27 21:47:00.345] [INFO] [main] com.example.MyClass - Another info message.",
                "[2025-10-27 21:48:00.456] [ERROR] [thread-2] com.example.ErrorClass - An error occurred."
        );

        LogParser parser = new LogParser();
        List<LogEntry> entries = parser.parse(logLines);
        LogAnalyzer analyzer = new LogAnalyzer(entries);

        Map<LogLevel, Long> counts = analyzer.countByLevel();

        assertEquals(2, (long) counts.get(LogLevel.INFO));
        assertEquals(1, (long) counts.get(LogLevel.WARN));
        assertEquals(1, (long) counts.get(LogLevel.ERROR));
    }
}