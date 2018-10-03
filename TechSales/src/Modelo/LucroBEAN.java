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
@Table(name = "lucro")
public class LucroBEAN {

    private int luCod;
    private float lucPorcentagem;

    @Id
    @GeneratedValue
    public int getLuCod() {
        return luCod;
    }

    public void setLuCod(int luCod) {
        this.luCod = luCod;
    }

    public float getLucPorcentagem() {
        return lucPorcentagem;
    }

    public void setLucPorcentagem(float lucPorcentagem) {
        this.lucPorcentagem = lucPorcentagem;
    }

    
}
