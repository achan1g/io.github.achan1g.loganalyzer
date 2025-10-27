package io.github.achan1g;

import java.time.LocalDateTime;

public class LogEntry {

    private final LocalDateTime timestamp;
    private final LogLevel level;
    private final String thread;
    private final String logger;
    private final String message;

    public LogEntry(LocalDateTime timestamp, LogLevel level, String thread, String logger, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.thread = thread;
        this.logger = logger;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getThread() {
        return thread;
    }

    public String getLogger() {
        return logger;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "timestamp=" + timestamp +
                ", level=" + level +
                ", thread='" + thread + "'" +
                ", logger='" + logger + "'" +
                ", message='" + message + "'" +
                '}';
    }
}
