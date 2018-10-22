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
@Table(name = "localRelatorio")
public class LocalRelatoriosBEAN {

    int relCodigo;
    String relLocal;

    @Id
    @GeneratedValue
    public int getRelCodigo() {
        return relCodigo;
    }

    public void setRelCodigo(int relCodigo) {
        this.relCodigo = relCodigo;
    }

    public String getRelLocal() {
        return relLocal;
    }

    public void setRelLocal(String relLocal) {
        this.relLocal = relLocal;
    }

}
