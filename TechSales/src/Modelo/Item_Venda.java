/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alef
 */
public class Item_Venda {
   private int iv_venCodigo;
   private int iv_joCodigo;
   private int vQtd;
   private Float ivPrecoUnitReal;

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
   
            
}
