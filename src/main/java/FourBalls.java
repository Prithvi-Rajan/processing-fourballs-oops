import processing.core.PApplet;

import java.util.ArrayList;

public class FourBalls extends PApplet {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final int WHITE = 255;
    public static final int BLACK = 0;


    public static void main(String[] args) {
        PApplet.main(new String[]{"FourBalls"});
    }


    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
        fullScreen();
    }

    @Override
    public void setup() {
        background(WHITE);
        stroke(BLACK);
        strokeWeight(2);
        noFill();
        createBalls();
    }

    @Override
    public void draw() {
        background(WHITE);
        for (Ball ball : balls) {
            ball.update();
            ball.display();
        }
    }

    ArrayList<Ball> balls = new ArrayList<Ball>();

    public void createBalls() {
        final int RADIUS = 60;
        for (int i = 1; i < 5; i++) {
            int padding = 2 * RADIUS;
            float ballHeight = (float)((HEIGHT - padding) / 5) * i;
            System.out.println(ballHeight);
            balls.add(new Ball(0, ballHeight, i, 0, RADIUS));
        }
    }


    class Ball {
        float x, y, xSpeed, ySpeed;
        float radius;

        public Ball(float x, float y, float xSpeed, float ySpeed, float radius) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
            this.radius = radius;
        }

        public void update() {
            x += xSpeed;
            y += ySpeed;
            if (x > width || x < 0) {
                xSpeed *= -1;
            }
            if (y > height || y < 0) {
                ySpeed *= -1;
            }
        }

        public void display() {
            ellipse(x, y, radius, radius);
        }
    }
}


