package controller;

import java.io.IOException;
import model.Robot;
import view.RobotView;

public class RobotController {
	
	private Robot robot;
	private RobotView view;
	private String command;

	public RobotController(Robot robot, RobotView view) {
		this.robot = robot;
		this.view  = view;
	}
	
	public void start() throws IOException {
		String command;
		
		while (true) {
			command = view.getCommand();
			
			if (command.startsWith("PLACE")) 
				robot.place(command);
			else {
				switch(command)
				{
				case "MOVE":  robot.move(); break;
				case "LEFT":  robot.rotateLeft(); break;
				case "RIGHT": robot.rotateRight(); break;
				case "REPORT": 
					if (robot.isPlaced()) 
						view.printReport(robot); 
					break;
				}
			}
		}
	}
}
