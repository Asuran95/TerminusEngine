package engine;
import java.io.IOException;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class TerminalCanvas {

	private char[][] canvasChar;
	private String gameName;
	private Screen screen;
	private KeyStroke keyStroke;

	public TerminalCanvas(String gameName, int height, int width) {
		this.canvasChar = new char[height][width];
		this.gameName = gameName;
		try {
			initializeCanvas();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initializeCanvas() throws IOException {
		
		Terminal terminal = new DefaultTerminalFactory()
				.setInitialTerminalSize(new TerminalSize(canvasChar[0].length, canvasChar.length))
				.setTerminalEmulatorTitle(gameName)
				.createTerminal();
		
		//keyStroke = terminal.readInput();
		
		System.out.println(terminal.getClass().getCanonicalName());
		screen = new TerminalScreen(terminal);

		screen.startScreen();
		screen.clear();
		
		
		for(int a=0; a<canvasChar.length; a++) {
			for(int b=0; b<canvasChar[a].length; b++) {
				canvasChar[a][b] = ' ';
			}
		}
	}
	
	public void clear() {

	    for(int a=0; a<canvasChar.length; a++) {
			for(int b=0; b<canvasChar[a].length; b++) {
				
			}
		}
	}

	@SuppressWarnings("resource")
	public void draw() throws IOException {
		
		for (int a=0; a<canvasChar.length; a++) {
			for(int b=0; b<canvasChar[a].length; b++) {
				
				screen.setCharacter(b, a, new TextCharacter(canvasChar[a][b]));
				canvasChar[a][b] = ' ';
			}
		}
		screen.refresh();
	}
	
	public void drawCharPosition(char c, int x, int y) {
		canvasChar[x][y] = c;
	}
	
	/**
	 * Vai precisar implementar um metodo de capturar o input
	 * @return
	 */
	public KeyStroke getKeyStroke() {
		return keyStroke;
	}
}
