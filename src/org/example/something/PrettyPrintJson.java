public class PrettyPrintJson implements JsonFormatter {
    private final int indentSize;

    public PrettyPrintJson(int indentSize) {
        this.indentSize = indentSize;
    }

    /**
     * If { or [ - add new indent level
     * If closing } or ] - then lower indent level
     * If : - just add space to stringbuilder
     * If , - just add /n
     * @param json
     * @return
     */
    @Override
    public String formatter(String json) {
        StringBuilder sb = new StringBuilder();
        int indentLevel = 0;
        Boolean isQuote = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            if (c == '"') {
                sb.append(c);
                isQuote = !isQuote;
                continue;
            }

            if (!isQuote) {
                switch (c) {
                    case '{':
                    case'[':
                        sb.append(c).append("\n");
                        indentLevel++;
                        appendIndent(sb, indentLevel);
                        break;
                    case '}':
                    case ']':
                        sb.append("\n");
                        indentLevel--;
                        appendIndent(sb, indentLevel);
                        sb.append(c);
                        break;
                    case ',':
                        sb.append("\n");
                        appendIndent(sb, indentLevel);
                        break;
                    case ':':
                        sb.append(" ");
                        break;
                    default:
                        sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private void appendIndent(StringBuilder sb, int indentLevel) {
        sb.append(" ".repeat(indentLevel * this.indentSize));
    }
}
