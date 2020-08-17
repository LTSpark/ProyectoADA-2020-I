/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class VentanaMaq extends JFrame{
    private final JPanel panelMaquina = new JPanel();
    private JTextField txtId, txtTipo, txtModelo;
    private JButton btnAtras;
    private JTable tablaLotes;
    
    protected JButton btnAccion;
    
    public VentanaMaq(){
        super("AS");
        initComponents();
    }
    
    public void initComponents(){
        setBounds(300, 300, 400, 550);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(getPanelMaquina());
        
        FlowLayout layout = new FlowLayout(); 
        layout.setHgap(90);
        layout.setVgap(20);
        layout.setAlignment(FlowLayout.RIGHT);
        getPanelMaquina().setLayout(layout);      
        
        setTxtId(new JTextField(10));
        getTxtId().setEditable(false);
        setTxtTipo(new JTextField(10));
        getTxtTipo().setEditable(false);
        setTxtModelo(new JTextField(10));
        getTxtModelo().setEditable(false);
        
        getPanelMaquina().add(new JLabel("ID: "));
        
        getPanelMaquina().add(getTxtId());
        getPanelMaquina().add(new JLabel("Tipo: "));
        getPanelMaquina().add(getTxtTipo());
        getPanelMaquina().add(new JLabel("Modelo: "));
        getPanelMaquina().add(getTxtModelo()); 

        setBtnAtras(new JButton("Atrás"));
        
        Object rows[][] = {};
        String columns[] = {"Lote", "Cantidad"};
        
        setTablaLotes(new JTable(rows, columns));
        getTablaLotes().setModel(new DefaultTableModel(
            rows, columns));
        
        getTablaLotes().getColumnModel().getColumn(0).setPreferredWidth(50);
        getTablaLotes().getColumnModel().getColumn(1).setPreferredWidth(200);
        
        JScrollPane jsp = new JScrollPane(getTablaLotes());
        
        jsp.setPreferredSize(new Dimension(250, 250));
        
        getPanelMaquina().add(jsp);
        getPanelMaquina().add(getBtnAtras());
     
    }

    /**
     * @return the panelMaquina
     */
    public JPanel getPanelMaquina() {
        return panelMaquina;
    }

    /**
     * @return the txtId
     */
    public JTextField getTxtId() {
        return txtId;
    }

    /**
     * @param txtId the txtId to set
     */
    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    /**
     * @return the txtTipo
     */
    public JTextField getTxtTipo() {
        return txtTipo;
    }

    /**
     * @param txtTipo the txtTipo to set
     */
    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
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
     * @return the tablaLotes
     */
    public JTable getTablaLotes() {
        return tablaLotes;
    }

    /**
     * @param tablaLotes the tablaLotes to set
     */
    public void setTablaLotes(JTable tablaLotes) {
        this.tablaLotes = tablaLotes;
    }
    
}

class VentanaMaqOrd extends VentanaMaq{
    
    public VentanaMaqOrd(){
        super();
        btnAccion = new JButton("Ordenar");
        super.getPanelMaquina().add(btnAccion);
    }
}

class VentanaMaqCort extends VentanaMaq{
    
    public VentanaMaqCort(){
        super();
        btnAccion = new JButton("Cortar");
        super.getPanelMaquina().add(btnAccion);
    }
}
