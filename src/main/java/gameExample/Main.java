package gameExample;
import java.io.IOException;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import engine.GameEngine;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		GameEngine game = new GameEngine("Teste", 30, 100);
	
		game.addGameObject(new GameMain(1, 1));
		
		game.start();
		
		
		/*
		Terminal terminal = new DefaultTerminalFactory().createTerminal();
		Screen screen = new TerminalScreen(terminal);

		screen.startScreen();
		screen.clear();

		screen.setCharacter(10, 10, new TextCharacter('*'));
		screen.refresh();

		screen.readInput();
		screen.stopScreen();*/
		
		
		
		
		
	}
}
