package example;

import engine.GameEngine;
import engine.GameObject;
import engine.TerminalCanvas;

public class BorderWindow extends GameObject {

	public BorderWindow(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}
	
	private int maxHeight;
	private int maxWidth;
	
	@Override
	public void update(GameEngine engine) {
		maxHeight = engine.getHeight();
		maxWidth = engine.getWidth();
	}
	
	@Override
	public void draw(TerminalCanvas canvas) {
		
		for(int h=0; h<maxHeight; h++) {
			
			if(h==0) {
				for(int w=0; w<maxWidth; w++) {	
					canvas.drawCharPosition('=', h, w);	
				}
			} else if(h == (maxHeight-1)){
				for(int w=0; w<maxWidth; w++) {	
					canvas.drawCharPosition('=', h, w);	
				}
			} else {
				canvas.drawCharPosition('|', h, 0);	
				canvas.drawCharPosition('|', h, maxWidth-1);	
			}
		}		
	}
}
