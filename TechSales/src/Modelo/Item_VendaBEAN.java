/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.ItemVendaControle;
import Controle.JogoControle;
import Controle.VendaControle;
import java.util.ArrayList;

/**
 *
 * @author Alef
 */
public class Item_VendaBEAN {

    private int iv_venCodigo;
    private int iv_joCodigo;
    private int vQtd;
    private Float ivPrecoUnitReal;

    String jogo = "a";
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

    public Float getIvPrecoUnitReal() {
        return ivPrecoUnitReal;
    }

    public void setIvPrecoUnitReal(Float ivPrecoUnitReal) {
        this.ivPrecoUnitReal = ivPrecoUnitReal;
    }

    @Override
    public String toString() {
        return jogo + "/" + preco + "/" + qtd;
    }

}
