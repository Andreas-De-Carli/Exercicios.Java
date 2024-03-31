public class Calculadora {
    public static double adicionar(double a, double b) {
        return a + b;

    }

    public static double subtrair(double a, double b) {
        return a - b;

    }

    public static double multiplicar(double a, double b) {
        return a * b;

    }

    public static double dividir(double a, double b) {
        if (b == 0) {
            return Double.NaN;

        }

        return a / b;

    }
    
}
