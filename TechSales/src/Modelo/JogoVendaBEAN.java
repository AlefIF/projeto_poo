/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "jogo_venda")
public class JogoVendaBEAN {

    @EmbeddedId
    private JogoVendaPK chaveComposta;

    @Column(name = "qdt")
    private int quantidade;
    @Column(name = "preco")
    private float precoUnitarioReal;

    public JogoVendaPK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(JogoVendaPK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitarioReal() {
        return precoUnitarioReal;
    }

    public void setPrecoUnitarioReal(float precoUnitarioReal) {
        this.precoUnitarioReal = precoUnitarioReal;
    }

}
