/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Passagem;

/**
 *
 * @author LEESE
 */
public interface DAOPassagens {
     public boolean addPassagem(Passagem passagem) ;
     public List buscarTodasPassagens();
}
