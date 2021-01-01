package example;

import engine.GameEngine;
import engine.GameObject;
import engine.TerminalCanvas;

public class GameMain extends GameObject {

	public GameMain(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}
	
	@Override
	public void init(GameEngine engine) {
		engine.addGameObject(new BorderWindow(0, 0));
	}
	
	
	double y = yPosition;
	
	
	@Override
	public void update(GameEngine engine) {
		
		if(yPosition < engine.getWidth()-2) {
			y += 100 * engine.getDeltaTime();
			
			yPosition = (int) y;
			
		} else {
			yPosition = 1;
			y = yPosition;
			if(xPosition < engine.getHeight()-2) {
				xPosition++;
			} else {
				xPosition = 1;
			}
		}
	}
	
	@Override
	public void draw(TerminalCanvas canvas) {
		canvas.drawCharPosition('X', xPosition, yPosition);
	}
}
