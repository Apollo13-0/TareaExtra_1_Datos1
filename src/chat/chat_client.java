package chat;
 // comentar
import javax.swing.*;
import java.awt.*;

public class chat_client {

    public static void main (String[] args) {

        //
        int Fwidth = 350;
        int Fheight = 700;

        //
        JFrame screenC = new JFrame("Client");

        // This method set the size of the frame
        screenC.setSize(Fwidth, Fheight);
        screenC.setLocation(305, 190);
        // This method don't allow to change frame dimensions
        screenC.setResizable(false);
        // This method shows the frame

        // This method set the background color
        screenC.getContentPane().setBackground(new Color(236,229,221));
        // This method stops the app
        screenC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel
        JPanel panelC = new JPanel();
        //panelC.setSize(350, 50);
        panelC.setBackground(new Color(18,140,128));

        JButton send = new JButton("Enviar");
        JTextField tf = new JTextField(20);

        JPanel panelT = new JPanel();
        panelT.setBackground(new Color(7,94,84));
        JLabel labelT = new JLabel();
        labelT.setText("Servdor");
        labelT.setForeground(new Color(250,250,250));

        panelT.add(labelT);


        panelC.add(tf);
        panelC.add(send);


        screenC.getContentPane().add(BorderLayout.SOUTH, panelC);
        screenC.getContentPane().add(BorderLayout.NORTH, panelT);
        screenC.setVisible(true);


    }
}

