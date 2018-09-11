/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author LUCASP
 */
@Entity
@Table(name = "funcionario")
public class FuncionarioBEAN {

    private int funCodigo;
    private String funNome;
    private int funIdade;
    private String funEndereco;
    private String funCpf;
    private String funTelefone;
    private String funNisPis;
    private float funSalario;
    private String funTrabalho;
    private EnderecoBEAN endereco;
    private caixaBEAN caixa;
    private EmpregoBEAN emprego;

    @Id
    @GeneratedValue
    public int getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(int funCodigo) {
        this.funCodigo = funCodigo;
    }

    public String getFunNome() {
        return funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public int getFunIdade() {
        return funIdade;
    }

    public void setFunIdade(int funIdade) {
        this.funIdade = funIdade;
    }

    public String getFunEndereco() {
        return funEndereco;
    }

    public void setFunEndereco(String funEndereco) {
        this.funEndereco = funEndereco;
    }

    public String getFunCpf() {
        return funCpf;
    }

    public void setFunCpf(String funCpf) {
        this.funCpf = funCpf;
    }

    public String getFunTelefone() {
        return funTelefone;
    }

    public void setFunTelefone(String funTelefone) {
        this.funTelefone = funTelefone;
    }

    public String getFunNisPis() {
        return funNisPis;
    }

    public void setFunNisPis(String funNisPis) {
        this.funNisPis = funNisPis;
    }

    public float getFunSalario() {
        return funSalario;
    }

    public void setFunSalario(float funSalario) {
        this.funSalario = funSalario;
    }

    public String getFunTrabalho() {
        return funTrabalho;
    }

    public void setFunTrabalho(String funTrabalho) {
        this.funTrabalho = funTrabalho;
    }
    
    @Embedded
    public EnderecoBEAN getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBEAN endereco) {
        this.endereco = endereco;
    }

    @ManyToOne
    @JoinColumn(name="fun_caixaCodigo")
    public caixaBEAN getCaixa() {
        return caixa;
    }

    public void setCaixa(caixaBEAN caixa) {
        this.caixa = caixa;
    }

    @ManyToOne
    @JoinColumn(name="fun_empCodigo")
    public EmpregoBEAN getEmprego() {
        return emprego;
    }

    public void setEmprego(EmpregoBEAN emprego) {
        this.emprego = emprego;
    }
    
    
    
    

}
