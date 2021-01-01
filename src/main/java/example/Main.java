package example;

import engine.GameEngine;

public class Main {

	public static void main(String[] args) {
		
		
		GameEngine game = new GameEngine("Teste", 50, 230);
	
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
