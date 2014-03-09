
public class Camera {
	int posX;
	int posY;
	
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
