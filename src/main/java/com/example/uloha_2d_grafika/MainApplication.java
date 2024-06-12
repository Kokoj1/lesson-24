package com.example.uloha_2d_grafika;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainApplication extends Application {
    public static final int SCREEN_WIDTH = 1900;
    public static final int SCREEN_HEIGHT = 920;
    public boolean stop = false;
    public int speed = 10;
    double clickedX;
    double clickedY;

    List<Pop> popList = new ArrayList<>();

    Image backgroundImage = null;
    Random random = new Random();

    GraphicsContext graphicsContext;
    Direction direction = Direction.upRight;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        root.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);

        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("Clicked on x" + event.getX() + "y" + event.getY());
            clickedX = event.getX();
            clickedY = event.getY();
            detectCollision(popList);
        });

        stage.setScene(scene);
        stage.setTitle("Klasifikovaná úloha");
        stage.show();


        for (int i = 0; i < 1; i++) {
            Pop p = new Pop(random.nextInt(500)+600, random.nextInt(300)+400);
            //p.setX(random.nextInt(SCREEN_WIDTH));
            //p.setY(random.nextInt(SCREEN_HEIGHT));
            popList.add(p);
        }
        AnimationTimer animationTimer = new AnimationTimer() {
            long lastTick = 0;

            @Override
            public void handle(long now) {
                if (now - lastTick > 1000000000l / speed) {
                    lastTick = now;
                    tick();
                }
            }
        };
        animationTimer.start();
    }


    private void tick() {
        int num = random.nextInt(5);
        clearScreen();
        for (Pop p:
                popList) {
            if (p.getX() < 0) {
                //direction = Direction.right;
                if (num == 2 || num == 3) {
                    direction = Direction.values()[num];
                }
            }
            if (p.getY() > SCREEN_HEIGHT - p.height) {
                if (num == 1 || num == 3) {
                    direction = Direction.values()[num];
                }
            }
            if (p.getY() < 0) {
                if (num == 0 || num == 2) {
                    direction = Direction.values()[num];
                }

            }
            if (p.getX() > SCREEN_WIDTH - p.width) {
                if (num == 0 || num == 1) {
                    direction = Direction.values()[num];
                }

            }

            switch (direction){

                case upLeft:
                    stop = p.getX() > SCREEN_WIDTH - p.width;
                    if (!stop) {
                        p.decrementX();
                        p.incrementY();
                    }
                    break;
                case upRight:
                    stop = p.getX() > SCREEN_WIDTH - p.width;
                    if (!stop) { p.incrementX();
                   p.incrementY();}
                    break;
                case downLeft:
                    stop = p.getX() < 0;
                    if (!stop) {
                        p.decrementX();
                        p.decrementY();
                    }

                    break;
                case downRight:
                    stop = p.getX() < 0;
                    if (!stop){ p.incrementX();
                    p.decrementY();}
                    break;
            }
            //detectCollision(p);
            graphicsContext.drawImage(p.getImage(), p.x, p.y, p.height, p.height);
        }

    }
    private void detectCollision(List<Pop> popList){
        for (Pop pop:popList) {
            if (clickedX >= pop.x && clickedX <= pop.x+ pop.width &&
                    clickedY >=pop.y && clickedY <= pop.y+ pop.height)
            //if(pop.getX() >= clickedX+pop.width && pop.getY() <= clickedY+pop.height)
            {
                pop.setX(random.nextInt(random.nextInt(900)+500));
                pop.setY(random.nextInt(400)+300);
            }
        }

    }

    private void clearScreen() {
        graphicsContext.clearRect( 0, 0, SCREEN_WIDTH, SCREEN_WIDTH);
    }

    public static void main(String[] args) {
        launch();
    }
}
