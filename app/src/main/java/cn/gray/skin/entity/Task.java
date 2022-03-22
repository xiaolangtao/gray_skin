package cn.gray.skin.entity;

/**
 * Description:
 * Date:2022-03-21
 * Author:xiaolangtao
 */
public class Task {

    private int card;
    private String title;
    private String desc;
    private int icon;
    private int state;

    public Task(int card, String title, String desc, int icon, int state) {
        this.card = card;
        this.title = title;
        this.desc = desc;
        this.icon = icon;
        this.state = state;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Task{" +
                "card=" + card +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", icon=" + icon +
                ", state=" + state +
                '}';
    }
}
