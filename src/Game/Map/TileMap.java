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
	public static Tile getTilefromDouble(double X, double Y) {

		int px = (int) (X / Tile.size);
		int py = (int) (Y / Tile.size);
		

		return tileMap[px][py];

	}

	public static void draw() {
		for (int x = 0; x < worldSize[0]; x++) {
			for (int y = 0; y < worldSize[1]; y++) {

				switch (tileMap[x][y].type) {
				case 0://open
					glColor3f(0, 0, 0);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);
					break;
				case 1://wall
					glColor3d(0.541, 0.427, 0.231);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);
					break;
				case 2://mine
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
				case 4://Entance
					glColor3d(0, 1, 0);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);

					break;
				case 5://Exit
					glColor3d(0, 1, 0.898);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);

					break;
				case 6://Key
					glColor3d(1, 0.984, 0);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);

					break;

				default://open
					glColor3f(0, 0, 0);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);
					break;
				}

			}
		}
	}

}
