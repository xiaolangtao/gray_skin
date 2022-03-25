package cn.gray.skin.entity;

public class JiangPin {

    private String name;

    public JiangPin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "JiangPin{" +
                "name='" + name + '\'' +
                '}';
    }
}
