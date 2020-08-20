/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class VentanaInicio extends JFrame implements ActionListener{
    private final JPanel panelPrincipal = new JPanel();
    private JButton btnAgregarEmpleado, btnAgregarMaquina, btnIniciarProceso, btnSalir,
            btnEliminarEmpleado, btnEliminarMaquina;
    
    public VentanaInicio(){
        super("Administrador de Máquinas");
        initComponents();
    }
    
    public void initComponents(){
        setBounds(300, 300, 350, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(getPanelPrincipal());
        
        FlowLayout layout = new FlowLayout(); 
        layout.setHgap(100);
        layout.setVgap(50);
        layout.setAlignment(FlowLayout.CENTER);
        getPanelPrincipal().setLayout(layout);
        
        setBtnAgregarEmpleado(new JButton("Agregar Empleado"));
        setBtnAgregarMaquina(new JButton("Agregar Máquina"));
        setBtnIniciarProceso(new JButton("Iniciar Proceso"));
        setBtnEliminarEmpleado(new JButton("Eliminar Empleado"));
        setBtnEliminarMaquina(new JButton("Eliminar Máquina"));
        setBtnSalir(new JButton("Salir"));
        
        getBtnAgregarEmpleado().addActionListener(this);
        getBtnAgregarMaquina().addActionListener(this);
        getBtnIniciarProceso().addActionListener(this);
        getBtnSalir().addActionListener(this);
        getBtnEliminarEmpleado().addActionListener(this);
        getBtnEliminarMaquina().addActionListener(this);
        
        getPanelPrincipal().add(getBtnAgregarEmpleado());
        getPanelPrincipal().add(getBtnAgregarMaquina());
        getPanelPrincipal().add(getBtnIniciarProceso());
        getPanelPrincipal().add(getBtnEliminarEmpleado());
        getPanelPrincipal().add(getBtnEliminarMaquina());
        getPanelPrincipal().add(getBtnSalir());
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == getBtnAgregarEmpleado()){
            VentanaAgregarEmpleado vAgEmp = new VentanaAgregarEmpleado();
            dispose();
        }
            
        if(ev.getSource() == getBtnAgregarMaquina()){
            VentanaAgregarMaquina vAgMaq = new VentanaAgregarMaquina();
            dispose();
        }
        
        if(ev.getSource() == getBtnIniciarProceso()){
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de empleado: "));
            VentanaEmp vEmp = new VentanaEmp();
            dispose();
        }
        
        if(ev.getSource() == getBtnSalir()){
            System.exit(0);
        }
        
        if(ev.getSource() == getBtnEliminarEmpleado()){
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de empleado a eliminar: "));
        }
        
        if(ev.getSource() == getBtnEliminarMaquina()){
            int Id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de la maquina a eliminar: "));
        }
    }

    /**
     * @return the panelPrincipal
     */
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    /**
     * @return the btnAgregarEmpleado
     */
    public JButton getBtnAgregarEmpleado() {
        return btnAgregarEmpleado;
    }

    /**
     * @param btnAgregarEmpleado the btnAgregarEmpleado to set
     */
    public void setBtnAgregarEmpleado(JButton btnAgregarEmpleado) {
        this.btnAgregarEmpleado = btnAgregarEmpleado;
    }

    /**
     * @return the btnAgregarMaquina
     */
    public JButton getBtnAgregarMaquina() {
        return btnAgregarMaquina;
    }

    /**
     * @param btnAgregarMaquina the btnAgregarMaquina to set
     */
    public void setBtnAgregarMaquina(JButton btnAgregarMaquina) {
        this.btnAgregarMaquina = btnAgregarMaquina;
    }

    /**
     * @return the btnIniciarProceso
     */
    public JButton getBtnIniciarProceso() {
        return btnIniciarProceso;
    }

    /**
     * @param btnIniciarProceso the btnIniciarProceso to set
     */
    public void setBtnIniciarProceso(JButton btnIniciarProceso) {
        this.btnIniciarProceso = btnIniciarProceso;
    }

    /**
     * @return the btnSalir
     */
    public JButton getBtnSalir() {
        return btnSalir;
    }

    /**
     * @param btnSalir the btnSalir to set
     */
    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    /**
     * @return the btnEliminarEmpleado
     */
    public JButton getBtnEliminarEmpleado() {
        return btnEliminarEmpleado;
    }

    /**
     * @param btnEliminarEmpleado the btnEliminarEmpleado to set
     */
    public void setBtnEliminarEmpleado(JButton btnEliminarEmpleado) {
        this.btnEliminarEmpleado = btnEliminarEmpleado;
    }

    /**
     * @return the btnEliminarMaquina
     */
    public JButton getBtnEliminarMaquina() {
        return btnEliminarMaquina;
    }

    /**
     * @param btnEliminarMaquina the btnEliminarMaquina to set
     */
    public void setBtnEliminarMaquina(JButton btnEliminarMaquina) {
        this.btnEliminarMaquina = btnEliminarMaquina;
    }
            
}
