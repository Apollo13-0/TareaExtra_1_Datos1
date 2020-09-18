
package chat;

// import modules for GUI

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class chat_server {

    public static void main (String[] args) {

        ServerFrames severFrame = new ServerFrames();

        //This method stops the app
        severFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class ServerFrames extends JFrame implements Runnable{

    private JTextArea textArea;

    public ServerFrames(){

        // Create variables for an easy change
        short Fwidth = 350;
        short Fheight = 700;

        // This method set the size of the frame
        setSize(Fwidth, Fheight);
        setLocation(1325, 190);
        // This method don't allow to change frame dimensions
        setResizable(false);
        // This method shows the frame
        setTitle("Servidor");

        // This method set the background color
        //getContentPane().setBackground(new Color(236,229,221));

        // Create and add a panel which contains button and labels
        PanelServer containerServer= new PanelServer();
        add(containerServer, BorderLayout.SOUTH);

        textArea = new JTextArea();
        textArea.setBackground(new Color(236,229,221));
        add(textArea, BorderLayout.CENTER);

        JPanel title = new JPanel();
        JLabel titleTxt = new JLabel("Servidor");
        title.setBackground(new Color(7,94,84));
        titleTxt.setForeground(new Color(255,255,255));
        title.add(titleTxt);
        add(title, BorderLayout.NORTH);

        setVisible(true);

        Thread serverThread = new Thread(this);
        serverThread.start();

    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(6000);

            while (true) {
                Socket socketS = server.accept();

                DataInputStream serverInD = new DataInputStream(socketS.getInputStream());

                String message = serverInD.readUTF();

                textArea.append(message + "\n");

                socketS.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

// This class creates the south panel which has a button and a textfield

class PanelServer extends JPanel{

    private JTextField entryTxtServer;
    private JButton sendServer;


    public PanelServer() {

        // This method set the background color
        setBackground(new Color(18, 140, 128));

        entryTxtServer = new JTextField(20);

        add(entryTxtServer, BorderLayout.CENTER);

        sendServer = new JButton("Enviar");

        add(sendServer, BorderLayout.SOUTH);

    }

}

