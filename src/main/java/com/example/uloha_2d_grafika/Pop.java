package com.example.uloha_2d_grafika;

import javafx.scene.image.Image;

import java.net.URL;
import java.util.List;
import java.util.Random;

public class Pop extends Balloon{
    public static final List<String> STANDARD_TEXTURES = List.of("pohyb1.png", "pohyb2.png", "pohyb3.png", "pohyb4.png", "pohyb5.png", "pohyb6.png", "pohyb7.png", "pohyb8.png", "pohyb9.png", "pohyb10.png", "pohyb11.png", "pohyb12.png", "pohyb13.png", "pohyb14.png", "pohyb15.png", "pohyb16.png", "pohyb17.png", "pohyb18.png", "pohyb19.png", "pohyb20.png");
    public static final List<String> POP_TEXTURES = List.of("pop2.png","pop3.png", "pop4.png", "pop5.png", "pop6.png", "pop7.png", "pop8.png", "pop9.png", "pop10.png", "pop11.png", "pop1.png");
    Image image;
    Random random = new Random();

    public Pop(int x, int y) {
        super(x, y);
        loadTextures();
    }
    public Pop(int x, int y, int height, int width) {
        super(x, y, height, width);
        loadTextures();
    }
    int num = 0;
    public void loadTextures(){
        URL url = getClass().getResource("/images/"+ STANDARD_TEXTURES.get(num));
        num+=1;
        if(num == 19){
            num = 0;
        }
        if (url != null) {
            image = new Image(url.toString());
            setWidth((int) image.getWidth()/2);
            setHeight((int) image.getHeight()/2);
        }
        else{
            System.out.println("Texture could not be loaded");
        }

    }
    int num2 = 0;
    public void loadDeathTextures(){
        URL url = getClass().getResource("/images/"+ POP_TEXTURES.get(num2));
        num2+=1;
        if(num2 == 10){
            num2 = 0;
        }
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
