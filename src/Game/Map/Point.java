package Game.Map;

public class Point {
	public double posX,posY;
	public Tile curTile;
	public Tile fogTile;
	
	public Point(double X,double Y){
		posX = X;
		posY = Y;
		
		curTile = TileMap.getTilefromDouble(X, Y);
		fogTile = Fog.getTilefromDouble(X, Y);
	}
	public void setPos(double X, double Y){
		posX = X;
		posY = Y;
		
		try {
			curTile = TileMap.getTilefromDouble(X, Y);
			fogTile = Fog.getTilefromDouble(X, Y);
		} catch (Exception e) {
			curTile = TileMap.getTilefromDouble(0, 0);
			fogTile = Fog.getTilefromDouble(0, 0);
		}
		
		
	}
	
}
