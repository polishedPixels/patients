package Game.Map;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRectd;
import Camera.Camera;


public class Fog {
	public static int[] worldSize = { 10, 10 };

	public static Tile[][] tileMap;

	
	public static void Init(int sizeX, int sizeY){
		
		worldSize[0] = sizeX;
		worldSize[1] = sizeY;

		tileMap = new Tile[sizeX][sizeY];
		clearMap();
	}

	public static void setTile(int X, int Y, int Type) {
		tileMap[X][Y] = new Tile(X, Y, Type);
	}
	public static void clearMap(){
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
				case 0://clear
					
					break;
				case 1://fog
					glColor3f(1,1,1);
					glRectd(((x - Camera.mainCam.posX) * Tile.size),
							((y - Camera.mainCam.posY) * Tile.size),
							((x - Camera.mainCam.posX) * Tile.size) + Tile.size,
							((y - Camera.mainCam.posY) * Tile.size) + Tile.size);
					break;

				default:
					break;
				}

			}
		}
	}

}
