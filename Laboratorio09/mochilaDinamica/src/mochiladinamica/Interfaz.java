
package mochiladinamica;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{
    boolean nuevamente;
    
    private JPanel pan_contenedor = new JPanel();
    
    private JLabel lab_maxValor = new JLabel("Maximo Valor Obtenido: ");
    private JLabel lab_capacidad = new JLabel("Capacidad de la mochila: ");
    private JLabel lab_numDeObjetos = new JLabel("Número total de objetos: ");
    private JLabel lab_objetosElegidos = new JLabel("Objetos Elegidos: ");
    
    private JTextField txf_maxValor = new JTextField();
    private JTextField txf_capacidad = new JTextField();
    private JTextField txf_numDeObjetos = new JTextField();
    private JTextArea txa_objetosElegidos = new JTextArea();
    
    private JButton btn_nuevamente = new JButton("REPETIR ALGORITMO");
    
    public Interfaz(){
        this.nuevamente = true;
        this.setSize(500,350);
        this.setTitle("Mochila UI");
        setLocationRelativeTo(null);
        inicializarComponentes();
        this.pan_contenedor.setLayout(null);
        this.getContentPane().add(pan_contenedor);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public int ingresarEnteroPositivo(String s){
        boolean esNum = true;
        
        if(s == null){
            esNum=false;
        }else{
            try{
                int num = Integer.parseInt(s);
            } catch (NumberFormatException nfe){
                esNum = false;
            }
        }
        
        if(esNum == true){
            int num = Integer.parseInt(s);
            if(num > 0){
                return num;
            }
            else{
                JOptionPane.showMessageDialog(null, "Valor ingresado inválido");
                return -1;                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Valor ingresado no Entero");
            return -1;
        }
    }
    
    public void comprobarValor(int n){
        if(n == -1){
            this.dispose();
            System.exit(0);
        }
    }
    
    public void proceso(){
        while(nuevamente){
            nuevamente = false;
            int n = ingresarEnteroPositivo(JOptionPane.showInputDialog("Ingrese el número de objetos"));
            comprobarValor(n);
            int capacidad = ingresarEnteroPositivo(JOptionPane.showInputDialog("Ingrese la capacidad de la mochila"));
            comprobarValor(capacidad);
            int peso[] = new int[n];
            int valor[] = new int[n];

            for (int i = 0; i < n; i++) {
                peso[i] = ingresarEnteroPositivo(JOptionPane.showInputDialog("Ingrese el peso del objeto " + (i+1)));
                comprobarValor(peso[i]);
                valor[i] = ingresarEnteroPositivo(JOptionPane.showInputDialog("Ingrese el valor del objeto " + (i+1)));
                comprobarValor(valor[i]);
            }

            Mochila moc_Mochila = new Mochila(peso,valor,capacidad);
            moc_Mochila.elegirObjetos();
            moc_Mochila.Componer();
            
            pasarValores(moc_Mochila);
            this.setVisible(true);   
            while(!nuevamente){
            }
            this.dispose();
        }

        
    }
    
    public void inicializarComponentes(){
        //JLabels
        this.lab_maxValor.setSize(200, 20);
        this.lab_maxValor.setLocation(20, 30);
        this.pan_contenedor.add(this.lab_maxValor);
        
        this.lab_capacidad.setSize(200, 20);
        this.lab_capacidad.setLocation(20, 60);
        this.pan_contenedor.add(this.lab_capacidad);
        
        this.lab_numDeObjetos.setSize(200, 20);
        this.lab_numDeObjetos.setLocation(20, 90);
        this.pan_contenedor.add(this.lab_numDeObjetos);
        
        this.lab_objetosElegidos.setSize(200, 20);
        this.lab_objetosElegidos.setLocation(270, 30);
        this.pan_contenedor.add(this.lab_objetosElegidos);
        //JTextFields 6 JTextArea
        this.txf_maxValor.setSize(50,20);
        this.txf_maxValor.setLocation(170, 30);
        this.txf_maxValor.setEditable(false);
        this.pan_contenedor.add(this.txf_maxValor);
        
        this.txf_capacidad.setSize(50,20);
        this.txf_capacidad.setLocation(170, 60);
        this.txf_capacidad.setEditable(false);
        this.pan_contenedor.add(this.txf_capacidad);
        
        this.txf_numDeObjetos.setSize(50,20);
        this.txf_numDeObjetos.setLocation(170, 90);
        this.txf_numDeObjetos.setEditable(false);
        this.pan_contenedor.add(this.txf_numDeObjetos);
        
        this.txa_objetosElegidos.setSize(190,220);
        this.txa_objetosElegidos.setLocation(270, 60);
        this.txa_objetosElegidos.setEditable(false);
        this.pan_contenedor.add(this.txa_objetosElegidos);
        
        //JScrollPane
        JScrollPane scr_scroll = new JScrollPane(txa_objetosElegidos,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scr_scroll.setSize(190,220);
        scr_scroll.setLocation(270, 60);
        this.pan_contenedor.add(scr_scroll);
        
        //JButton
        this.btn_nuevamente.setSize(230, 130);
        this.btn_nuevamente.setLocation(20, 150);
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevamente = true;
            }
        };
        btn_nuevamente.addActionListener(oyente);
        this.pan_contenedor.add(btn_nuevamente);
        
    }
    
    public void pasarValores(Mochila miMochila){
        this.txf_maxValor.setText(String.valueOf(miMochila.elegirObjetos()));
        this.txf_capacidad.setText(String.valueOf(miMochila.getCapacidad()));
        int n = miMochila.getNumero();
        this.txf_numDeObjetos.setText(String.valueOf(n));
        
        String elegidos = "";
        for (int i = 1; i <= n; i++) {
            if(miMochila.getElegido(i) == 1){
                elegidos = elegidos + "Objeto "+i+": \tPeso = "+miMochila.getPeso(i)
                        + "\n\tValor = "+miMochila.getValor(i)+"\n\n";
            }
        }
        this.txa_objetosElegidos.setText(elegidos);
    }
    
}
