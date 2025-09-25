package org.example.something.JsonFormat;

import org.example.something.PrintConfig.PrettyPringConfig;

public abstract class SimpleJsonFormatter implements JsonFormatter {
    private final PrettyPringConfig config;

    public SimpleJsonFormatter(PrettyPringConfig config) {
        this.config = config;
    }

    public void appendIndent(StringBuilder sb, int level) {
        sb.append(config.getIndentChar().repeat(level * config.getIndentSize()));
    }
}
