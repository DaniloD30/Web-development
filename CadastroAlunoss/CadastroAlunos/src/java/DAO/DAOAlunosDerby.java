/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

/**
 *
 * @author Aluno
 */
public class DAOAlunosDerby implements DAOAlunos {

    @Override
    public boolean addAluno(Aluno aluno) {
        try {
            PreparedStatement pstm = ConexaoDerby.getInstancia().getConn().prepareStatement("INSERT INTO DOD.NOTAS (NOMEALUNO,NOTA1,NOTA2,NOTA3) values (?,?,?,?)");

            pstm.setString(1, aluno.getNome());
            pstm.setDouble(2, aluno.getNota1());
            pstm.setDouble(3, aluno.getNota2());
            pstm.setDouble(4, aluno.getNota3());

            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlunosDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List buscarByName(Aluno aluno) {
        List<Aluno> lista = new ArrayList<>();

        try {
            PreparedStatement pstm = ConexaoDerby.getInstancia().getConn().prepareStatement("Select * from DOD.NOTAS WHERE NOMEALUNO = " + aluno.getNome() + "");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Aluno p = new Aluno();
                p.setNome(rs.getString("NOMEALUNO"));
                p.setNota1(rs.getDouble("NOTA1"));
                p.setNota2(rs.getDouble("NOTA2"));
                p.setNota3(rs.getDouble("NOTA3"));

                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlunosDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List getAllAlunos() {
        List<Aluno> lista = new ArrayList<>();

        try {
            PreparedStatement pstm = ConexaoDerby.getInstancia().getConn().prepareStatement("Select * from DOD.NOTAS ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Aluno p = new Aluno();
                p.setNome(rs.getString("NOMEALUNO"));
                p.setNota1(rs.getDouble("NOTA1"));
                p.setNota2(rs.getDouble("NOTA2"));
                p.setNota3(rs.getDouble("NOTA3"));

                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAlunosDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean updateAluno(Aluno aluno) throws SQLException {
            
        PreparedStatement pstm = ConexaoDerby.getInstancia().getConn().prepareStatement("UPDATE DOD.NOTAS SET NOMEALUNO = ?, NOTA1 = ?,NOTA2 = ?,NOTA3 = ? WHERE NOMEALUNO = ?");

            pstm.setString(1, aluno.getNome());
            pstm.setDouble(2, aluno.getNota1());
            pstm.setDouble(3, aluno.getNota2());
            pstm.setDouble(4, aluno.getNota3());
            pstm.setString(5, aluno.getNome());
            return pstm.executeUpdate() == 1;
            
        
    }

}
