package com.example.wangjianwei.Bean;

/**
 * Created by wangjianwei on 16-11-11.
 */

public class Tab {

    private int title;
    private int icon;
    private Class fragment;

    public Tab(int icon, int title, Class fragment) {
        this.icon = icon;
        this.title = title;
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
