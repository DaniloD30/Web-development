/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Random;

/**
 *
 * @author LEESE
 */
public class ZeroCem {
    private int numeroSorteado;
    private int numeroUsuario;
    public ZeroCem(int numeroUsuario){
        this.setNumeroSorteado(this.sortearNumero());
        this.setNumeroUsuario(numeroUsuario);
    }
    public int sortearNumero(){
        Random r = new Random();
        int number = r.nextInt(101);
        return number;
    }
    public String jogar(){
        if(this.getNumeroUsuario() > this.getNumeroSorteado())
            return "Numero digitado Maior";
        if(this.getNumeroUsuario() < this.getNumeroSorteado())
            return "Numero digitado Menor";
        return "Numero correto, voce venceu o jogo!";
    }
    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public int getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }
    
    
    
}
