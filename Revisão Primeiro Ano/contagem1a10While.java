import java.util.Scanner;
public class contagem1a10While {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int contador = 0;
        int numero = 0;

        while (contador != 10){
            numero++;
            contador++;
            System.out.println(numero);
        }

    }
}
