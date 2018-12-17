package access;

import java.io.IOException;
import model.Robot;
import controller.RobotController;
import view.RobotView;

public class RobotAccess {

	public static void main(String[] args) throws IOException {
		Robot robot = new Robot();
		RobotView view = new RobotView();
		RobotController controller = new RobotController(robot, view);
		
		System.out.println("Toy Robot Simulator\n");
		controller.start();
	}
}