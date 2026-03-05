import java.util.Scanner;
public class parouimpar {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com um número inteiro qualquer: ");
        int x = scan.nextInt();

        if(x%2 == 0){
            System.out.println("O número é par");
        } else{
            System.out.println("O número é impar");
        }

    }
}