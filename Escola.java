import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Escola extends Aluno{
    public Escola(String nome, String cpf, String endereco, LocalDate dataNascimento) {
        super(nome, cpf, endereco, dataNascimento);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        ListaDeAlunos listaDeAlunos = new ListaDeAlunos();
        ArrayList<Turma> turmas = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Turma");
            System.out.println("3. Matricular Aluno em Turma");
            System.out.println("4. Listar Alunos por Nome e Idade");
            System.out.println("5. Listar Turmas Cadastradas");
            System.out.println("6. Listar Alunos Matriculados em uma Turma");
            System.out.println("7. Listar Número de Alunos fora da faixa etária matriculados em uma Etapa de Ensino");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    // Cadastrar Aluno
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("CPF do aluno: ");
                    String cpfAluno = scanner.nextLine();
                    System.out.print("Endereço do aluno: ");
                    String enderecoAluno = scanner.nextLine();
                    System.out.print("Data de Nascimento do aluno (AAAA-MM-DD): ");
                    String dataNascimentoAlunoStr = scanner.nextLine();
                    LocalDate dataNascimentoAluno = LocalDate.parse(dataNascimentoAlunoStr);
                    Aluno aluno = new Aluno(nomeAluno, cpfAluno, enderecoAluno, dataNascimentoAluno);
                    listaDeAlunos.incluirNoFim(aluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.print("Código da turma: ");
                    String codigoTurma = scanner.nextLine();
                    System.out.print("Etapa de ensino (infantil, fundamental, médio): ");
                    String etapaEnsino = scanner.nextLine();
                    System.out.print("Ano da turma: ");
                    int anoTurma = scanner.nextInt();
                    System.out.print("Limite de vagas da turma: ");
                    int limiteVagas = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    Turma turma = new Turma(codigoTurma, etapaEnsino, anoTurma, limiteVagas);
                    turmas.add(turma);
                    System.out.println("Turma cadastrada com sucesso!");
                    break;

                case 3:

                    System.out.print("Nome do aluno: ");
                    String nomeAlunoMatricula = scanner.nextLine();
                    System.out.print("Código da turma: ");
                    String codigoTurmaMatricula = scanner.nextLine();
                    Aluno alunoMatricula = null;
                    for (int i = 0; i < listaDeAlunos.tamanho(); i++) {
                        if (listaDeAlunos.get(i).getNome().equals(nomeAlunoMatricula)) {
                            alunoMatricula = listaDeAlunos.get(i);
                            break;
                        }
                    }
                    if (alunoMatricula != null) {
                        for (Turma t : turmas) {
                            if (t.getCodigo().equals(codigoTurmaMatricula)) {
                                t.matricularAluno(alunoMatricula);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:

                    listaDeAlunos.ordenar();
                    System.out.println("Alunos cadastrados:");
                    for (int i = 0; i < listaDeAlunos.tamanho(); i++) {
                        Aluno a = listaDeAlunos.get(i);
                        System.out.println(a.toString());
                    }
                    break;

                case 5:

                    System.out.println("Turmas cadastradas:");
                    for (Turma t : turmas) {
                        System.out.println(t.toString());
                    }
                    break;

                case 6:

                    System.out.print("Código da turma: ");
                    String codigoTurmaConsulta = scanner.nextLine();
                    for (Turma t : turmas) {
                        if (t.getCodigo().equals(codigoTurmaConsulta)) {
                            t.listarAlunosMatriculados();
                            break;
                        }
                    }
                    break;

                case 7:

                    System.out.print("Etapa de ensino (infantil, fundamental, médio): ");
                    String etapaEnsinoConsulta = scanner.nextLine();

                    System.out.println("Número de Alunos fora da faixa etária que estão matriculados na etapa de ensino " + etapaEnsinoConsulta + ":");

                    for (Turma t : turmas) {
                        if (t.getEtapaEnsino().equals(etapaEnsinoConsulta)) {
                            t.listarNroAlunosForaFaixa(etapaEnsinoConsulta);
                            break;
                        }
                    }
                    break;


                case 8:

                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
