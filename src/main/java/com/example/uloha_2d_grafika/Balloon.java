package com.example.uloha_2d_grafika;

public class Balloon {
    int x;
    int y;
    int height;
    int width;

    public Balloon(int x, int y) {
        this.x = x;
        this.y = y;
        this.height = 25;
        this.width = 25;
    }
    public Balloon(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void moveToPosition(double targetX, double targetY){
        if (targetX >= this.x){
            incrementX();
        }
        if (targetY >= this.y){
            incrementY();
        }
        if (targetY <= this.y){
            decrementY();
        }
        if (targetX <= this.x){
            decrementX();
        }
    }
    public boolean isInCollision(Balloon other){
        boolean colX = this.getX() < other.getX() + other.width && this.getX() + this.width > other.getX();
        boolean colY = this.getY() < other.getY() + other.height && this.getY() + this.height > other.getY();
        return colX && colY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void incrementX(){
        x+=15;
    }
    public void decrementX(){
        x-=15;
    }
    public void incrementY(){
        y+=15;
    }
    public void decrementY(){
        y-=15;
    }
}

