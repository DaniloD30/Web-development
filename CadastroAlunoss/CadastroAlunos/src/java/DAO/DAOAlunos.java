/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Aluno;

/**
 *
 * @author Aluno
 */
public interface DAOAlunos {
    public boolean addAluno(Aluno aluno) ;
    public List buscarByName(Aluno aluno);
}
