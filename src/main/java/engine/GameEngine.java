package engine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {
	
	private String gameName = "";
	private int height, width;
	private TerminalCanvas canvas;
	
	public GameEngine(String gameName, int height, int width) {
		this.gameName = gameName;
		this.height = height;
		this.width = width;
		canvas = new TerminalCanvas(gameName, height, width);
	}

	private List<GameObject> objects = new ArrayList<>();
	//private List<GameObject> newObjects = new ArrayList<>();
	
	public void addGameObject(GameObject gameObject) {
		gameObject.init(this);
		objects.add(gameObject);
	}
	
	public void start() {
		
		while(true) {
			
			//Inicialização dos game objects
			
			//Atualização dos game objects
			List<GameObject> aliveObjects = new ArrayList<>();
			
			for(int i=0;i<objects.size(); i++) {
				
				if(objects.get(i).isAlive()) {
					objects.get(i).update(this);
					aliveObjects.add(objects.get(i));
				}
			}
			
			//System.out.println(aliveObjects.size());
			
			//Mantem somente as entidades vivas
			this.objects = aliveObjects;
			
			//Desenho dos game objects
			for(int i=0;i<objects.size(); i++) {
				objects.get(i).draw(canvas);
			}
			
			try {
				canvas.draw();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//canvas.clear();
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
}
