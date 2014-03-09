import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mob {

	int posX;
	int posY;
	double size;
	double[] rgb = new double[3];
	public static Map<String,Mob>mobs = new HashMap<String,Mob>();

	Mob(int X, int Y, double Size, double r, double g, double b) {
		posX = X;
		posY = Y;
		size = Size;
		rgb[0] = r;
		rgb[1] = g;
		rgb[2] = b;

	}
	public static void DrawAll(){
		for(Mob m: mobs.values()){
			m.draw();
		}
	}
	public static void createMob(String name,Mob m){
		
		mobs.put(name, m);
		
	}

	public void draw() {
		glColor3d(rgb[0], rgb[1], rgb[2]);
		glRectd((posX * Tile.size) + size, (posY * Tile.size) + size,
				(posX * Tile.size) + 2 * size, (posY * Tile.size) + 2 * size);

	}

}
