package org.example.something;

import org.example.something.JsonFormat.JsonFormatter;
import org.example.something.JsonFormat.PrettyPrintJson;
import org.example.something.Printer.PrettyPrintColored;

public class Main {
    public static void main(String[] args) {
        String json = "{\"name\":\"Akemi\",\"skills\":[\"Java\",\"SQL\",],\"active\":true}";
        JsonFormatter format = new PrettyPrintJson();
        String prettyPrintResult = format.formatter(json);

        format = new PrettyPrintColored();
        String prettyPrintColored = format.formatter(json);

        System.out.println(prettyPrintResult);
        System.out.println(prettyPrintColored);

        //System.out.println("\u001B[32mЗелёный текст\u001B[0m");
        //System.out.println("\u001B[31mКрасный текст\u001B[0m");
        //System.out.println("\u001B[34mСиний текст\u001B[0m");
    }
}