import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExceptionMenu menu = new ExceptionMenu(new Scanner(System.in), new Calculator());
        menu.run();
    }
}
