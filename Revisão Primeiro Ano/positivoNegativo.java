import java.util.Scanner;
public class positivoNegativo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com um número inteiro qualquer:");
        int x = scan.nextInt();

        if (x > 0){
            System.out.println("O número é positivo");
        } else if (x < 0){
            System.out.println("O número é negativo");
        } else{
            System.out.println("O número é nulo");
        }

    }
}
