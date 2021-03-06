
package chat;

 // import modules for GUI

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import test.StringToInt;
import test.casc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * This is the main class which contains the frame of the app
 * @author Ignacio Calderón
 * @version 2.0
 */

public class chat_client {
    public final static Logger logging = Logger.getLogger(casc.class);

    public static void main (String[] args) {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log.properties");

        Frames clientFrame = new Frames();
        //This method stops the app
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

/**
 * This class creates the frame. Also contains a thread to listen incoming messages
 * @author Ignacio Calderón
 */
class Frames extends JFrame implements Runnable{

    private JTextArea textArea;
    private JLabel portLabel;
    private Thread clientThread;

    /**
     * This method sets the GUI
     * @author Ignacio Calderón
     */

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

        textArea = new JTextArea(36,30);
        textArea.setBackground(new Color(236,229,221));

        portLabel = new JLabel();
        portLabel.setForeground(new Color(220,248,198));

        // Create and add a panel which contains button and labels
        PanelClient containerClient = new PanelClient();
        containerClient.add(textArea);
        containerClient.add(portLabel);
        add(containerClient);


        setVisible(true);

        // Create a thread and starts it

        clientThread = new Thread(this);
        clientThread.start();
    }

    /**
     * This method creates a ServerSocket who is listening for incoming data, if the socket is not avalible
     * it tries the next one.
     * @author Ignacio Calderón
     * @throws IOException
     */

    @Override
    public void run() {

        int port = 1024;
        boolean portAlive = true;

        while (portAlive) {
            try {

                ServerSocket server = new ServerSocket(port);
                portLabel.setText("Su puerto es: " + String.valueOf(port));
                portAlive = false;

                while (true) {
                    Socket socketS = server.accept();

                    DataInputStream serverInD = new DataInputStream(socketS.getInputStream());

                    String message = serverInD.readUTF();

                    textArea.append(message + "\n");

                    socketS.close();
                }
            } catch (IOException e) {
                port++;
                chat_client.logging.error(e.getMessage());
            }
        }

    }
}


/**
 * This class is in charge of the GUI and "saving" the message, port and name of the user.
 * @author Ignacio Calderón
 */

class PanelClient extends JPanel{

    private JTextField entryTxtClient;
    private JButton sendClient;
    private JTextField nameEntry;
    private JTextField portEntry;
    private JLabel clientLabel;
    private JLabel portLabel;

    /**
     * This method contains the objects of the GUI and it serves as entry for the text.
     * @author Ignacio Calderón
     */

    public PanelClient() {

        clientLabel = new JLabel("Ingrese su nombre:");
        clientLabel.setForeground(Color.white);

        portLabel = new JLabel("Puerto: ");
        portLabel.setForeground(Color.white);

        nameEntry = new JTextField(8);
        portEntry = new JTextField(5);

        add(clientLabel);
        add(nameEntry);
        add(portLabel);
        add(portEntry);

        // This method set the background color
        setBackground(new Color(18, 140, 128));

        entryTxtClient = new JTextField(20);

        add(entryTxtClient);

        sendClient = new JButton("Enviar");

        sendTxt sendEvent = new sendTxt();

        sendClient.addActionListener(sendEvent);

        add(sendClient);

    }

    /**
     * This method writes text in a DataOutputStream object and link this object to a socket with it's own ip and port
     * @author Ignacio Calderón
     * @throws  IOException
     */

    private class sendTxt implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            int port=0;
            try {
                port = StringToInt.checkerPort(portEntry.getText());
            } catch (StringToInt stringToInt) {
                chat_client.logging.error(stringToInt.getMessage());
            }


            if (port>0) {
                try {
                    Socket clientSocket = new Socket("127.0.0.1", port);

                    DataOutputStream clientOutD = new DataOutputStream(clientSocket.getOutputStream());

                    clientOutD.writeUTF(entryTxtClient.getText() + "  --  " + nameEntry.getText());

                    clientOutD.close();

                } catch (IOException ioException) {
                    chat_client.logging.error(ioException.getMessage());
                }
            }
        }

    }



}

