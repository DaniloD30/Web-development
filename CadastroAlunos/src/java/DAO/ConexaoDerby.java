/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LEESE
 */
public class ConexaoDerby {
     private ConexaoDerby() {
    }

    public static ConexaoDerby getInstancia() {
        if (instancia==null){   
            instancia = new ConexaoDerby();
        }
        return instancia;
    }

    public Connection getConn() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/AlunoNotas","dod","300198");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    private static ConexaoDerby instancia;
    private Connection conn;
}
