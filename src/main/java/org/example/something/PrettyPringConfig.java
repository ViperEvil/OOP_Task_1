package org.example.something;

public class PrettyPringConfig {
    private final int indentSize;
    private final String indentChar; //" ", \t or even maybe another char

    public PrettyPringConfig(int indentSize, String indentChar) {
        this.indentSize = indentSize;
        this.indentChar = indentChar;
    }

    public PrettyPringConfig() {
        this.indentSize = 4;
        this.indentChar = " ";
    }

    public int getIndentSize() {
        return this.indentSize;
    }

    public String getIndentChar() {
        return this.indentChar;
    }
}
