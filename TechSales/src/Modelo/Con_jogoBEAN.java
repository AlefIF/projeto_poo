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
 * @author admin
 */
@Entity
@Table(name="con_jogo")
public class Con_jogoBEAN {

    private int cjg_conCodigo;
    private int cjg_joCodigo;

    @Id
    @GeneratedValue
    public int getCjg_conCodigo() {
        return cjg_conCodigo;
    }

    public void setCjg_conCodigo(int cjg_conCodigo) {
        this.cjg_conCodigo = cjg_conCodigo;
    }

    public int getCjg_joCodigo() {
        return cjg_joCodigo;
    }

    public void setCjg_joCodigo(int cjg_joCodigo) {
        this.cjg_joCodigo = cjg_joCodigo;
    }

}
