package Camera;

public class Camera {
	public int posX;
	public int posY;
	
	public static Camera mainCam;
	
	public Camera(int PosX,int PosY) {
		
		posX = PosX;
		posY = PosY;
		
	}
	public void setPosition(int PosX,int PosY){
		posX = PosX;
		posY = PosY;
		
	}
	public static void setMain(Camera c){
		mainCam = c;
		
	}

}
