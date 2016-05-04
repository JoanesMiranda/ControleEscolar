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
public class TurmaTemAluno {
    
    private Turma turma;
    private Aluno aluno;

    public TurmaTemAluno() {
    }

    public TurmaTemAluno(Turma turma, Aluno aluno) {
        this.turma = turma;
        this.aluno = aluno;
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
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
