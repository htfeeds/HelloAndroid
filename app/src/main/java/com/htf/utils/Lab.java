package com.htf.utils;

/**
 * Created by htf52 on 19-Nov-15.
 */
public class Lab {
    private String activity;
    private String name;
    private String description;
    private String difficulty = "Easy";

    public Lab() {
    }

    public Lab(String activity, String name, String description) {
        this.activity = activity;
        this.name = name;
        this.description = description;
    }

    public Lab(String activity, String name, String description, String difficulty) {
        this.activity = activity;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
