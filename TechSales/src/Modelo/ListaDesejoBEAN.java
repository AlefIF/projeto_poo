/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "listaDesejo")
public class ListaDesejoBEAN {

    private int lisCodigo;
    private String lisNomeJogo;
    private String lisPlataforma;
    private ClienteBEAN cliente;

    @Id
    @GeneratedValue
    public int getLisCodigo() {
        return lisCodigo;
    }

    public void setLisCodigo(int lisCodigo) {
        this.lisCodigo = lisCodigo;
    }

    public String getLisNomeJogo() {
        return lisNomeJogo;
    }

    public void setLisNomeJogo(String lisNomeJogo) {
        this.lisNomeJogo = lisNomeJogo;
    }

    public String getLisPlataforma() {
        return lisPlataforma;
    }

    public void setLisPlataforma(String lisPlataforma) {
        this.lisPlataforma = lisPlataforma;
    }

    @ManyToOne
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

}
