/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleescolar.model;

/**
 *
 * @author Suporte
 */
public class TurmaTemProfessor {
    
    private Turma turma;
    private Professor professor;

    public TurmaTemProfessor() {
    }

    public TurmaTemProfessor(Turma turma, Professor professor) {
        this.turma = turma;
        this.professor = professor;
    }
    
    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
