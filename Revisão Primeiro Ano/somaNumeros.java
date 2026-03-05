import java.util.Scanner;
public class somaNumeros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira dois números inteiros:");
        int x = scan.nextInt();
        System.out.println("");
        int y = scan.nextInt();

        int a = x + y;

        System.out.println("A soma entre os dois números é: " + a);
    }
}
