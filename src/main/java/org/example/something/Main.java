package org.example.something;

import org.example.something.JsonFormat.JsonFormatter;
import org.example.something.Printer.PrettyPrintJson;
import org.example.something.Printer.PrettyPrintColored;

public class Main {
    public static void main(String[] args) {
        String json = "{\"name\\\":\"Akemi\",\"skills\":[\"Java\",\"SQL\",],\"active\":true}";
        String json_test = "{\n" +
                "  \"name\": \"Alice\",\n" +
                "  \"age\": 29,\n" +
                "  \"isActive\": true,\n" +
                "  \"email\": \"alice@example.com\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"123 Main St\",\n" +
                "    \"city\": \"Wonderland\",\n" +
                "    \"zip\": 12345\n" +
                "  },\n" +
                "  \"phones\": [\"+123456789\", \"+987654321\"],\n" +
                "  \"roles\": [\"admin\", \"user\", \"editor\"],\n" +
                "  \"preferences\": {\n" +
                "    \"notifications\": {\n" +
                "      \"email\": true,\n" +
                "      \"sms\": false\n" +
                "    },\n" +
                "    \"theme\": \"dark\"\n" +
                "  },\n" +
                "  \"projects\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Project A\",\n" +
                "      \"budget\": 100000.50\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"Project B\",\n" +
                "      \"budget\": 250000\n" +
                "    }\n" +
                "  ],\n" +
                "  \"history\": [\n" +
                "    {\"date\": \"2025-01-01\", \"action\": \"login\"},\n" +
                "    {\"date\": \"2025-02-10\", \"action\": \"logout\"},\n" +
                "    {\"date\": \"2025-03-05\", \"action\": \"update_profile\"}\n" +
                "  ],\n" +
                "  \"misc\": null\n" +
                "}\n";
        String json_test_2 = "{\"name\": \"Bob, \"age\": 35 \"isActive\": true, \"email\": bob@example.com, \"address\": {\"street\": \"456 Elm St\", \"city\": \"Nowhere\", \"zip\": 54321}, \"phones\": [\"+1122334455\" \"+5566778899\"], \"roles\": [\"user\", \"editor\" \"moderator\"], \"preferences\": {\"notifications\": {\"email\": true \"sms\": false}, \"theme\": \"light\"}, \"projects\": [{\"id\": 1, \"name\": \"Project X\" \"budget\": 50000}, {\"id\": 2, \"name\": \"Project Y\", \"budget\": 150000}], \"history\": [{\"date\": \"2025-05-01\", \"action\": \"login\"}, {\"date\": \"2025-06-10\", \"action\": \"logout\"} {\"date\": \"2025-07-05\", \"action\": \"update_profile\"}], \"misc\": null,}\n";


        JsonFormatter format = new PrettyPrintJson();
        String prettyPrintResult = format.formatter(json);

        format = new PrettyPrintColored();
        String prettyPrintColored = format.formatter(json);

        System.out.println(prettyPrintResult);
        System.out.println(prettyPrintColored);

        System.out.println("\n-------------------\n");

        System.out.println(format.formatter(json_test));

        System.out.println("\n-------------------\n");

        System.out.println(format.formatter(json_test_2));


        //System.out.println("\u001B[32mЗелёный текст\u001B[0m");
        //System.out.println("\u001B[31mКрасный текст\u001B[0m");
        //System.out.println("\u001B[34mСиний текст\u001B[0m");
    }
}