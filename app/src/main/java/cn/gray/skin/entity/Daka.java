package cn.gray.skin.entity;

public class Daka {

    private int bg;
    private int icon;
    private String day;
    private int state;

    public Daka(int bg, int icon, String day, int state) {
        this.bg = bg;
        this.icon = icon;
        this.day = day;
        this.state = state;
    }

    public int getBg() {
        return bg;
    }

    public int getIcon() {
        return icon;
    }

    public String getDay() {
        return day;
    }

    public int getState() {
        return state;
    }
}
