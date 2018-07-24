package swing;

import javax.swing.*;
import java.awt.*;

import static com.sun.javafx.scene.control.skin.ScrollBarSkin.DEFAULT_WIDTH;

/**
 * @Author kai
 * @Description swing框架测试
 * @Create 2018-05-02 9:06
 **/
public class SimpleFrameTest {
    public static void main(String[] args) {
        SimpleFrame simpleFrame = new SimpleFrame();
        simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        simpleFrame.setUndecorated(true);
        simpleFrame.setVisible(true);
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        simpleFrame.setIconImage(defaultToolkit.getImage("icon.gif"));
//        simpleFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
//        simpleFrame.setLocation(0,0);
//        simpleFrame.setBounds(300,300,400,400);
    }
}

class SimpleFrame extends JFrame{
    SimpleFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

    private static final Integer DEFAULT_WIDTH;
    private static final Integer DEFAULT_HEIGHT;
    static {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();
        DEFAULT_WIDTH = screenSize.width;
        DEFAULT_HEIGHT = screenSize.height;
    }
}
