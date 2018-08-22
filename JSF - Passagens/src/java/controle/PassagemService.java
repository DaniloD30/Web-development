/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Passagem;
import negocio.Passagens;

/**
 *
 * @author LEESE
 */
@Named(value = "passagemService")
@ApplicationScoped
public class PassagemService {

    /**
     * Creates a new instance of PassagemService
     */
    public PassagemService() {
    }
    private Passagens passagens;
    public List<Passagem> createPassagens() {
        List<Passagem> list = new ArrayList<Passagem>();
        list = passagens.getPassagens();
         
        return list;
    }
     
 
     
}
