package Game.Map;

import java.util.Random;

import Game.Main;
import Game.Mobs.Mob;

public class Level {

	public static Random randy = new Random();
	// must be same size as TileMap.tileMap
	public static int[][] map1 = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
			{5, 9, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 3, 4},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

	public static int[][] map2 = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

	public static int levelNum;
	public static int curLevelIndex = 0;
	public static int[/* X */][/* Y */][/* lvlIndex */] levels;

	public static void levelSetUp(int levelnum) {
		levels = new int[TileMap.worldSize[0]][TileMap.worldSize[1]][levelnum];
		for (int l = 0; l < levelnum; l++) {
			for (int x = 0; x < TileMap.worldSize[0]; x++) {
				for (int y = 0; y < TileMap.worldSize[1]; y++) {
					switch (l) {
						case 0 :
							levels[x][y][l] = map1[x][y];
							break;
						case 1 :
							levels[x][y][l] = map2[x][y];
							break;

						default :
							break;
					}

				}

			}
		}
	}

	public static void load(int loadLevel) {

		int[][] curMap = new int[TileMap.worldSize[0]][TileMap.worldSize[1]];

		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				curMap[x][y] = levels[y][x][loadLevel];
			}

		}
		setPlayerPos(curMap);
		curMap = setMines(curMap);
		//setKey
		int keyX = randy.nextInt(TileMap.worldSize[0]);
		int keyY = randy.nextInt(TileMap.worldSize[1]);
		while(curMap[keyX][keyY] == 1){
			keyX = randy.nextInt(TileMap.worldSize[0]);
			keyY = randy.nextInt(TileMap.worldSize[1]);
		}
		curMap[keyX][keyY] = 6;

		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				TileMap.tileMap[x][y] = new Tile(x, y, curMap[x][y]);
			}

		}
	}
	private static void setPlayerPos(int[][] CurTile) {

		Tile startTile = TileMap.tileMap[3][3];

		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				
				if(CurTile[x][y] == 3){
					
					startTile = TileMap.tileMap[x][y];
					
				}

			}
		}
		
		
		Main.player.posX = startTile.posX;
		Main.player.posY = startTile.posY;
		

	}
	public static void Reset(){
		Main.player.reset();
		for(Mob m: Mob.mobs.values()){
			m.reset();
		}
	}
	private static int[][] setMines(int[][] CurMap) {

		for (int x = 0; x < TileMap.worldSize[0]; x++) {
			for (int y = 0; y < TileMap.worldSize[1]; y++) {
				int mine = randy.nextInt(100);

				if (CurMap[x][y] == 0 && mine <= 10) {
					CurMap[x][y] = 2;

				}

			}
		}
		return CurMap;
	}
	
}

