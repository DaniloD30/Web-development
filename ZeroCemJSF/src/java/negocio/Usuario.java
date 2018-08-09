/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Random;

/**
 *
 * @author aluno
 */
public class Usuario {
    private Random r = new Random();
    private int numSorteado;
    private int numUsuario;
    
    public Usuario(){
        this.numSorteado = r.nextInt(101);
    }
    
    public String play(){
        if(this.getNumUsuario() < this.numSorteado)
            return "O seu numero é menor que o número sorteado";
        if(this.getNumUsuario() > this.numSorteado)
            return "O seu numero é maior que o número sorteado";
        this.numSorteado = r.nextInt(101);
        return "Acertou !";
        
    }

    public int getNumUsuario() {
        return numUsuario;
    }

    public void setNumUsuario(int numUsuario) {
        this.numUsuario = numUsuario;
    }
    
    
}
