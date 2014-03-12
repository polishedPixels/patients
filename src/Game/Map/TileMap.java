package Game.Map;

import static org.lwjgl.opengl.GL11.*;
import Camera.Camera;

public class TileMap {
	public static int[] worldSize = { 20, 20 };

	public static Tile[][] tileMap;

	public static void Init(int sizeX, int sizeY) {

		worldSize[0] = sizeX;
		worldSize[1] = sizeY;

		tileMap = new Tile[sizeX][sizeY];
		clearMap();
	}

	public static void setTile(int X, int Y, int Type) {
		tileMap[X][Y] = new Tile(X, Y, Type);
	}

	public static void clearMap() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {
				setTile(x, y, 0);
			}
		}
	}

	public static void draw() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {

				switch (tileMap[x][y].type) {
				case 0:
					glColor3f(0, 0, 0);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);
					break;
				case 1:
					glColor3f(0.5f, 0.5f, 0.5f);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);
					break;
				case 2:
					glColor3f(0, 0, 0);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);
					glColor3f(1, 0, 0);
					double centerX = ((tileMap[x][y].posX - Camera.mainCam.posX) * Tile.size)
							+ Tile.size / 2;
					double centerY = ((tileMap[x][y].posY - Camera.mainCam.posY) * Tile.size)
							+ Tile.size / 2;

					glRectd(centerX - 3, centerY - 3, centerX + 3, centerY + 3);

					break;

				default:
					break;
				}

			}
		}
	}

}
