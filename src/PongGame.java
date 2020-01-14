
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.*;
import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;

public class PongGame extends BasicGame {
	
	private Music music;
	private Music music2;
	
	private float xPosition;
	private float yPosition;
	
	private float xVelocity;
	private float yVelocity;
	
	private float width;
	private float height;
	
	private float xBallPos = 500;
	private float yBallPos = 400;
	
	private float xBallVel = 5;
	private float yBallVel = 5;
	
	private float ballWidth = 15;
	private float ballHeight = 15;
	
	private static final int screenWidth = 800;
	private static final int screenHeight = 600;

    public PongGame() {
        super("PongGame");
        this.xPosition = 100;
        this.yPosition = 100;
        this.xVelocity = 5;
        this.yVelocity = 5;
        this.width = 20;
        this.height = 60;
        
    }
    
    @Override
    public void init(GameContainer container) throws SlickException {
    	music = new Music("Sounds/pong.wav");
    }

    @Override
    public void update(GameContainer container, int delta)  throws SlickException {
    	
    	Input input = container.getInput();
    	
    	//PADDLE
    	if(xPosition >= screenWidth - width) {
    		xPosition = screenWidth - width;
    	}
    	if(yPosition >= screenHeight - height) {
    		yPosition = screenHeight - height;
    	}
    	if(yPosition <= 0) {
    		yPosition = 0;
    	}
    	if(xPosition <= 0) {
    		xPosition = 0;
    	}
    	//move right
    	/*
    	if(input.isKeyDown(Input.KEY_RIGHT)) {
    		xPosition = xPosition + xVelocity;
    	}
    	*/
    	
    	//move left
    	/*
    	if(input.isKeyDown(Input.KEY_LEFT)) {
    		xPosition = xPosition - xVelocity;
    	}
    	*/
    	
    	//move up
    	if(input.isKeyDown(Input.KEY_UP)) {
    		yPosition = yPosition - yVelocity;
    	}
    	//move down
    	if(input.isKeyDown(Input.KEY_DOWN)) {
    		yPosition = yPosition + yVelocity;
    	}
    	
    	//BALL
    	xBallPos = xBallPos + xBallVel;
    	yBallPos = yBallPos + yBallVel;
    	
    	if(xBallPos == screenWidth - ballWidth) {
    		xBallVel *= -1;
    		music.play();
    	}
    	if(xBallPos == 0) {
    		xBallVel *= -1;
    		music.play();
    	}
    	if(yBallPos == screenHeight - ballHeight) {
    		yBallVel *= -1;
    		music.play();
    	}
    	if(yBallPos == 0) {
    		yBallVel *= -1;
    		music.play();
    	}
    	if(xBallPos == xPosition && ((yBallPos <= (yPosition + height)) && yBallPos >= (yPosition - height))) {
    		music.play();
    		xBallVel *= -1;
    		}	
    	
    	
    	
    }
           

    @Override
    public void render(GameContainer container, Graphics g)
            throws SlickException {
    	g.setColor(Color.blue);
        g.fillRect(xPosition,yPosition,width,height);
        g.fillRect(xBallPos, yBallPos, ballWidth, ballHeight);
               
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new PongGame());
            app.setDisplayMode(screenWidth, screenHeight, false);
            app.setTargetFrameRate(60);
            app.start();
       
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}