public class Calculator {
    public double divide(double n1, double n2) throws DivideByZeroException {
        if (n2 == 0) {
            throw new DivideByZeroException();

        } else {
            return n1 / n2;
        }
    }

    public double average(double[] numbers) throws EmptyArrayException {
        if (numbers.length == 0) {
            throw new EmptyArrayException();
        } else {
            double sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum = sum + numbers[i];
            }
            return sum/ numbers.length;
        }
    }
}
