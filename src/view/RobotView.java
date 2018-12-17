package view;

import java.io.IOException;
import model.Robot;
import utility.Input;

public class RobotView {

	public void printReport(Robot robot) {
		System.out.println("Output: " + robot.getX_position() + "," + robot.getY_position() 
							+ "," + getDirectionString(robot));
	}
	
	public String getCommand() throws IOException {
		return Input.getInputString("");
	}
	
	private String getDirectionString(Robot robot) {
		String direction = "";
		
		switch (robot.getF_direction())
		{
		case 0: direction = "NORTH"; break;
		case 1: direction = "EAST";  break;
		case 2: direction = "SOUTH"; break;
		case 3: direction = "WEST";  break;
		}
		
		return direction;
	}
	
}
