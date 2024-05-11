package com.example.mcashui.ui.home;

public class HomeItems {
    private int icons;

    private String reward_text;
    private String task_text;
    public HomeItems(int icons, String reward_text, String task_text) {
        this.icons = icons;
        this.reward_text = reward_text;
        this.task_text = task_text;
    }
    public int getIcons() {
        return icons;
    }

    public String getReward_text() {
        return reward_text;
    }

    public String getTask_text() {
        return task_text;
    }



}
