package com.jheank16oz.componentesdeandroid.models;

/**
 * Created by APPTITUD on 5/12/2017.
 * Developer Jhean Carlos Piñeros Diaz
 */

public class Component {
    public String name;
    public int drawable;
    public String content;

    public Component(String name, int drawable, String content) {
        this.name = name;
        this.drawable = drawable;
        this.content = content;
    }

    public long getId() {
        return name.hashCode();
    }
}
