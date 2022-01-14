import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMenu {

    private Scanner scanner;
    private Calculator calculator;

    public ExceptionMenu (Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }

    private int askInteger(String message) {
        System.out.println(message);
        Integer number = null;
        while (number == null) {
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, introduce numero");
            } finally {
                scanner.nextLine();
            }
        }

        return number;
    }


    private int askOperation() {
        System.out.println("¿Qué quieres calcular?");
        System.out.println("1. División");
        System.out.println("2. Media");
        System.out.println("3. Exit");
        int operation = askInteger("");

        while (operation != 1 && operation != 2 && operation != 3) {
            operation = askInteger("Opcion invalida");
        }
        return operation;
    }
    private int askSize() {
        int size = askInteger("Introduce el tamaño del array");
        while (size < 0) {
            size = askInteger("El tamaño debe ser nayor que 0, introduce un tamaño nuevamente");

        }
        return size;
    }
    private double [] askNumbers() {
        double [] numbers = new double[askSize()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = askInteger("Introduce un número entero");
        }
        return numbers;
    }

    public void run() {
        int operation = askOperation();
        while (operation != 3) {
            if (operation == 1) {
                try {
                    double result = calculator.divide(askInteger("Introduce numero entero"), askInteger("Introduce otro número"));
                    System.out.println("La división es " + result);
                } catch (DivideByZeroException e) {
                    System.out.println("NO se puede dividir entre 0");

                }
            } else if (operation == 2) {
                try {
                    double [] numbers = askNumbers();
                    double media = calculator.average(numbers);
                    System.out.println("La media es " + media);

                } catch (EmptyArrayException e) {
                    System.out.println("El array no puede estar vacío");
                }
            } else {
                System.out.println("Opcion desconocida");
            }
            operation=askOperation();
        }
    }
}
