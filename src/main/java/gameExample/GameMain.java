package gameExample;

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
	
	long timeElap = System.currentTimeMillis();
	
	@Override
	public void update(GameEngine engine) {
		
		if((timeElap+0) < System.currentTimeMillis()) {
			timeElap = System.currentTimeMillis();
			
			if(yPosition < engine.getWidth()-2) {
				yPosition++;
			} else {
				yPosition = 1;
				if(xPosition < engine.getHeight()-2) {
					xPosition++;
				} else {
					xPosition = 1;
				}
			}
		}
	}
	
	@Override
	public void draw(TerminalCanvas canvas) {
		canvas.drawCharPosition('X', xPosition, yPosition);
	}
}
