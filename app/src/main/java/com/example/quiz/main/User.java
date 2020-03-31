package com.example.quiz.main;

import com.example.quiz.core.ChangeListener;

public class User {
    private String name;
    private NameChangeListener nameChangeListener;

    public User(String name, NameChangeListener nameChangeListener) {
        this.name = name;
        this.nameChangeListener = nameChangeListener;
    }

    public NameChangeListener getNameChangeListener() {
        return nameChangeListener;
    }

    public void setNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListener = nameChangeListener;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        nameChangeListener.onChanged(name);
    }

    public interface NameChangeListener extends ChangeListener<String> {}
}
