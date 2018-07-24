package designPattern.facadePattern;

import designPattern.bean.Entertainment;
import designPattern.bean.GameNews;
import designPattern.bean.Sports;

/**
 * @Author kai
 * @Description 外观类
 * @Create 2018-04-27 16:06
 **/
class FacadeMode {
    private Sports sports;
    private GameNews gameNews;
    private Entertainment entertainment;

    FacadeMode(Sports sports, GameNews gameNews, Entertainment entertainment) {
        this.sports = sports;
        this.gameNews = gameNews;
        this.entertainment = entertainment;
    }

    public FacadeMode() {
    }


    //外观模式下可以在其中定义对被包装类的调用，但该部分虽然集成了多个操作，属于硬编码，灵活性差
    void facadeRead() {
        this.sports.read();
        this.gameNews.read();
        this.entertainment.read();
    }

    void facadeClose() {
        this.sports.close();
        this.gameNews.close();
        this.entertainment.close();
    }
}
