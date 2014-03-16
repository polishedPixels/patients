package Game.Map;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRectd;

import java.util.Random;

import Camera.Camera;

public class Fog {
	public static int[] worldSize = {10, 10};

	public static Tile[][] tileMap;
	static Random randy = new Random();

	public static void Init(int sizeX, int sizeY) {

		worldSize[0] = sizeX;
		worldSize[1] = sizeY;

		tileMap = new Tile[sizeX][sizeY];
		clearMap();
	}
	public static Tile getTilefromDouble(double X, double Y) {

		int px = (int) (X / Tile.size);
		int py = (int) (Y / Tile.size);

		return tileMap[px][py];

	}

	public static void setTile(int X, int Y, int Type) {
		tileMap[X][Y] = new Tile(X, Y, Type);
		int randText = randy.nextInt(3);
		if (tileMap[X][Y].type == 1 && randText == 0) {
			tileMap[X][Y].type = 1;
		} else if (tileMap[X][Y].type == 1 && randText == 1) {
			tileMap[X][Y].type = 2;
		} else if (tileMap[X][Y].type == 1 && randText == 2) {
			tileMap[X][Y].type = 3;
		}else{
			tileMap[X][Y].type = 1;
		}
	}
	public static void clearMap() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {
				setTile(x, y, 1);
			}
		}
	}

	public static void draw() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {

				switch (tileMap[x][y].type) {
					case 0 :// clear

						break;
					case 1 :// fog color 1
						glColor3f(1, 1, 1);
						glRectd(((x - Camera.mainCam.posX) * Tile.size),
								((y - Camera.mainCam.posY) * Tile.size),
								((x - Camera.mainCam.posX) * Tile.size)
										+ Tile.size,
								((y - Camera.mainCam.posY) * Tile.size)
										+ Tile.size);
						break;
					case 2 :// fog color 2
						glColor3f(.7f, .7f, .7f);
						glRectd(((x - Camera.mainCam.posX) * Tile.size),
								((y - Camera.mainCam.posY) * Tile.size),
								((x - Camera.mainCam.posX) * Tile.size)
										+ Tile.size,
								((y - Camera.mainCam.posY) * Tile.size)
										+ Tile.size);
						break;
					case 3 :// fog color 2
						glColor3f(.5f, .5f, .5f);
						glRectd(((x - Camera.mainCam.posX) * Tile.size),
								((y - Camera.mainCam.posY) * Tile.size),
								((x - Camera.mainCam.posX) * Tile.size)
										+ Tile.size,
								((y - Camera.mainCam.posY) * Tile.size)
										+ Tile.size);
						break;

					default :
						break;
				}

			}
		}
	}

}
