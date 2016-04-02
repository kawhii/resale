package com.carl.resale.ui.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航栏,根据key=vale前端拼装参数请求
 *
 * @author Carl
 * @date 2016/4/2
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class NavBar {
    private String key;
    private String value;
    private String name;
    private List<NavBar> children;

    public List<NavBar> getChildren() {
        return children;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 添加子参数
     *
     * @param navBar
     * @return
     */
    public NavBar addChildren(NavBar navBar) {
        if (children == null) {
            children = new ArrayList<NavBar>();
        }
        children.add(navBar);
        return this;
    }

    public NavBar(String key, String value, String name) {
        this.key = key;
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NavBar{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    public NavBar() {
    }
}
