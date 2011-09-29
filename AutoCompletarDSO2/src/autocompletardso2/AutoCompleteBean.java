package autocompletardso2;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import java.beans.*;
import java.io.Serializable;

public class AutoCompleteBean extends JComboBox implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;

    protected JTextField campo;     
    protected List<Object> valores;
    private List<Object> busca;
    private String valorBuscado;
    
    public AutoCompleteBean() {
        super();
        propertySupport = new PropertyChangeSupport(this);
        this.busca = new ArrayList();
        this.valores = new ArrayList();
        this.setEditable(true);
        this.addKeyListener(new trataEventos());
        // pra nao atrapalhar na hora de digitar
            this.setKeySelectionManager(new KeySelectionManager() {
            @Override
            public int selectionForKey(char c, javax.swing.ComboBoxModel model)
            { return -1; }
            }); 
        
        propertySupport = new PropertyChangeSupport(this);
    }
    
    
    @Override
    public void addKeyListener(KeyListener listener)
    {
        this.campo = (JTextField) this.getEditor().getEditorComponent();
        campo.addKeyListener(listener);
    }

    private List<Object> busca(String digitada) {
        busca.clear();
                    
        for (int i=0; i<valores.size(); i++){
            String daLista = valores.get(i).toString();
            if((daLista.toLowerCase()).startsWith(digitada.toLowerCase()))
                busca.add(daLista);        
        }
        valorBuscado=digitada;
        return busca;    
    }

    private void atualiza(List<Object> busca) {
        if(busca.size()>0){
            super.setModel(new  javax.swing.DefaultComboBoxModel(busca.toArray()));
        } else {
            super.setModel(new javax.swing.DefaultComboBoxModel());
        }
        this.setPopupVisible(false);
        this.setPopupVisible(true);
        this.revalidate();        
        campo.setText(valorBuscado);
    }   

    private class trataEventos implements KeyListener 
    {
        @Override
        public void keyTyped(KeyEvent e){}

        @Override
        public void keyPressed(KeyEvent e){}

        @Override
        public void keyReleased(KeyEvent e){
        AutoCompleteBean bean = (AutoCompleteBean) campo.getParent();
            
             // ESC = volta pro comeco
            if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                bean.atualiza(valores);
                campo.setText("");
            } 
                        
            if(Character.isLetter(e.getKeyChar()) || e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                bean.atualiza(bean.busca(campo.getText()));
            }
        }
    }

    public JTextField getCampo() {
        return campo;
    }

    public void setCampo(JTextField campo) {
        this.campo = campo;
    }

    public List getValores() {
        return valores;
    }

    public void setValores(List var) {
        for( Object valor : var )
            this.valores.add(valor.toString());       
    }
    

}