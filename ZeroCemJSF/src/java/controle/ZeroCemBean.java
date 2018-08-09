/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import negocio.Usuario;

/**
 *
 * @author aluno
 */
@Named(value = "zeroCemBean")
@SessionScoped
public class ZeroCemBean implements Serializable {

    /**
     * Creates a new instance of ZeroCemBean
     */
    private Usuario usuario;
    
    public ZeroCemBean() {
        usuario = new Usuario();
    }
    public Usuario getUsuario(){
        return usuario;
    }
    
     public void playZeroCem(){
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(" ",  this.usuario.play() ) );
    
    }
    
}
