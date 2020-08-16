package laboratorio08;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edward
 */
public class vOrdenamiento extends JFrame {

    public int array [] ={100,20,-500,-98,14,1,16,28,7,198,12,-100,-999,1000,2,3,4};
    JPanel panel;
    JLabel etiqOrden;
    JTextField inTam, inVec;
    JButton ordenar;
    JTextArea rpta;
    JTable tabla;
    DefaultTableModel modelo;
    
    public vOrdenamiento(){
        this.setSize(500, 500);
        this.setTitle("Ordenamiento por fusión");
        setLocationRelativeTo(null);
        iniciarComponentes();
        dispose();
    }
    public void iniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        colocarBoton();
        colocarTabla();
    }
    
    public void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    public void colocarEtiquetas(){
        etiqOrden = new JLabel();
        etiqOrden.setText("Ordenamiento por fusión");
        Font titulo = new Font("Calibri", 3, 16);
        etiqOrden.setFont(titulo); 
        etiqOrden.setForeground(Color.RED);
        etiqOrden.setBounds(160, 20, 220, 40);
        panel.add(etiqOrden);
        
    }

    public void colocarBoton(){
        ordenar = new JButton();
        ordenar.setText("ORDENAR");
        Font fButton = new Font("Calibri", 1, 14);
        ordenar.setFont(fButton); 
        ordenar.setForeground(Color.BLUE);
        ordenar.setBackground(Color.GRAY);
        ordenar.setBounds(200, 380, 100, 30);
        panel.add(ordenar);
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTabla(modelo);
                colocarTablaOrdenada();
            }
            
        };
        ordenar.addActionListener(oyente);
    }
    
    //------------------------- Muestra tabla desordenada -----------------------------
    public void colocarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Índice");
        modelo.addColumn("Valor");
        for (int i = 0; i < array.length; i++) {
            String [] orden = {Integer.toString(i),Integer.toString(array[i])};
            modelo.addRow(orden);
        }
   
        tabla = new JTable(modelo);
        tabla.setBounds(100,100,300,250);
        panel.add(tabla);

        JScrollPane scroll = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(100,100,300,250);
        panel.add(scroll);
    }
    
    
    
    //------------------------ Muestra tabla ordenada --------------------------
    public void colocarTablaOrdenada(){
        DefaultTableModel modelO = new DefaultTableModel();
        modelO.addColumn("Índice");
        modelO.addColumn("Valor");
        MergeSort ms=new MergeSort();
        ms.mergeSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            String [] orden = {Integer.toString(i),Integer.toString(array[i])};
            modelo.addRow(orden);
        }
         
   
        JTable tablaO = new JTable(modelo);
        tablaO.setBounds(100,100,300,250);
        panel.add(tablaO);

        JScrollPane scroll = new JScrollPane(tablaO,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(100,100,300,250);
        panel.add(scroll);
    }

    public void limpiarTabla(DefaultTableModel modelo){
        try {
            modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
}
