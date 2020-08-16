package laboratorio08;

/**
 *
 * @author Edward
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Ventana extends JFrame {


    public JButton b1, b2;
    public Container contentpane;

    Ventana() {
        this.setSize(500, 500);
        this.setTitle("Laboratorio 08");
        setLocationRelativeTo(null);
        contentpane = getContentPane();
        contentpane.setLayout(new GridLayout(2, 1));
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        colocarBotones();
    }

    public void colocarBotones() {
        b1 = new JButton();
        b1.setText("Multiplicación de enteros grandes");
        URL url = this.getClass().getResource("multiplicacion.png");
        ImageIcon icon = new ImageIcon(url);
        b1.setIcon(icon);
        Font fuente = new Font("Calibri", 3, 20);
        b1.setFont(fuente); 
        b1.setForeground(Color.BLUE);
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VMultiplicacion v2 = new VMultiplicacion();
                v2.setVisible(true);
            }
        };
        b1.addActionListener(oyente);
        contentpane.add(b1);

        b2 = new JButton();
        b2.setText("Ordenamiento por fusión");
        URL url2 = this.getClass().getResource("orden.png");
        ImageIcon icono = new ImageIcon(url2);
        b2.setIcon(icono);
        b2.setFont(fuente); 
        b2.setForeground(Color.BLUE);
        ActionListener boton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vOrdenamiento orden = new vOrdenamiento();
                orden.setVisible(true);
            }
        };
        b2.addActionListener(boton);
        contentpane.add(b2);
        
    }

}
