/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Passagem;

/**
 *
 * @author LEESE
 */
public class DAOPassagensDerby implements DAOPassagens {

    private Connection conn;

    public DAOPassagensDerby() {
        this.conn = ConexaoDerby.getInstancia().getConn();
    }

    @Override
    public boolean addPassagem(Passagem passagem) {
        Statement st;
        try {
            st = this.conn.createStatement();
            st.executeUpdate("insert into dod.PASSAGENS (Passageiro, Cpf, Nascimento, Origem, Partida, Destino, Chegada, Valor) "
                    + "values ('" + passagem.getPassageiro() + "',"
                    + "" + passagem.getCpf() + ","
                    + "'" + passagem.getNascimento() + "',"
                    + "'" + passagem.getOrigem() + "',"
                    + "" + passagem.getPartida() + ","
                    + "" + passagem.getDestino() + ","
                    + "" + passagem.getChegada() + ","
                    + "'" + passagem.getValor() + "')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOPassagensDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List buscarTodasPassagens() {
        List<Passagem> lista = new ArrayList<>();
        Statement st;

        try {
            st = this.conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from dod.PASSAGENS");
            while (rs.next()) {
                //Passageiro, Cpf, Nascimento, Origem, Partida, Destino, Chegada, Valor
                Passagem p = new Passagem();
                p.setPassageiro(rs.getString("Passageiro"));
                p.setCpf(rs.getString("Cpf"));
                p.setNascimento(rs.getString("Nascimento"));
                p.setOrigem(rs.getString("Origem"));
                p.setPartida(rs.getString("Partida"));
                p.setDestino(rs.getString("Destino"));
                p.setChegada(rs.getString("Chegada"));
                p.setValor(Double.parseDouble(rs.getString("Valor")));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPassagensDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
