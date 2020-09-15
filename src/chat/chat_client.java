package chat;
 // comentar
import javax.swing.*;
import java.awt.*;

public class chat_client {

    public static void main (String[] args) {

        Frames screenC = new Frames();
        // This method shows the frame
        screenC.setVisible(true);
        // This method set the tittle
        screenC.setTitle("Client");
        // This method set the background color
        screenC.getContentPane().setBackground(new Color(255,250,250));
        // This method stops the app
        screenC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Frames extends JFrame{

    // Variables for screen size
    int Fwidth = 350;
    int Fheight = 700;
    Dimension screen_dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Frames(){
        //System.out.println(screen_dim);
        setSize(Fwidth, Fheight);
        setLocation(305, 190);
        // Set the frame non resizable
        setResizable(false);
    }
}