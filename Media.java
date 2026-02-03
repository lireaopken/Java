package com.example.demo;
class Media {
    protected String title;

    public Media(String title) {
        this.title = title;
    }

    // полиморфизм
    public void play() {
        System.out.println("Playing: " + title);
    }

    @Override
    public String toString() {
        return title;
    }
}