//Funcion recursiva que devuelva el fibonacci de un numero

public class holamundo {
    public static void main(String[] args) {
        int numero = 5;
        System.out.println("El fibonacci de " + numero + " es: " + fibonacci(numero));
    }

    public static int fibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return numero;
        } else {
            return fibonacci(numero - 1) + fibonacci(numero - 2);
        }
    }
}