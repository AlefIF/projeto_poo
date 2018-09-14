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
@Table(name = "emprego")
public class EmpregoBEAN {
    private int empCodigo;
    private String empNome;
    private String empDescricao;
    private float empSalarioPadrao;

    @Id
    @GeneratedValue
    public int getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(int empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getEmpNome() {
        return empNome;
    }

    public void setEmpNome(String empNome) {
        this.empNome = empNome;
    }

    public String getEmpDescricao() {
        return empDescricao;
    }

    public void setEmpDescricao(String empDescricao) {
        this.empDescricao = empDescricao;
    }

    public float getEmpSalarioPadrao() {
        return empSalarioPadrao;
    }

    public void setEmpSalarioPadrao(float empSalarioPadrao) {
        this.empSalarioPadrao = empSalarioPadrao;
    }
    
    @Override
    public String toString() {
        return getEmpNome();
    }
}
