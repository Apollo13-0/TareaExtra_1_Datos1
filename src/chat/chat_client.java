
package chat;

 // import modules for GUI

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;


public class chat_client {

    public static void main (String[] args) {

    Frames clientFrame = new Frames();
    //This method stops the app
    clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Frames extends JFrame{

    public Frames(){

        // Create variables for an easy change
        short Fwidth = 350;
        short Fheight = 700;

        // This method set the size of the frame
        setSize(Fwidth, Fheight);
        setLocation(305, 190);
        // This method don't allow to change frame dimensions
        setResizable(false);
        // This method shows the frame
        setTitle("Cliente");

        // This method set the background color
        getContentPane().setBackground(new Color(236,229,221));

        // Create and add a panel which contains button and labels
        PanelClient containerClient = new PanelClient();
        add(containerClient, BorderLayout.SOUTH);

        JPanel title = new JPanel();
        JLabel titleTxt = new JLabel("Cliente");
        title.setBackground(new Color(7,94,84));
        titleTxt.setForeground(new Color(255,255,255));
        title.add(titleTxt);
        add(title, BorderLayout.NORTH);

        // This method displays the frame
        setVisible(true);

    }
}

// This class creates the south panel which has a button and a textfield

class PanelClient extends JPanel{

    private JTextField entryTxtClient;
    private JButton sendClient;

    public PanelClient() {

        // This method set the background color
        setBackground(new Color(18, 140, 128));

        entryTxtClient = new JTextField(20);

        add(entryTxtClient, BorderLayout.CENTER);

        sendClient = new JButton("Enviar");

        sendTxt sendEvent = new sendTxt();

        sendClient.addActionListener(sendEvent);

        add(sendClient, BorderLayout.SOUTH);

    }

    private class sendTxt implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            //System.out.println(entryTxtClient.getText());
            int port = 6000;

            try {
                Socket clientSocket = new Socket("127.0.0.1", port);

                DataOutputStream clientOutD = new DataOutputStream(clientSocket.getOutputStream());

                clientOutD.writeUTF(entryTxtClient.getText());

                clientOutD.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println(ioException.getMessage());
            }

        }
    }

}