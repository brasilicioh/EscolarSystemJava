package br.edu.ifrn.sistema.model;

import java.util.ArrayList;

public class Curso {
    private String nomeCurso;
    private String turnoCurso;
    private ArrayList<Disciplina> disciplinas;

    public Curso(String nomeCurso, String turnoCurso, ArrayList<Disciplina> disciplinas) {
        this.nomeCurso = nomeCurso;
        this.turnoCurso = turnoCurso;
        this.disciplinas = disciplinas;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTurnoCurso() {
        return turnoCurso;
    }

    public void setTurnoCurso(String turnoCurso) {
        this.turnoCurso = turnoCurso;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public String getNomeAllDisciplinas() {
        String saida = "";
        for (Disciplina disciplina : disciplinas) {
            saida += (disciplina.getNomeDisciplina() + " - ");
        }
        return saida;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
