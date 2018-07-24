package testForBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author kai
 * @Description 局部内部类
 * @Create 2018-04-28 14:37
 **/
class LocalInnerClazz {
//    Boolean beep = true;
    void startOne (Boolean beep){
        class InnerClazz{
            public void actionPerformed(){
                sayWords();
                if (beep) {
                    System.out.println("beep");
                }
            }
        }
        InnerClazz innerClazz = new InnerClazz();
        innerClazz.actionPerformed();
    }

    void sayWords(){
        System.out.println("words");
    }
}
