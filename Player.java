import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glRectd;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.input.Keyboard;

public class Player {
	int posX;
	int posY;
	int screenX;
	int screenY;
	double size;
	double centerX;
	double centerY;
	double[] rgb = new double[3];
	Tile[] surTiles = new Tile[9];
	boolean[] surWall = new boolean[9];

	public Player(int X, int Y, double Size, double r, double g, double b) {
		posX = X;
		posY = Y;
		screenX = X;
		screenY = Y;
		size = Size;
		rgb[0] = r;
		rgb[1] = g;
		rgb[2] = b;

		centerUpdate();
		surTileUpdate();

	}

	public void draw() {
		glColor3d(rgb[0], rgb[1], rgb[2]);
		glRectd(centerX - size, centerY - size, centerX + size, centerY + size);

	}

	public void Update() {
		Input();
		surTileUpdate();
		centerUpdate();
	}

	private void centerUpdate() {
		centerX = ((posX * Tile.size) - Camera.mainCam.posX) + Tile.size / 2;
		centerY = ((posY * Tile.size) - Camera.mainCam.posY) + Tile.size / 2;
	}

	private void surTileUpdate() {
		
		surTiles[0] = TileMap.tileMap[posX - 1][posY - 1];
		surTiles[1] = TileMap.tileMap[posX - 0][posY - 1];
		surTiles[2] = TileMap.tileMap[posX + 1][posY - 1];

		surTiles[3] = TileMap.tileMap[posX - 1][posY - 0];
		surTiles[4] = TileMap.tileMap[posX - 0][posY - 0];
		surTiles[5] = TileMap.tileMap[posX + 1][posY - 0];

		surTiles[6] = TileMap.tileMap[posX - 1][posY + 1];
		surTiles[7] = TileMap.tileMap[posX - 0][posY + 1];
		surTiles[8] = TileMap.tileMap[posX + 1][posY + 1];

		Fog.tileMap[posX - 1][posY - 1].type = 0;
		Fog.tileMap[posX - 0][posY - 1].type = 0;
		Fog.tileMap[posX + 1][posY - 1].type = 0;

		Fog.tileMap[posX - 1][posY - 0].type = 0;
		Fog.tileMap[posX - 0][posY - 0].type = 0;
		Fog.tileMap[posX + 1][posY - 0].type = 0;

		Fog.tileMap[posX - 1][posY + 1].type = 0;
		Fog.tileMap[posX - 0][posY + 1].type = 0;
		Fog.tileMap[posX + 1][posY + 1].type = 0;

		for (int i = 0; i < 9; i++) {
			if (surTiles[i].type == 1) {
				surWall[i] = true;
			} else {
				surWall[i] = false;
			}
		}

		if (surTiles[4].type == 2) {
			reset();
		}
		if (checkFog()) {
			reset();
			Level.load(1);
		}
	}

	private boolean checkFog() {

		boolean done = true;
		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {

				if (Fog.tileMap[x][y].type == 1) {
					done = false;
				}

			}

		}
		return done;
	}

	/*
	 * 0,1,2 3,4,5 6,7,8
	 */

	public void reset() {
		posX = 1;
		posY = 1;
		Fog.clearMap();
		Level.load(Level.curLevelIndex);

	}

	private void Input() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_W) && !surWall[1]) {
					posY--;
					screenY--;
					
				} else if (Keyboard.isKeyDown(Keyboard.KEY_S) && !surWall[7]) {
					posY++;
					
				} else if (Keyboard.isKeyDown(Keyboard.KEY_A) && !surWall[3]) {
					posX--;
					screenX--;
					
				} else if (Keyboard.isKeyDown(Keyboard.KEY_D) && !surWall[5]) {
					posX++;
					screenX++;
					
				}
			}
		}

	}

}
