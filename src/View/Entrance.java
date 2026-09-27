package View;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Entrance extends Thread  {
    private JFrame entrance= new JFrame();

    private Image img;

    private ClassLoader cldr;


    /** Run method
     * This method pops up for several seconds a picture of stratego as an entrance in the screen
     * <b>Post-condition</b> A picture of stratego has been poped for a several minutes as an entrance in the screen
     */

    public void run(){

        entrance.setTitle("WELCOME");
        entrance.setLayout(null);
        entrance.setBounds(-10, -35, 7000, 7000);
        //entrance.setBounds(400, 100, 500, 500);//centering the Gridlayout
        Container c = entrance.getContentPane(); //Gets the content layer
        JLabel label = new JLabel(); //JLabel Creation
        cldr = this.getClass().getClassLoader();
        URL imageURL = cldr.getResource("strategoph.png");
        img = new ImageIcon(imageURL).getImage();
        img=img.getScaledInstance(1500, 1000, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img)); //Sets the image to be displayed as an icon
       // Dimension size = label.getPreferredSize(); //Gets the size of the image

        label.setBounds(-40, -700, 2000, 2100); //Sets the location of the image
        //label.resize(size);
        c.add(label); //Adds objects to the container
        entrance.setVisible(true);

        try {
            this.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** This method dispose entrance image
     * <b>Post-condition</b> The entrance image is disposed / the game begins
     */

    public void stopthread() { //dispose frame with image
       entrance.dispose();
       this.interrupt();
    }
}
