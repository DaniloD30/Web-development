/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Passagem;
import negocio.Passagens;

/**
 *
 * @author LEESE
 */
@Named(value = "passagensManagedBean")
@ViewScoped
public class PassagensManagedBean implements Serializable {
     private List<Passagem> passagens;
     
    private Passagem selectedPassagem;
     
    @ManagedProperty("#{passagemService}")
    private PassagemService service;
     
    @PostConstruct
    public void init() {
        passagens = service.createPassagens();
    }
 
    public List<Passagem> getCars() {
        return passagens;
    }
 
    public void setService(PassagemService service) {
        this.service = service;
    }
 
    public Passagem getSelectedPassagem() {
        return selectedPassagem;
    }
 
    public void setSelectedPassagem(Passagem selectedPassagem) {
        this.selectedPassagem = selectedPassagem;
    }
}
