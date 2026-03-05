import java.util.Scanner;
public class mediaDe5numeros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = 0;
        int soma = 0;

        for (int i = 0; i < 5; i++){
            System.out.println("Entre com um número inteiro qualquer: ");
            x = scan.nextInt();
            soma += x;
            System.out.println(soma);
        }

        double resultado = soma/5;

        System.out.println("Média da soma dos cinco números: ");
        System.out.println(resultado);

    }
}
