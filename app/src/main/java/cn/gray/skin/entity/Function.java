package cn.gray.skin.entity;

/**
 * Description:
 * Date:2022-03-21
 * Author:xiaolangtao
 */
public class Function {

    private String name;
    private int resource;
    private boolean state;

    public Function(String name, int resource, boolean state) {
        this.name = name;
        this.resource = resource;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
