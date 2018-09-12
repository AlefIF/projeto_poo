/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alef
 */
@Entity
public class Item_VendaBEAN {

    private int iv_venCodigo;
    private int iv_joCodigo;
    private int vQtd;
    private float ivPrecoUnitReal;
    private JogoBEAN jogo;
    private VendaBEAN venda;

    @Id
    @GeneratedValue
    public int getIv_venCodigo() {
        return iv_venCodigo;
    }

    public void setIv_venCodigo(int iv_venCodigo) {
        this.iv_venCodigo = iv_venCodigo;
    }

    public int getIv_joCodigo() {
        return iv_joCodigo;
    }

    public void setIv_joCodigo(int iv_joCodigo) {
        this.iv_joCodigo = iv_joCodigo;
    }

    public int getvQtd() {
        return vQtd;
    }

    public void setvQtd(int vQtd) {
        this.vQtd = vQtd;
    }

    public float getIvPrecoUnitReal() {
        return ivPrecoUnitReal;
    }

    public void setIvPrecoUnitReal(float ivPrecoUnitReal) {
        this.ivPrecoUnitReal = ivPrecoUnitReal;
    }

    @ManyToOne
    public JogoBEAN getJogo() {
        return jogo;
    }

    public void setJogo(JogoBEAN jogo) {
        this.jogo = jogo;
    }

    @ManyToOne
    public VendaBEAN getVenda() {
        return venda;
    }

    public void setVenda(VendaBEAN venda) {
        this.venda = venda;
    }

    public String getJogos() {
        return jogos;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    String jogos = "a";
    int qtd = 1;
    float preco = 1;

    public Item_VendaBEAN renomear(ArrayList<VendaBEAN> vba, ArrayList<Item_VendaBEAN> tvb, ArrayList<JogoBEAN> jgL) {
        Item_VendaBEAN iOa = new Item_VendaBEAN();
        for (VendaBEAN vO : vba) {
            for (Item_VendaBEAN iO : tvb) {
                if (vO.getVenCodigo() == iO.getIv_venCodigo()) {
                    for (JogoBEAN jg : jgL) {
                        if (iO.getIv_joCodigo() == jg.getJoCodigo()) {
                            String jogo = jg.getJoNome();
                            qtd = iO.getvQtd();
                            preco = iO.getIvPrecoUnitReal();

                        }
                    }
                }
            }
        }
        return iOa;
    }

    @Override
    public String toString() {
        return jogo + "/" + preco + "/" + qtd;
    }

}
