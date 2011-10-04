package autocompletardso2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.beans.*;
import java.io.Serializable;

public class AutoCompleteBean extends JComboBox implements Serializable, KeyListener{
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;

    protected JTextField campo;     
    protected List<Object> valores;
    private List<Object> busca;
    private String valorBuscado;
    private boolean caseSensitive;
    private Color corSelecionado;
    private Color corDeFundo;
    private Font fonte;
    
    public AutoCompleteBean() {
        super();
        propertySupport = new PropertyChangeSupport(this);
        this.busca = new ArrayList();
        this.valores = new ArrayList();
        this.setEditable(true);
        // pra nao atrapalhar na hora de digitar
            this.setKeySelectionManager(new KeySelectionManager() {
            @Override
            public int selectionForKey(char c, javax.swing.ComboBoxModel model)
            { return -1; }
            }); 
        addKeyListener();
        corDeFundo = Color.gray;
        corSelecionado = Color.lightGray;
        fonte = Font.getFont(Font.SANS_SERIF);
        this.getEditor().getEditorComponent().setFont(fonte);
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public void addKeyListener()
    {
        this.campo = (JTextField) this.getEditor().getEditorComponent();
        campo.addKeyListener(this);
    }

    private List<Object> busca(String digitada) {
        busca.clear();
                    
        for (int i=0; i<valores.size(); i++){
            String daLista = valores.get(i).toString();
            if((isCaseSensitive()?daLista:daLista.toLowerCase()).startsWith(isCaseSensitive()?digitada:digitada.toLowerCase()))
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

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public Color getCorDeFundo() {
        return corDeFundo;
    }

    public void setCorDeFundo(Color corDeFundo) {
        this.corDeFundo = corDeFundo;
        this.getCampo().setBackground(corDeFundo);
    }

    public Color getCorSelecionado() {
        return corSelecionado;
    }

    public void setCorSelecionado(Color corSelecionado) {
        this.corSelecionado = corSelecionado;
        this.getCampo().setSelectionColor(corSelecionado);
    }

    public Font getFonte() {
        return fonte;
    }

    public void setFonte(Font fonte) {
        this.fonte = fonte;
        getCampo().setFont(fonte);
    }   

}