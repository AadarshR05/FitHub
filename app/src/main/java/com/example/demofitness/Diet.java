package com.example.demofitness;

public class Diet {

    String heading;
    String briefDiet;
    int titleimage;
    boolean visibility;

    public Diet(String heading, String briefDiet, int titleimage) {
        this.heading = heading;
        this.briefDiet = briefDiet;
        this.titleimage = titleimage;
        this.visibility = false;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
