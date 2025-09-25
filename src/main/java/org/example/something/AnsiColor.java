package org.example.something;

public enum AnsiColor {
    RESET("\u001B[0m"),
    GRAY("\u001B[90m"),
    YELLOW("\u001B[33m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m");

    private final String code;

    AnsiColor(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
