import java.util.Scanner;
public class atividadePessoa {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        classePessoa pessoa1 = new classePessoa();

        System.out.println("Nome:");
        pessoa1.setNome(scan.nextLine());
        System.out.println("Idade");
        pessoa1.setIdade(scan.nextLine());
        System.out.println("Nacionalidade");
        pessoa1.setNacionalidade(scan.nextLine());

pessoa1.apresentar();

    }
}