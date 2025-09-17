import java.awt.MouseInfo;
import java.awt.PointerInfo;

public class MouseController {

	public static void main(String[] args) {
		try {
			Thread.sleep(10000);
			PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//			(1451, 151) submit
//			(98, 64) refresh
//			(1413, 765) start tasking button
			
			int mouseX = pointerInfo.getLocation().x;
			int mouseY = pointerInfo.getLocation().y;

			System.out.println("Current Mouse Coordinates: (" + mouseX + ", " + mouseY + ")");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		try {
//			Robot robot = new Robot();
//
//			int targetX = -470;
//			int targetY = 141;
//
//			Thread.sleep(3 * 60 * 1000);
//
//			int currentX = (int) (MouseInfo.getPointerInfo().getLocation().getX());
//			int currentY = (int) (MouseInfo.getPointerInfo().getLocation().getY());
//
//			double distanceX = (targetX - currentX) / 100.0;
//			double distanceY = (targetY - currentY) / 100.0;
//
//			for (int i = 0; i < 100; i++) {
//				currentX += distanceX;
//				currentY += distanceY;
//				robot.mouseMove(currentX, currentY);
//				Thread.sleep(50); // Adjust the delay for animation speed
//			}
//
//			robot.mouseMove(targetX, targetY);
//
//			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//
//		} catch (AWTException | InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
}
