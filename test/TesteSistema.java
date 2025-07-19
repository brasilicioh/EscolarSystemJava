// Repositório representando um sistema de gerenciamento de alunos, disciplinas e cursos
// Protótipo de sistema escolar
// Repositório pode ser lido em: https://github.com/brasilicioh/EscolarSystemJava

// import necessários para uso do teste
import java.util.ArrayList;
import java.util.Scanner;
import br.edu.ifrn.sistema.model.Aluno;
import br.edu.ifrn.sistema.model.Curso;
import br.edu.ifrn.sistema.model.Disciplina;

public class TesteSistema {
    // Métodos que exibem menus e submenus
    public static void menuPrincipal() {
        System.out.println("1-Gerenciar ALUNOS \n2-Gerenciar DISCIPLINAS \n3-Gerenciar CURSOS \n4-SAIR");
    }

    public static void subMenuAluno() {
        System.out.println("1-Cadastrar ALUNO \n2-Consultar ALUNO \n3-Remover ALUNO \n4-Atualizar ALUNO \n5-Voltar ao MENU INICIAL"); 
    }

    public static void subMenuDisciplina() {
        System.out.println("1-Cadastrar DISCIPLINA \n2-Consultar DISCIPLINA \n3-Remover DISCIPLINA \n4-Atualizar DISCIPLINA \n5-Voltar ao MENU INICIAL"); 
    }

    public static void subMenuCurso() {
        System.out.println("1-Cadastrar CURSO \n2-Consultar CURSO \n3-Remover CURSO \n4-Atualizar CURSO \n5-Voltar ao MENU INICIAL"); 
    }

    // Métodos que exibem listas de alunos, disciplinas e cursos 
    public static void exibirAllAlunos(ArrayList<Aluno> alunos) {
        System.out.println("Abaixo, matricula de todos alunos cadastrados");
        System.out.println();
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i+1) + ". " + alunos.get(i).getMatricula());
        }
        System.out.println();
    }

    public static void exibirAllDisciplinas(ArrayList<Disciplina> disciplinas, boolean mostrarZerom) {
        System.out.println("Abaixo, nome de todas disciplinas cadastradas");
        System.out.println();
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i+1) + ". " + disciplinas.get(i).getNomeDisciplina());
        }
        if (mostrarZerom) {
            System.out.println("0. Finalizar");
        }
        System.out.println();
    }

    public static void exibirAllCursos(ArrayList<Curso> cursos) {
        System.out.println("Abaixo, nome de todos cursos cadastrados");
        System.out.println();
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i+1) + ". " + cursos.get(i).getNomeCurso());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // definindo Scanner e iniciando listas de alunos, disciplinas e cursos
        Scanner scan = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();

        // variáveis para gerenciar escolha do usuário
        String entrada;
        String entradatwo;
        String entradathree;

        // variáveis que definem índice para listas e escolhas
        int index;
        int indextwo;

        menuPrincipal();

        entrada = scan.next();

        while (!entrada.equals("4")) { // irá ficar executando enquanto o usuário não escolher sair
            System.out.println();
            switch (entrada) {
                case "1":
                    // caso escolha gerenciar alunos
                    subMenuAluno();

                    entradatwo = scan.next();

                    while (!entradatwo.equals("5")) { // irá ficar executando enquanto o usuário não escolher voltar ao menu principal
                        System.out.println();
                        if (alunos.isEmpty() && !entradatwo.equals("1")) {
                            System.out.println("Nenhum aluno cadastrado ainda! Não é possível realizar essa acao");
                            entradatwo = "0";
                        }
                        switch (entradatwo) {
                            case "1":
                                // cadastrando aluno
                                System.out.print("Escreva o nome do aluno: "); scan.nextLine();
                                String nomeAluno = scan.nextLine();

                                System.out.print("Escreva matricula do aluno (apenas numeros): ");
                                long matriculaAluno = scan.nextLong();

                                System.out.println();

                                exibirAllCursos(cursos);

                                System.out.print("Escolha o numero do curso desse aluno: ");
                                index = scan.nextInt() - 1;

                                if (index >= cursos.size() || index < 0) {
                                    System.out.println("Esse numero de curso e invalido, voltando para submenu");
                                } else {
                                    Aluno aluno = new Aluno(nomeAluno, matriculaAluno, cursos.get(index));
                                    alunos.add(aluno);
                                    System.out.println();
                                    System.out.println("Aluno cadastrado!");
                                }
                                break;

                            case "2":
                                // listando alunos cadastrados para analisar algum específico
                                exibirAllAlunos(alunos);

                                System.out.print("Para consultar, escolha o numero do aluno: ");
                                index = scan.nextInt() - 1;

                                if (index >= alunos.size() || index < 0) {
                                    System.out.println("Esse numero de aluno e invalido, voltando para submenu");
                                } else {
                                    System.out.println("Nome: " + alunos.get(index).getNomeAluno());
                                    System.out.println("Matricula: " + alunos.get(index).getMatricula());
                                    System.out.println("Nome do Curso: " + alunos.get(index).getNomeDoCursoDoAluno());
                                }
                                break;

                            case "3":
                                // listando alunos cadastrados para remover algum específico
                                exibirAllAlunos(alunos);

                                System.out.print("Para remover, escolha o numero do aluno: ");
                                index = scan.nextInt() - 1;

                                if (index >= alunos.size() || index < 0) {
                                    System.out.println("Esse numero de aluno e invalido, voltando para submenu");
                                } else {
                                    alunos.remove(index);
                                    System.out.println();
                                    System.out.println("Aluno removido!");
                                }
                                break;

                            case "4":
                                // listando alunos cadastrados para atualizar algum específico
                                exibirAllAlunos(alunos);

                                System.out.print("Para atualizar, escolha o numero do aluno: ");
                                index = scan.nextInt() - 1;

                                if (index >= alunos.size() || index < 0) {
                                    System.out.println("Esse numero de aluno e invalido, voltando para submenu");
                                } else {
                                    System.out.println();
                                    System.out.println("1. Mudar nome \n2. Mudar matricula \n3. Mudar curso");
                                    entradathree = scan.next();

                                    switch (entradathree) {
                                        case "1":
                                            System.out.print("Escreva o novo nome do aluno: "); scan.nextLine();
                                            alunos.get(index).setNomeAluno(scan.nextLine());
                                            System.out.println();
                                            System.out.println("Aluno atualizado!");
                                            break;

                                        case "2":
                                            System.out.print("Escreva a nova matricula do aluno (apenas numeros): ");
                                            alunos.get(index).setMatricula(scan.nextLong());
                                            System.out.println();
                                            System.out.println("Aluno atualizado!");
                                            break;

                                        case "3":
                                            System.out.println();

                                            exibirAllCursos(cursos);

                                            System.out.print("Escolha o novo numero do curso do aluno: ");
                                            indextwo = scan.nextInt() - 1;

                                            if (indextwo >= cursos.size() || indextwo < 0) {
                                                System.out.println("Esse numero de curso e invalido, voltando para submenu");
                                            } else {
                                                alunos.get(index).setCursoDoAluno(cursos.get(indextwo));
                                                System.out.println();
                                                System.out.println("Aluno atualizado!");
                                            }
                                            break;

                                        default:
                                            System.out.println("Entrada invalida, voltando para submenu");
                                            break;
                                    }
                                }
                                break;

                            default:
                                System.out.println("Entrada invalida, tente novamente");
                                break;
                        }

                        System.out.println();
                        subMenuAluno();

                        entradatwo = scan.next();
                    }

                    System.out.println();
                    System.out.println("Voltando...");
                    break;


                case "2":
                    // caso escolha gerenciar disciplinas
                    subMenuDisciplina();

                    entradatwo = scan.next();

                    while (!entradatwo.equals("5")) { // irá ficar executando enquanto o usuário não escolher voltar ao menu principal
                        System.out.println();
                        if (disciplinas.isEmpty() && !entradatwo.equals("1")) {
                            System.out.println("Nenhuma disciplina cadastrada ainda! Não é possível realizar essa acao");
                            entradatwo = "0";
                        }
                        switch (entradatwo) {
                            // cadastrando disciplina
                            case "1":
                                System.out.print("Escreva o nome da disciplina: "); scan.nextLine();
                                String nomeDisciplina = scan.nextLine();

                                System.out.print("Escreva a carga horaria da disciplina (em horas): ");
                                int cargaHoraria = scan.nextInt();

                                Disciplina disciplina = new Disciplina(nomeDisciplina, cargaHoraria);
                                disciplinas.add(disciplina);
                                System.out.println();
                                System.out.println("Disciplina cadastrada!");
                                break;

                            case "2":
                                // listando disciplinas cadastradas para analisar alguma específica
                                exibirAllDisciplinas(disciplinas, false);

                                System.out.print("Para consultar, escolha o numero da disciplina: ");
                                index = scan.nextInt() - 1;

                                if (index >= disciplinas.size() || index < 0) {
                                    System.out.println("Esse numero de disciplina e invalido, voltando para submenu");
                                } else {
                                    System.out.println("Nome: " + disciplinas.get(index).getNomeDisciplina());
                                    System.out.println("Carga Horaria: " + disciplinas.get(index).getCargaHoraria());
                                }
                                break;

                            case "3":
                                // listando disciplinas cadastradas para remover alguma específica
                                exibirAllDisciplinas(disciplinas, false);

                                System.out.print("Para remover, escolha o numero da disciplina: ");
                                index = scan.nextInt() - 1;

                                if (index >= disciplinas.size() || index < 0) {
                                    System.out.println("Esse numero de disciplina e invalido, voltando para submenu");
                                } else {
                                    disciplinas.remove(index);
                                    System.out.println();
                                    System.out.println("Disciplina removida!");
                                }
                                break;

                            case "4":
                                // listando disciplinas cadastradas para atualizar alguma específica
                                exibirAllDisciplinas(disciplinas, false);

                                System.out.print("Para atualizar, escolha o numero da disciplina: ");
                                index = scan.nextInt() - 1;

                                if (index >= disciplinas.size() || index < 0) {
                                    System.out.println("Esse numero de disciplina e invalido, voltando para submenu");
                                } else {
                                    System.out.println();
                                    System.out.println("1. Mudar nome \n2. Mudar carga horaria");
                                    entradathree = scan.next();

                                    switch (entradathree) {
                                        case "1":
                                            System.out.print("Escreva o novo nome da disciplina: "); scan.nextLine();
                                            disciplinas.get(index).setNomeDisciplina(scan.nextLine());
                                            System.out.println();
                                            System.out.println("Disciplina atualizada!");
                                            break;

                                        case "2":
                                            System.out.print("Escreva a nova carga horaria (em horas) da disciplina: ");
                                            disciplinas.get(index).setCargaHoraria(scan.nextInt());
                                            System.out.println();
                                            System.out.println("Disciplina atualizada!");
                                            break;

                                        default:
                                            System.out.println("Entrada invalida, voltando para submenu");
                                            break;
                                    }
                                }
                                break;

                            default:
                                System.out.println("Entrada invalida, tente novamente");
                                break;
                        }

                        System.out.println();
                        subMenuDisciplina();

                        entradatwo = scan.next();
                    }

                    System.out.println();
                    System.out.println("Voltando...");
                    break;


                case "3":
                    // caso escolha gerenciar cursos
                    subMenuCurso();

                    entradatwo = scan.next();

                    while (!entradatwo.equals("5")) { // irá ficar executando enquanto o usuário não escolher voltar ao menu principal 
                        System.out.println();
                        if (cursos.isEmpty() && !entradatwo.equals("1")) {
                            System.out.println("Nenhum curso cadastrado ainda! Não é possível realizar essa acao");
                            entradatwo = "0";
                        }
                        switch (entradatwo) {
                            // cadastrando curso
                            case "1":
                                System.out.print("Escreva o nome do curso: "); scan.nextLine();
                                String nomeCurso = scan.nextLine();

                                System.out.print("Escreva o turno do curso: ");
                                String turnoCurso = scan.nextLine();

                                System.out.println();
                                
                                exibirAllDisciplinas(disciplinas, true);

                                System.out.println("Digite o numero e em seguida enter para adicionar a disciplina (0 para finalizar o processo ou um numero invalido para cancelar): ");
                                index = scan.nextInt() - 1;
                                ArrayList<Disciplina> disciplinasCurso = new ArrayList<>();

                                while (index != -1 && index < disciplinas.size()) {
                                    disciplinasCurso.add(disciplinas.get(index));
                                    index = scan.nextInt() - 1;
                                }
                                if (index == -1) {
                                    Curso curso = new Curso(nomeCurso, turnoCurso, disciplinasCurso);
                                    cursos.add(curso);
                                    System.out.println();
                                    System.out.println("Curso cadastrado!");
                                } else {
                                    System.out.println("Voce escreveu algum numero invalido para as disciplinas, voltando para menu");
                                }
                                break;

                            case "2":
                                // listando cursos cadastrados para analisar algum específico
                                exibirAllCursos(cursos);

                                System.out.print("Para consultar, escolha o numero do curso: ");
                                index = scan.nextInt() - 1;

                                if (index >= cursos.size() || index < 0) {
                                    System.out.println("Esse numero de curso e invalido, voltando para submenu");
                                } else {
                                    System.out.println("Nome: " + cursos.get(index).getNomeCurso());
                                    System.out.println("Turno: " + cursos.get(index).getTurnoCurso());
                                    System.out.println("Nome das disciplinas: " + cursos.get(index).getNomeAllDisciplinas());
                                }
                                break;

                            case "3":
                                // listando cursos cadastrados para remover algum específico
                                exibirAllCursos(cursos);

                                System.out.print("Para remover, escolha o numero do curso: ");
                                index = scan.nextInt() - 1;

                                if (index >= cursos.size() || index < 0) {
                                    System.out.println("Esse numero de curso e invalido, voltando para submenu");
                                } else {
                                    cursos.remove(index);
                                    System.out.println();
                                    System.out.println("Curso removido!");
                                }
                                break;

                            case "4":
                                // listando cursos cadastrados para atualizar algum específico
                                exibirAllCursos(cursos);

                                System.out.print("Para atualizar, escolha o numero do curso: ");
                                index = scan.nextInt() - 1;

                                if (index >= cursos.size() || index < 0) {
                                    System.out.println("Esse numero de curso e invalido, voltando para submenu");
                                } else {
                                    System.out.println();
                                    System.out.println("1. Mudar nome \n2. Mudar turno \n3. Mudar disciplinas");
                                    entradathree = scan.next();

                                    switch (entradathree) {
                                        case "1":
                                            System.out.print("Escreva o novo nome do curso: "); scan.nextLine();
                                            cursos.get(index).setNomeCurso(scan.nextLine());
                                            System.out.println();
                                            System.out.println("Curso atualizado!");
                                            break;

                                        case "2":
                                            System.out.print("Escreva o novo turno do curso: "); scan.nextLine();
                                            cursos.get(index).setTurnoCurso(scan.nextLine());
                                            System.out.println();
                                            System.out.println("Curso atualizado!");
                                            break;

                                        case "3":
                                            System.out.println();
                                            
                                            exibirAllDisciplinas(disciplinas, true);

                                            System.out.println("Digite o numero e em seguida enter para adicionar a disciplina (0 para finalizar o processo ou um numero invalido para cancelar): ");
                                            indextwo = scan.nextInt() - 1;
                                            ArrayList<Disciplina> disciplinasCursoAt = new ArrayList<>();

                                            while (indextwo != -1 && indextwo < disciplinas.size()) {
                                                disciplinasCursoAt.add(disciplinas.get(indextwo));
                                                indextwo = scan.nextInt() - 1;
                                            }
                                            if (indextwo == -1) {
                                                cursos.get(index).setDisciplinas(disciplinasCursoAt);
                                                System.out.println();
                                                System.out.println("Curso atualizado!");
                                            } else {
                                                System.out.println("Voce escreveu algum numero invalido para as disciplinas, voltando para menu");
                                            }
                                            break;

                                        default:
                                            System.out.println("Entrada invalida, voltando para submenu");
                                            break;
                                    }
                                }
                                break;

                            default:
                                System.out.println("Entrada invalida, tente novamente");
                                break;
                        }

                        System.out.println();   
                        subMenuCurso();

                        entradatwo = scan.next();
                    }

                    System.out.println();
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Entrada invalida, tente novamente");
                    break;
            }
            
            System.out.println();
            menuPrincipal();

            entrada = scan.next();
        }

        System.out.println();
        System.out.println("Saindo...");

        scan.close();
    }
}
