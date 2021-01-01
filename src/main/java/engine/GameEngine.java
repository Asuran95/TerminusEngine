package engine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.input.KeyStroke;

public class GameEngine {
	
	private String gameName = "";
	private int height, width;
	private TerminalCanvas canvas;
	private boolean showStatistics = true;
	private double deltaTime = .0f;
	
	public GameEngine(String gameName, int height, int width) {
		this.gameName = gameName;
		this.height = height;
		this.width = width;
		canvas = new TerminalCanvas(gameName, height +1, width);
	}

	private List<GameObject> objects = new ArrayList<>();
	//private List<GameObject> newObjects = new ArrayList<>();
	
	public void addGameObject(GameObject gameObject) {
		gameObject.init(this);
		objects.add(gameObject);
	}
	
	public void start() {
		
		long timeElapsed = System.currentTimeMillis();
		
		while(true) {			
			//Atualização dos game objects
			List<GameObject> aliveObjects = new ArrayList<>();
			
			for(int i=0;i<objects.size(); i++) {
				if(objects.get(i).isAlive()) {
					objects.get(i).update(this);
					aliveObjects.add(objects.get(i));
				}
			}
			
			//Mantem somente as entidades vivas
			this.objects = aliveObjects;
			
			//Desenho dos game objects
			for(int i=0;i<objects.size(); i++) {
				objects.get(i).draw(canvas);
			}
			
			if(showStatistics) {
				int fps = (int) (1/deltaTime);
				String fpsText = "FPS: " + fps + " Objects: " + aliveObjects.size();
				
				for(int i=0;i<fpsText.length(); i++) {
					canvas.drawCharPosition(fpsText.charAt(i), height, i);
				}
			}
			
			try {
				canvas.draw();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//canvas.clear();
			
			timeElapsed = System.currentTimeMillis() - timeElapsed;
			deltaTime = timeElapsed/1000d;
			timeElapsed = System.currentTimeMillis();
		}
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
	
	public void showStatistics(boolean showStatistics) {
		this.showStatistics = showStatistics;
	}
	
	public double getDeltaTime() {
		return deltaTime;
	}
}
