public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String json = "{\"name\":\"SomeUser\",\"skills\":[\"Draw\",\"CG\",\"3D\"],\"active\":true}";
        JsonFormatter format = new PrettyPrintJson(4);
        String prettyPrintResult = format.formatter(json);

        System.out.println(prettyPrintResult);
    }
}