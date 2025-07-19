package br.edu.ifrn.sistema.model;

public class Aluno {
    private String nomeAluno;
    private long matricula;
    private Curso cursoDoAluno;

    public Aluno(String nomeAluno, long matricula, Curso cursoDoAluno) {
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
        this.cursoDoAluno = cursoDoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public Curso getCursoDoAluno() {
        return cursoDoAluno;
    }

    public String getNomeDoCursoDoAluno() {
        return cursoDoAluno.getNomeCurso();
    }

    public void setCursoDoAluno(Curso cursoDoAluno) {
        this.cursoDoAluno = cursoDoAluno;
    }
}
