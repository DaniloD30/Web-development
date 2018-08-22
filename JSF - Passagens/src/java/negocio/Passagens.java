/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import DAO.DAOPassagensDerby;
import java.util.List;
import model.Passagem;

/**
 *
 * @author LEESE
 */
public class Passagens {

    private Passagem local;
    private DAOPassagensDerby dao;

    public Passagens() {
        this.local = new Passagem();
        this.dao = new DAOPassagensDerby();
    }

    public boolean addPassagem() {
        return this.dao.addPassagem(local);
    }

    public List getPassagens() {
        return dao.buscarTodasPassagens();
    }

    public String getPassageiro() {
        return this.local.getPassageiro();
    }

    public void setPassageiro(String passageiro) {
        this.local.setPassageiro(passageiro);
    }

    public String getCpf() {
        return this.local.getCpf();
    }

    public void setCpf(String cpf) {
        this.local.setCpf(cpf);
    }

    public String getNascimento() {
        return this.local.getNascimento();
    }

    public void setNascimento(String nascimento) {
        this.local.setNascimento(nascimento);
    }

    public String getOrigem() {
        return this.local.getOrigem();
    }

    public void setOrigem(String origem) {
        this.local.setOrigem(origem);
    }

    public String getPartida() {
        return this.local.getPartida();
    }

    public void setPartida(String partida) {
        this.local.setPartida(partida);
    }

    public String getDestino() {
        return this.local.getDestino();
    }

    public void setDestino(String destino) {
        this.local.setDestino(destino);
    }

    public String getChegada() {
        return this.local.getChegada();
    }

    public void setChegada(String chegada) {
        this.local.setChegada(chegada);
    }

    public double getValor() {
        return this.local.getValor();
    }

    public void setValor(double valor) {
        this.local.setValor(valor);
    }

}
