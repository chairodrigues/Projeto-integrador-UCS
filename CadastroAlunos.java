
import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Scanner;

public class CadastroAlunos extends Aluno{

    public CadastroAlunos(String nome, String cpf, String endereco, LocalDate dataNascimento) {
        super(nome, cpf, endereco, dataNascimento);
    }
}


class Turma {
    private String codigo;
    private int limiteVagas;
    private ArrayList<Aluno> alunosMatriculados;

    public Turma(String codigo, String etapaEnsino, int ano, int limiteVagas) {
        this.codigo = codigo;
        this.limiteVagas = limiteVagas;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
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

    public String getEtapaEnsino() {
        throw new UnsupportedOperationException("Unimplemented method 'getEtapaEnsino'");
    }

    public String getAno() {

        throw new UnsupportedOperationException("Unimplemented method 'getAno'");
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


