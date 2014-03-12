package Game.Clock;
import Game.Main;


public class Step {

	public static double secPerStep = 0.5;
	public static boolean Pause = false;
	public static boolean next = false;

	private static int frame = 0;

	public static void Update() {

		if (!Pause) {

			if (frame < Main.Sync * secPerStep) {
				
				frame++;
				
				
			} else {
				
				next = true;
				frame = 0;

			}

		}

	}

}
