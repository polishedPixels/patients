package Game;


import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import Camera.Camera;
import Game.Clock.Step;
import Game.Clock.Time;
import Game.Map.Fog;
import Game.Map.Level;
import Game.Map.Point;
import Game.Map.TileMap;
import Game.Mobs.Mob;
import Game.Mobs.Player;


public class Main {

	public static final String WINDOW_TITLE = "Sample Program";
	public static final int[] WINDOW_DIMENSIONS = {640, 640};
	public static final int Sync = 60;
	
	//public static Point testPoint = new Point(0, 0);
	
	public static Player player;
	public static Camera playerCam;
	public static Point mousePoint;

	
	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		TileMap.draw();
		Mob.DrawAll();
		Fog.draw();
		player.draw();

	}

	private static void input() {
		
		double mouseX = Mouse.getX();
		double mouseY = WINDOW_DIMENSIONS[1] - Mouse.getY();
		
		mousePoint.setPos(mouseX, mouseY);
		
		//System.out.println(mousePoint.posY);
		
		
		
	}

	private static void cleanUp(boolean asCrash) {
		Display.destroy();
		System.exit(asCrash ? 1 : 0);
	}

	private static void setUpMatrices() {
		glMatrixMode(GL_PROJECTION);
		glOrtho(0, 640, 640, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

	}

	private static void update() {
		Display.update();
		Display.sync(Sync);
		Step.Update();
		player.Update();

	}
	
	private static void updatePerStep() {

		if (Step.next) {

			//update step Here
			Mob.UpdateAll();
			Step.next = false;
		}

	}

	private static void enterGameLoop() {
		while (!Display.isCloseRequested()) {
			Time.lastFrame = Time.getTime();
			render();
			input();
			updatePerStep();
			update();
			Time.getDelta();
		}
	}

	private static void setUpObjects() {
		TileMap.Init(20,20);
		Fog.Init(TileMap.worldSize[0], TileMap.worldSize[1]);
		
		Level.levelSetUp(2);
		
		playerCam = new Camera(0, 0);
		Camera.mainCam = playerCam;
		
		player = new Player(3, 3, 8, 0, 1, 0);
		//Mob.createMob("Bobby", new Mob(6, 6, 10, 0, 0, 1));
		
		mousePoint = new Point(0, 0);
		
		Level.load(0);
		Fog.clearMap();
		
	}

	private static void setUpDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WINDOW_DIMENSIONS[0],
					WINDOW_DIMENSIONS[1]));
			Display.setTitle(WINDOW_TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			cleanUp(true);
		}
	}
		

	public static void main(String[] args) {
		setUpDisplay();
		setUpObjects();
		setUpMatrices();
		enterGameLoop();
		cleanUp(false);
	}

}