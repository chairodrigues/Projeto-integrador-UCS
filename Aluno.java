import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getNome(), aluno.getNome()) && Objects.equals(dataNascimento, aluno.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), dataNascimento);
    }
}