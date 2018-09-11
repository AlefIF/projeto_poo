/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alef
 */
@Embeddable
public class JogoLocacaoPK implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "joCod")
    private JogoBEAN jogo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venCod")
    private LocacaoBEAN locacao;

    public JogoBEAN getJogo() {
        return jogo;
    }

    public void setJogo(JogoBEAN jogo) {
        this.jogo = jogo;
    }

    public LocacaoBEAN getLocacao() {
        return locacao;
    }

    public void setLocacao(LocacaoBEAN locacao) {
        this.locacao = locacao;
    }

}
