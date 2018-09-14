/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "caixa")
public class CaixaBEAN {

    private int caixaCodigo;
    private float caixaDinheiro;

    @Id
    @GeneratedValue
    public int getCaixaCodigo() {
        return caixaCodigo;
    }

    public void setCaixaCodigo(int caixaCodigo) {
        this.caixaCodigo = caixaCodigo;
    }

    public float getCaixaDinheiro() {
        return caixaDinheiro;
    }

    public void setCaixaDinheiro(float caixaDinheiro) {
        this.caixaDinheiro = caixaDinheiro;
    }

}
