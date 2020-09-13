package engine;

public abstract class GameObject {
	
	
	protected boolean alive = true;
	protected int xPosition = 0;
	protected int yPosition = 0;
	
	
	public GameObject(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void init(GameEngine engine) {}
	
	public void update(GameEngine engine) {}
	
	public void draw(TerminalCanvas canvas) {}
}
