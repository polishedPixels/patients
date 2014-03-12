package Game.Map;


public class Tile {
	
	public int posX;
	public int posY;
	
	public int type;
	
	public static final double size = 32;
	
	/*
	 * Types
	 * 	0 = open
	 * 	1 = wall
	 *  2 = mine
	 *  3 = start
	 *  4 = finish
	 * */
	
	public Tile(int X,int Y,int Type){
		
		posX = X;
		posY = Y;
		type = Type;
		
	}
	

}
