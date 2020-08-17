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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class VentanaAgregarEmpleado extends JFrame implements ActionListener{
    private final JPanel panelAgregarEmpleado = new JPanel();
    private JTextField txtId, txtNombre, txtApellido; 
    private JButton btnAgregar, btnAtras;
    private Choice chFuncion;
    
    public VentanaAgregarEmpleado(){
        super("Agregar Empleado");
        initComponents();
    }
    
    public void initComponents(){
        setBounds(300, 300, 400, 350);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(getPanelAgregarEmpleado());
        
        FlowLayout layout = new FlowLayout(); 
        layout.setHgap(90);
        layout.setVgap(30);
        layout.setAlignment(FlowLayout.RIGHT);
        getPanelAgregarEmpleado().setLayout(layout);
        
        setTxtId(new JTextField(10));
        setTxtNombre(new JTextField(10));
        setTxtApellido(new JTextField(10));
        
        setBtnAgregar(new JButton("Agregar"));
        setBtnAtras(new JButton("Atrás"));
        
        setChFuncion(new Choice());
        getChFuncion().add("----");
        getChFuncion().add("Cortador");
        getChFuncion().add("Ordenador");
        
        getPanelAgregarEmpleado().add(new JLabel("ID: "));
        getPanelAgregarEmpleado().add(getTxtId());
        getPanelAgregarEmpleado().add(new JLabel("Nombre: "));
        getPanelAgregarEmpleado().add(getTxtNombre());
        getPanelAgregarEmpleado().add(new JLabel("Apellido: "));
        getPanelAgregarEmpleado().add(getTxtApellido());
        getPanelAgregarEmpleado().add(new JLabel("Función: "));
        getPanelAgregarEmpleado().add(getChFuncion());
        
        getPanelAgregarEmpleado().add(getBtnAgregar());
        getPanelAgregarEmpleado().add(getBtnAtras());
        
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
     * @return the panelAgregarEmpleado
     */
    public JPanel getPanelAgregarEmpleado() {
        return panelAgregarEmpleado;
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
     * @return the chFuncion
     */
    public Choice getChFuncion() {
        return chFuncion;
    }

    /**
     * @param chFuncion the chFuncion to set
     */
    public void setChFuncion(Choice chFuncion) {
        this.chFuncion = chFuncion;
    }
}
