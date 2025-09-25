package org.example.something.Printer;

import org.example.something.ColorJson.AnsiColor;
import org.example.something.JsonFormat.SimpleJsonFormatter;

public class PrettyPrintColored extends SimpleJsonFormatter {
    public PrettyPrintColored(PrettyPringConfig config) {
        super(config);
    }

    public PrettyPrintColored() {
        super(new PrettyPringConfig());
    }

    @Override
    public String formatter(String json) {
        StringBuilder sb = new StringBuilder();
        int indentLevel = 0;
        Boolean isQuote = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            if (c == '"') {
                sb.append(AnsiColor.GREEN.code()).append(c).append(AnsiColor.RESET.code());
                isQuote = !isQuote;
                continue;
            }

            if (!isQuote) {
                switch (c) {
                    case '{':
                    case'[':
                        sb.append(AnsiColor.GRAY.code()).append(c).append(AnsiColor.RESET.code())
                                .append("\n");
                        indentLevel++;
                        appendIndent(sb, indentLevel);
                        break;
                    case '}':
                    case ']':
                        sb.append("\n");
                        indentLevel--;
                        appendIndent(sb, indentLevel);
                        sb.append(AnsiColor.GRAY.code()).append(c).append(AnsiColor.RESET.code());
                        break;
                    case ',':
                        sb.append(c).append("\n");
                        appendIndent(sb, indentLevel);
                        break;
                    case ':':
                        sb.append(c).append(" ");
                        break;
                    default:
                        if (Character.isDigit(c)) {
                            sb.append(AnsiColor.BLUE.code()).append(c).append(AnsiColor.RESET.code());
                        } else if (Character.isLetter(c)) {
                            sb.append(AnsiColor.BLUE.code()).append(c).append(AnsiColor.RESET.code());
                        } else if (!Character.isWhitespace(c)) {
                            sb.append(c);
                        }
                        break;
                }
            } else {
                sb.append(AnsiColor.YELLOW.code()).append(c).append(AnsiColor.RESET.code());
            }
        }

        return sb.toString();
    }
}
