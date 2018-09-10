/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.istack.internal.Nullable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    private JogoBEAN jogo;
    private CategoriaBEAN categoria;
    private ConsoleBEAN console;
    

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

    @OneToOne
    @JoinColumn(name="luc_joCodigo")
    public JogoBEAN getJogo() {
        return jogo;
    }

    public void setJogo(JogoBEAN jogo) {
        this.jogo = jogo;
    }

    @OneToOne
    @JoinColumn(name="luc_joCodigo")
    public CategoriaBEAN getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBEAN categoria) {
        this.categoria = categoria;
    }

    @OneToOne
    @JoinColumn(name="luc_joCodigo")
    public ConsoleBEAN getConsole() {
        return console;
    }

    public void setConsole(ConsoleBEAN console) {
        this.console = console;
    }

    
}
