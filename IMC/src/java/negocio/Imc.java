/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author LEESE
 */
public class Imc {
    private double peso;
    private double altura;
    
    public Imc(double peso, double altura){
        this.setPeso(peso);
        this.setAltura(altura);
    }
    public double calculationImc(){
        return this.getPeso()/(this.getAltura()*this.getAltura());
    }
    public String getResult(double imc){
        if(imc < 25)
            return "Peso Normal";
        if(imc >= 25 && imc <= 30)
            return "Sobre Peso";
        return "Obesidade";
    }
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
}
