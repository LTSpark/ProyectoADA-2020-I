/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class VentanaEmp extends JFrame implements ActionListener{
    private final JPanel panelEmpleado = new JPanel();
    private JTextField txtId, txtNombre, txtApellido, txtFuncion; 
    private JButton btnSeleccionar, btnAtras;
    private JTable tablaMaquinas;
    
    public VentanaEmp(){
        super("Empleado");
        initComponents();
    }
    
    public void initComponents(){
        setBounds(300, 300, 450, 550);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(getPanelEmpleado());
        
        FlowLayout layout = new FlowLayout(); 
        layout.setHgap(90);
        layout.setVgap(20);
        layout.setAlignment(FlowLayout.RIGHT);
        getPanelEmpleado().setLayout(layout);
        
        setTxtId(new JTextField(10));
        getTxtId().setEditable(false);
        setTxtNombre(new JTextField(10));
        getTxtNombre().setEditable(false);
        setTxtApellido(new JTextField(10));
        getTxtApellido().setEditable(false);
        setTxtFuncion(new JTextField(10));
        getTxtFuncion().setEditable(false);
        
        getPanelEmpleado().add(new JLabel("ID: "));
        getPanelEmpleado().add(getTxtId());
        getPanelEmpleado().add(new JLabel("Nombre: "));
        getPanelEmpleado().add(getTxtNombre());
        getPanelEmpleado().add(new JLabel("Apellido: "));
        getPanelEmpleado().add(getTxtApellido()); 
        getPanelEmpleado().add(new JLabel("Función: "));
        getPanelEmpleado().add(getTxtFuncion());
        
        setBtnSeleccionar(new JButton("Seleccionar"));
        setBtnAtras(new JButton("Atrás"));
        
        Object rows[][] = {};
        String columns[] = {"ID", "Función"};
        
        setTablaMaquinas(new JTable(rows, columns));
        getTablaMaquinas().setModel(new DefaultTableModel(
            rows, columns));
        
        getTablaMaquinas().getColumnModel().getColumn(0).setPreferredWidth(50);
        getTablaMaquinas().getColumnModel().getColumn(1).setPreferredWidth(200);
        
        JScrollPane jsp = new JScrollPane(getTablaMaquinas());
        
        jsp.setPreferredSize(new Dimension(250, 250));
        
        getPanelEmpleado().add(jsp);
          
        getPanelEmpleado().add(getBtnSeleccionar());
        getPanelEmpleado().add(getBtnAtras());
        
        getBtnAtras().addActionListener(this);
        getBtnSeleccionar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == getBtnAtras()){
            VentanaInicio vI = new VentanaInicio();
            dispose();
        }
    }

    /**
     * @return the panelEmpleado
     */
    public JPanel getPanelEmpleado() {
        return panelEmpleado;
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
     * @return the txtNombre
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * @param txtNombre the txtNombre to set
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * @return the txtApellido
     */
    public JTextField getTxtApellido() {
        return txtApellido;
    }

    /**
     * @param txtApellido the txtApellido to set
     */
    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    /**
     * @return the txtFuncion
     */
    public JTextField getTxtFuncion() {
        return txtFuncion;
    }

    /**
     * @param txtFuncion the txtFuncion to set
     */
    public void setTxtFuncion(JTextField txtFuncion) {
        this.txtFuncion = txtFuncion;
    }

    /**
     * @return the btnSeleccionar
     */
    public JButton getBtnSeleccionar() {
        return btnSeleccionar;
    }

    /**
     * @param btnSeleccionar the btnSeleccionar to set
     */
    public void setBtnSeleccionar(JButton btnSeleccionar) {
        this.btnSeleccionar = btnSeleccionar;
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
     * @return the tablaMaquinas
     */
    public JTable getTablaMaquinas() {
        return tablaMaquinas;
    }

    /**
     * @param tablaMaquinas the tablaMaquinas to set
     */
    public void setTablaMaquinas(JTable tablaMaquinas) {
        this.tablaMaquinas = tablaMaquinas;
    }
}
