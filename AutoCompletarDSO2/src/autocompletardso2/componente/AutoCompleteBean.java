/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autocompletardso2.componente;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author marcos
 */
public class AutoCompleteBean extends JComboBox implements KeyListener{

    JTextArea texto = (JTextArea) this.getEditor().getEditorComponent();
    private boolean isNoCase;
    public AutoCompleteBean(String[] valores) {
        super(valores);
        this.setEditable(true);
        texto.addKeyListener(this);
    }




    public void keyTyped(KeyEvent ke) {
        //System.out.println(this.getItemAt(0));
        int count = this.getItemCount();
        List contem = new ArrayList<Object>();
        for(int i =0; i<count; i++ ){
            if(setaParaUpperCase(this.getItemAt(i).toString()).contains(texto.getText()));
        }
        this.showPopup();

    }

    public void keyPressed(KeyEvent ke) {
        //System.out.println(this.getItemAt(0));
    }

    public void keyReleased(KeyEvent ke) {
        //System.out.println(this.getItemAt(0));
    }
    private String setaParaUpperCase(String string){
        if(isNoCase){
            return string.toUpperCase();
        }
        return string;
    }

    

}
