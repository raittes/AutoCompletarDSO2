/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autocompletardso2;

import autocompletardso2.AutoCompleteBean;

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
         //List<String> valores = {"","Ana","Ananda","Ananda Silva","Ana Lucia","Barbara","Bruna","Joao","Joana","Joao Paulo","Mauro","Marcos","Marcos Paulo"};
         AutoCompleteBean bean = new AutoCompleteBean(); // Instancia o bean
         //bean.setValores(valores);
        // Alterar as propriedades que julgar necessárias aqui!
        frame.add(bean);  // Adiciona bean ao frame
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  // Exibe o frame
    }

}
