
package laboratorio08;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.math.BigDecimal;

/**
 *
 * @author Edward
 */
public class VMultiplicacion extends JFrame {
    
    JPanel panel;
    JLabel etiqMulti, etMultiplicando, etMultiplicador;
    JTextField inMultiplicando, inMultiplicador;
    JButton calcular;
    JTextArea rpta;
    
    
    public VMultiplicacion(){
        this.setSize(500, 500);
        this.setTitle("Multiplicación de enteros grandes");
        setLocationRelativeTo(null);
        iniciarComponentes();
        dispose();
    }
    public void iniciarComponentes(){
        colocarPanel();
        colocarEtiqueta();
        colocarCajaTexto();
        colocarBoton();
        colocarAreaTexto();
    }
    
    public void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    public void colocarEtiqueta(){
        etiqMulti = new JLabel();
        etiqMulti.setText("Multiplicación de enteros grandes");
        Font titulo = new Font("Calibri", 3, 16);
        etiqMulti.setFont(titulo); 
        etiqMulti.setForeground(Color.RED);
        etiqMulti.setBounds(130, 20, 230, 40);
        panel.add(etiqMulti);
        
        etMultiplicando = new JLabel();
        etMultiplicando.setText("Multiplicando: ");
        Font fuente = new Font("Calibri", 3, 16);
        etMultiplicando.setFont(fuente); 
        etMultiplicando.setForeground(Color.BLUE);
        etMultiplicando.setBounds(50, 70, 160, 30);
        panel.add(etMultiplicando);
        
        etMultiplicador = new JLabel();
        etMultiplicador.setText("Multiplicador: ");
        etMultiplicador.setFont(fuente); 
        etMultiplicador.setForeground(Color.BLUE);
        etMultiplicador.setBounds(50, 120, 160, 30);
        panel.add(etMultiplicador);
    }

    public void colocarCajaTexto(){
        inMultiplicador = new JTextField();
        inMultiplicador.setBounds(170, 70, 90, 30);
        panel.add(inMultiplicador);
        
        inMultiplicando = new JTextField();
        inMultiplicando.setBounds(170, 120, 90, 30);
        panel.add(inMultiplicando);
    }
    
    public void colocarBoton(){
        calcular = new JButton();
        calcular.setText("CALCULAR");
        Font fButton = new Font("Calibri", 1, 14);
        calcular.setFont(fButton); 
        calcular.setForeground(Color.BLUE);
        calcular.setBackground(Color.GRAY);
        calcular.setBounds(50, 180, 100, 30);
        panel.add(calcular);
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecMulti();
            }
            
        };
        calcular.addActionListener(oyente);
    }
    
    public void colocarAreaTexto(){
        rpta = new JTextArea();
        rpta.setBounds(50, 250, 380, 160);
        rpta.setEditable(false);
        panel.add(rpta);
    }
    
    public void ejecMulti(){
        String fact1 = inMultiplicando.getText();
        String fact2 = inMultiplicador.getText();
        
        if(fact1 != "" && fact2 != ""){
            int f1 = Integer.parseInt(fact1);
            int f2 = Integer.parseInt(fact2);
            double prod = multiplicar(f1,f2);
            //prod = (double)Math.round(prod * Math.pow(10,7)) / Math.pow(10,7);
            rpta.setText(new BigDecimal(prod).toPlainString());
        }
    }
    
    //---------LÓGICA DE TAMAÑO------------
    public int tamaño(int num){
        int cant=0;
        while(num>0){
            num=num/10;
            cant++;
        }
        return cant;
    }
    
    //------LÓGICA DE MULTIPLICACIÓN--------
    public double multiplicar(int f1, int f2){
        int n;
        if(tamaño(f1)>tamaño(f2)){
            n=tamaño(f1);
        }
        else{
            n=tamaño(f2);
        }
        if(n<3){
            return (double)(f1*f2);  
        }
        else{
            int s  = n/2;
            int xi = f1/(int)Math.pow(10,s);
            int xd = f1%(int)Math.pow(10,s);
            int yi = f2/(int)Math.pow(10,s);
            int yd = f2%(int)Math.pow(10,s);
            
            double p = multiplicar(xi,yi);
            double r = multiplicar(xi+xd,yi+yd);
            double q = multiplicar(xd,yd);
            
            return p*(Math.pow(10, 2*s)) + (r-p-q)*(Math.pow(10, s)) + q;
        }
    } 
}
