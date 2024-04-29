
import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.Collections;
import java.util.Objects;

public class CadastroAlunos extends Aluno{

    public CadastroAlunos(String nome, String cpf, String endereco, LocalDate dataNascimento) {
        super(nome, cpf, endereco, dataNascimento);
    }
}


class Turma {
    private String codigo;
    private String etapaEnsino;
    private int ano;
    private int limiteVagas;
    private ArrayList<Aluno> alunosMatriculados;

    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas) {
        this.codigo = codigo;
        this.etapaEnsino = etapaEnsino;
        this.ano = ano;
        this.limiteVagas = limiteVagas;
        this.alunosMatriculados = new ArrayList<>();
    }

    public void matricularAluno(Aluno aluno) {
        if (alunosMatriculados.size() < limiteVagas) {
            alunosMatriculados.add(aluno);
            System.out.println("Aluno matriculado com sucesso na turma " + codigo);
        } else {
            System.out.println("Não há vagas disponíveis nesta turma.");
        }
    }

    public void listarAlunosMatriculados() {
        System.out.println("Alunos matriculados na turma " + codigo + ":");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println(aluno.getNome());
        }
    }

    public void listarNroAlunosForaFaixa(String etapaEnsinoConsulta) {
        int contador = 0;
        int idadeMinima = 0;
        int idadeMaxima = 0;
        switch (etapaEnsinoConsulta) {
            case "infantil":
                idadeMaxima = 5;
                break;
            case "fundamental":
                idadeMinima = 6;
                idadeMaxima = 15;
                break;
            case "médio":
                idadeMinima = 15;
                idadeMaxima = 18;
                break;
        }

        for (Aluno a : alunosMatriculados) {
            int idade = a.getIdade();
            if (idade < idadeMinima || idade > idadeMaxima) {
                contador++;
            }
        }
        System.out.println(contador);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEtapaEnsino() {
        return etapaEnsino;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Código: " + getCodigo() + ", Etapa de Ensino: " + getEtapaEnsino() + ", Ano: " + getAno();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(getEtapaEnsino(), turma.getEtapaEnsino());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEtapaEnsino());
    }
}

class ListaDeAlunos {
    private ArrayList<Aluno> alunos;

    public ListaDeAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void incluirNoInicio(Aluno aluno) {
        alunos.add(0, aluno);
    }

    public void incluirNoFim(Aluno aluno) {
        alunos.add(aluno);
    }

    public void ordenar() {
        Collections.sort(alunos, (a1, a2) -> a1.getNome().compareTo(a2.getNome()));
    }

    public Aluno removerDoFim() {
        if (!alunos.isEmpty()) {
            return alunos.remove(alunos.size() - 1);
        } else {
            return null;
        }
    }

    public int tamanho() {
        return alunos.size();
    }

    public Aluno get(int index) {
        if (index >= 0 && index < alunos.size()) {
            return alunos.get(index);
        } else {
            return null;
        }
    }
}


