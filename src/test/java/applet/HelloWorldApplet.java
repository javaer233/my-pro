package applet;

import javax.swing.*;

/**
 * @Author kai
 * @Description 一个简单的applet
 * @Create 2018-05-09 15:21
 **/
public class HelloWorldApplet extends JApplet {
    public void init(){
        JLabel jLabel = new JLabel("Hello world", SwingConstants.CENTER);
        add(jLabel);
    }
}
