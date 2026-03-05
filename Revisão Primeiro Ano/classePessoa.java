public class classePessoa {
    String nome;
    String nacionalidade;
    String idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void apresentar(){
        System.out.println("O seu nome é " + this.nome + " e você tem " + this.idade + " anos de idade. Além disso, é " + this.nacionalidade);
    }
}
