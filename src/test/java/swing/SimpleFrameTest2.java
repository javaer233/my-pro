package swing;

import javax.swing.*;
import java.awt.*;

/**
 * @Author kai
 * @Description 在框架中添加内容
 * @Create 2018-05-08 16:56
 **/
public class SimpleFrameTest2 {
    public static void main(String[] args) {
        NothelloWordFrame nothelloWordFrame = new NothelloWordFrame();
        nothelloWordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nothelloWordFrame.setVisible(true);
    }
}

class NothelloWordFrame extends JFrame{
    public NothelloWordFrame (){
        setTitle("NotHelloWorldProgram");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        HelloPanel helloPanel = new HelloPanel();
        add(helloPanel);
    }
    public final Integer DEFAULT_WIDTH = 300;
    public final Integer DEFAULT_HEIGHT = 200;
}

class HelloPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        g.drawString("Hello World!", COORDINATE_X, COORDINATE_Y);
    }

    public final Integer COORDINATE_X = 150;
    public final Integer COORDINATE_Y = 100;
}