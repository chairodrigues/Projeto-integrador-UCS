import java.time.LocalDate;

class Aluno {
    private String nome;
    private LocalDate dataNascimento;

    public Aluno(String nome, String cpf, String endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }


    public String getNome() {
        return nome;
    }

    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        return hoje.minusYears(dataNascimento.getYear()).getYear();
    }

    @Override
    public String toString() {
        return getNome() + " - Idade: " + getIdade();
    }
}