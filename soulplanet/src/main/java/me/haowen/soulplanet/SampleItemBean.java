package me.haowen.soulplanet;

/**
 * @author 86173
 * @version 1.0
 * @title
 * @description
 * @Package me.haowen.soulplanet
 * @Date 2023/8/1 10:14
 */
public class SampleItemBean {
    private String id;
    private String name;
    private String desc;
    private int color;
    private String percent;
    private boolean hasShadow = false;

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isHasShadow() {
        return hasShadow;
    }

    public void setHasShadow(boolean hasShadow) {
        this.hasShadow = hasShadow;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
