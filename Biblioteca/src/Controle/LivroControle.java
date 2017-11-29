/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Genero;
import Modelo.Livro;
import Modelo.LivroDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LUCASP
 */
public class LivroControle {
    
    public static ArrayList<Livro> livros = new ArrayList<>();
    
    public Livro cadastrar(Livro l){
        
       
        
    
        livros.add(l);
        
        LivroDAO liv = new LivroDAO();
        liv.cadastrar(l);

        return l;
    
    }
    
    public ArrayList<Livro> listar(){
   
        return livros;
    
    }

    public void remover(Livro l) {
         LivroDAO lv = new LivroDAO();
         lv.remover(l);
    }

 

    public void atualizar(Livro l) {
        
        LivroDAO lv = new LivroDAO();
        lv.editar(l);
        
    }
}
