package br.edu.ifrn.sistema.model;

public class Disciplina {
    private String nomeDisciplina;
    private int cargaHoraria;

    public Disciplina(String nomeDisciplina, int cargaHoraria) {
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}