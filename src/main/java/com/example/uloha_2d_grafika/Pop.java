package com.example.uloha_2d_grafika;

import javafx.scene.image.Image;

import java.net.URL;

public class Pop extends Balloon{
    Image image;

    public Pop(int x, int y) {
        super(x, y);
        loadTextures();
    }
    public Pop(int x, int y, int height, int width) {
        super(x, y, height, width);
        loadTextures();
    }
    public void loadTextures(){
        URL url = getClass().getResource("/images/pohyb1.png");
        if (url != null) {
            image = new Image(url.toString());
            setWidth((int) image.getWidth()/2);
            setHeight((int) image.getHeight()/2);
        }
        else{
            System.out.println("Texture could not be loaded");
        }

    }
    public Image getImage() {
        return image;
    }
}
