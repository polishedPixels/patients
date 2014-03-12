package Game.Mobs;
import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Camera.Camera;
import Game.Map.Tile;
import Game.Map.TileMap;

public class Mob {

	int posX;
	int posY;
	double size;
	double[] rgb = new double[3];
	double centerX;
	double centerY;
	Tile[] surTiles = new Tile[9];
	boolean[] surWall = new boolean[9];
	public static Map<String, Mob> mobs = new HashMap<String, Mob>();

	Mob(int X, int Y, double Size, double r, double g, double b) {
		posX = X;
		posY = Y;
		size = Size;
		rgb[0] = r;
		rgb[1] = g;
		rgb[2] = b;

	}
	public static void DrawAll() {
		for (Mob m : mobs.values()) {
			m.draw();
		}
	}
	public static void createMob(String name, Mob m) {

		mobs.put(name, m);

	}

	public void draw() {
		glColor3d(rgb[0], rgb[1], rgb[2]);
		glRectd((posX * Tile.size) + size, (posY * Tile.size) + size,
				(posX * Tile.size) + 2 * size, (posY * Tile.size) + 2 * size);

	}

	public void Update() {
		// Per Step
		centerUpdate();
		surTileUpdate();
		colUpdate();
		move();

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


	}

	private void colUpdate() {
		for (int i = 0; i < 9; i++) {
			if (surTiles[i].type == 1) {
				surWall[i] = true;
			} else {
				surWall[i] = false;
			}
		}
	}

	private void move() {

	}

}

