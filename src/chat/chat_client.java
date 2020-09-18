package chat;
 // comentar
import javax.swing.*;
import java.awt.*;

public class chat_client {

    public static void main (String[] args) {

    Frames clientFrame = new Frames();
    //This method stops the app
    clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Frames extends JFrame{

    public Frames(){

        //
        short Fwidth = 350;
        short Fheight = 700;

        // This method set the size of the frame
        setSize(Fwidth, Fheight);
        setLocation(305, 190);
        // This method don't allow to change frame dimensions
        setResizable(false);
        // This method shows the frame
        setTitle("Client");

        // This method set the background color
        getContentPane().setBackground(new Color(236,229,221));

        PanelClient containerClient = new PanelClient();
        add(containerClient, BorderLayout.SOUTH);

        JPanel title = new JPanel();
        JLabel titleTxt = new JLabel("Servidor");
        title.setBackground(new Color(7,94,84));
        titleTxt.setForeground(new Color(255,255,255));
        title.add(titleTxt);
        add(title, BorderLayout.NORTH);

        setVisible(true);

    }
}

class PanelClient extends JPanel{

    private JTextField entryTxtClient;
    private JButton sendClient;

    public PanelClient() {

        // This method set the background color
        setBackground(new Color(18, 140, 128));

        entryTxtClient = new JTextField(20);

        add(entryTxtClient, BorderLayout.CENTER);

        sendClient = new JButton("Enviar");

        add(sendClient, BorderLayout.SOUTH);

    }

}