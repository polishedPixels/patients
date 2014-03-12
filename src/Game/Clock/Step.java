package Game.Clock;
import Game.Main;


public class Step {

	public static double secPerStep = 0.5;
	public static boolean Pause = true;
	public static boolean Input = false;
	public static boolean next = false;

	private static int frame = 0;

	public static void Update() {

		if (!Pause || Input) {

			if (frame < Main.Sync * secPerStep) {
				
				frame++;
				Input = false;
				
			} else {
				
				next = true;
				
				frame = 0;

			}

		}

	}

}
