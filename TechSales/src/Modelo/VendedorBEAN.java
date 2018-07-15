/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "vendedor")
public class VendedorBEAN {

    private int venCodigo;
    private String venNomeUsuario;
    private String venSenha;
    private int ven_funCodigo;
    private List<LocacaoBEAN> loc;
    private List<DevolucaoBEAN> dev;
    private List<VendaBEAN> venda;

    @Id
    @GeneratedValue
    public int getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(int venCodigo) {
        this.venCodigo = venCodigo;
    }

    public String getVenNomeUsuario() {
        return venNomeUsuario;
    }

    public void setVenNomeUsuario(String venNomeUsuario) {
        this.venNomeUsuario = venNomeUsuario;
    }

    public String getVenSenha() {
        return venSenha;
    }

    public void setVenSenha(String venSenha) {
        this.venSenha = venSenha;
    }

    public int getVen_funCodigo() {
        return ven_funCodigo;
    }

    public void setVen_funCodigo(int ven_funCodigo) {
        this.ven_funCodigo = ven_funCodigo;
    }

    @OneToMany(mappedBy = "loc_venCodigo")
    @Column(nullable = true)
    public List<LocacaoBEAN> getLoc() {
        return loc;
    }

    public void setLoc(List<LocacaoBEAN> loc) {
        this.loc = loc;
    }

    @OneToMany(mappedBy = "dev_venCodigo")
    @Column(nullable = true)
    public List<DevolucaoBEAN> getDev() {
        return dev;
    }

    public void setDev(List<DevolucaoBEAN> dev) {
        this.dev = dev;
    }

    @OneToMany(mappedBy = "venda_venCodigo")
    @Column(nullable = true)
    public List<VendaBEAN> getVenda() {
        return venda;
    }

    public void setVenda(List<VendaBEAN> venda) {
        this.venda = venda;
    }

}
