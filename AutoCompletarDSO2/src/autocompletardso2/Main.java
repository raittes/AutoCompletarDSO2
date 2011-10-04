/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autocompletardso2;

import autocompletardso2.AutoCompleteBean;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         javax.swing.JFrame frame = new javax.swing.JFrame();  // Cria frame
         frame.setSize(300, 60);
         List<String> valores = new ArrayList<String>();
         valores.add("a");
         valores.add("b");
         valores.add("c");
         valores.add("d");
         valores.add("e");
         AutoCompleteBean bean = new AutoCompleteBean(); // Instancia o bean
         bean.addKeyListener(bean);
         bean.setCaseSensitive(bean.isCaseSensitive()?false:true);
         bean.setValores(valores);
         bean.setCorDeFundo(Color.yellow);
         bean.setCorSelecionado(Color.green);
        // Alterar as propriedades que julgar necessárias aqui!
        frame.add(bean);  // Adiciona bean ao frame
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  // Exibe o frame
    }

}
