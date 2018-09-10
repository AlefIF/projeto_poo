/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "jogo_locacao")
public class Jogo_LocacaoBEAN {

    @EmbeddedId
    private JogoLocacaoPK chaveComposta;

    public JogoLocacaoPK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(JogoLocacaoPK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

}
