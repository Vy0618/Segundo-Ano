import java.util.Scanner;
public class tabuada {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com um número qualquer: ");
        int x = scan.nextInt();;

        for(int i = 0; i <= 10; i++){
            int multiplier = i;
            int resultado = x * i;
            System.out.println(x + " * " + i + " = " + resultado);
        }
    }
}
