/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 *
 * @author Polo
 */
// essa classe extende JComboBox pois trata os metodos do ComboBox
public class AutoCompleteComboBox extends JComboBox {

    //caretPosition = número de letras já digitadas 
    public int caretPos = 0;
    //cria TextField para receber valores digitados
    public JTextField inputField = null;

    // construtor recebe Array elements para colocar os objetos dentro do comboBOX
    public AutoCompleteComboBox(final Object elements[]) {
        super(elements); // chama a classe mãe - colocando elements nela
        setEditor(new BasicComboBoxEditor()); // setEditor = recebe os métodos de edição de um comboBox
        // BasicComboBoxEditor - classe que contém os metodos de edição
        setEditable(true); //pode receber edição (sem ele, vc não pode digitar no comboBox )
    }

    //vai para o índice no qual o valor digitado se aproxima 
    public void setSelectedIndex(int index) {
        super.setSelectedIndex(index);

        // pega índice que contem o que foi digitado e escreve o valor em string que esta no indice
        inputField.setText(getItemAt(index).toString());

        // cria a área de seleção desde a ultima letra digitada até o final do valor encontrado no indice
        inputField.setSelectionEnd(caretPos + inputField.getText().length()); // inputField = selecionado em azul

        //move posição de caracteres do textField para a posição digitada
        inputField.moveCaretPosition(caretPos);
    }

    public void setEditor(ComboBoxEditor editor) {
        super.setEditor(editor);//editor será passado da classe mãe também
        // 
        if (editor.getEditorComponent() instanceof JTextField) {

            inputField = (JTextField) editor.getEditorComponent();

            //recebe evento para ação no teclado
            // KeyAdapter = é uma classe abstrata que possui metodos de teclado a serem implementados
            inputField.addKeyListener(new KeyAdapter() {

                // implementa método KeyReleased que chama eventos possíveis 
                public void keyReleased(KeyEvent ev) {

                    //pega valor digitado
                    char key = ev.getKeyChar();

                    //verifica se não foi digitado letra ou espaço
                    //retorna true se for diferente disso
                    if (!(Character.isLetterOrDigit(key) || Character.isSpaceChar(key))) {
                        return;
                    }

                    // a caretPos recebe valor da caretPosition do TextField (tamanho digitado)
                    caretPos = inputField.getCaretPosition();
                    //imprime valor caretPos
                    //System.out.println(caretPos);
                    String text = "";
                    try {
                        //pega texto do textField na posição 0 até a caretPos
                        text = inputField.getText(0, caretPos);
                    } //cacth para excessão de inserção de texto em local errado
                    catch (javax.swing.text.BadLocationException e) {
                        e.printStackTrace();
                    }

                    //roda um for para verificar indice por indice do combBox
                    for (int i = 0; i < getItemCount(); i++) {

                        //salva valor do comboBox no índice 'i'
                        String element = (String) getItemAt(i);

                        //verifica se esse valor inicia-se com texto digitado
                        if (element.startsWith(text)) {
                            //seleciona índice pelo que possui texto digitado
                            setSelectedIndex(i);
                            //retorna true
                            return;
                        }
                    }
                }
            });
        }
    }
}
