/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autocompletardso2;

import autocompletardso2.componente.AutoCompleteBean;

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
         frame.setSize(100, 50);
         String [] valores = {"","a","aaaa","aadsfasdf","fadfsaa","asdfasdfa","atreqwr","rqwea"};
         AutoCompleteBean bean = new AutoCompleteBean(valores); // Instancia o bean
        // Alterar as propriedades que julgar necessárias aqui!
         frame.add(bean);  // Adiciona bean ao frame
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  // Exibe o frame
    }

}
