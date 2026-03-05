import java.util.Scanner;
public class menoroumaior {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com sua idade:");
        int idade = scan.nextInt();

        if (idade > 18){
            System.out.println("MAIOR DE IDADE");
        } else{
            System.out.println("MENOR DE IDADE");
        }
    }
}
