/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class VentanaAgregarMaquina extends JFrame implements ActionListener{
    private JPanel panelAgregarMaquina = new JPanel();
    private JTextField txtId, txtModelo; 
    private JButton btnAgregar, btnAtras;
    private Choice chTipo;
    
    public VentanaAgregarMaquina(){
        super("Agregar Máquina");
        initComponents();
    }
    
    public void initComponents(){
        setBounds(300, 300, 400, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(getPanelAgregarMaquina());
        
        FlowLayout layout = new FlowLayout(); 
        layout.setHgap(90);
        layout.setVgap(30);
        layout.setAlignment(FlowLayout.RIGHT);
        getPanelAgregarMaquina().setLayout(layout);
        
        txtId = new JTextField(10);
        setTxtModelo(new JTextField(10));
        
        setBtnAgregar(new JButton("Agregar"));
        setBtnAtras(new JButton("Atrás"));
        
        setChTipo(new Choice());
        getChTipo().add("----");
        getChTipo().add("Cortadora");
        getChTipo().add("Ordenadora");
        
        getPanelAgregarMaquina().add(new JLabel("Id: "));
        getPanelAgregarMaquina().add(getTxtId());
        getPanelAgregarMaquina().add(new JLabel("Modelo: "));
        getPanelAgregarMaquina().add(getTxtModelo());
        getPanelAgregarMaquina().add(new JLabel("Tipo: "));
        getPanelAgregarMaquina().add(getChTipo());
        
        getPanelAgregarMaquina().add(getBtnAgregar());
        getPanelAgregarMaquina().add(getBtnAtras());
        
        getBtnAtras().addActionListener(this);
        getBtnAgregar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == getBtnAtras()){
            VentanaInicio vI = new VentanaInicio();
            dispose();
        }
    }

    /**
     * @return the panelAgregarMaquina
     */
    public JPanel getPanelAgregarMaquina() {
        return panelAgregarMaquina;
    }

    /**
     * @param panelAgregarMaquina the panelAgregarMaquina to set
     */
    public void setPanelAgregarMaquina(JPanel panelAgregarMaquina) {
        this.panelAgregarMaquina = panelAgregarMaquina;
    }

    /**
     * @return the txtId
     */
    public JTextField getTxtId() {
        return txtId;
    }

    /**
     * @return the txtModelo
     */
    public JTextField getTxtModelo() {
        return txtModelo;
    }

    /**
     * @param txtModelo the txtModelo to set
     */
    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }

    /**
     * @return the btnAgregar
     */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    /**
     * @param btnAgregar the btnAgregar to set
     */
    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    /**
     * @return the btnAtras
     */
    public JButton getBtnAtras() {
        return btnAtras;
    }

    /**
     * @param btnAtras the btnAtras to set
     */
    public void setBtnAtras(JButton btnAtras) {
        this.btnAtras = btnAtras;
    }

    /**
     * @return the chTipo
     */
    public Choice getChTipo() {
        return chTipo;
    }

    /**
     * @param chTipo the chTipo to set
     */
    public void setChTipo(Choice chTipo) {
        this.chTipo = chTipo;
    }
    
    
}
