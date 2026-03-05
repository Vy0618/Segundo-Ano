import java.util.Scanner;


public class doubleNumber {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Entre com um número qualquer:");
        int x = scan.nextInt();

        int y = x*2;

        System.out.println();
        System.out.println("O dobro deste número é igual a: " + y);
    }
}
