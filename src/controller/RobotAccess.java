package controller;

import java.io.IOException;
import model.Robot;
import utility.Input;

public class RobotAccess {

	public static void main(String[] args) {
		
		Robot robot = new Robot(intro()); 
		robot.place();
		
		do {
			robot.getCommand();
		} while(true);
	}
	
	public static String intro() {
		String name = null;
		try {
			name = Input.getInputString("Hello there. I am... I am... who am I? (Enter robot's name) ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name + ": I am " + name + "? What a weird name. Anyways, what is my purpose? ");
		
		try {
			Input.waitForReturnKey("Press enter to continue...");
			System.out.println("\nYou: You move around the table without falling off.");
			Input.waitForReturnKey("Press enter to continue...\n");
			System.out.println(name + ": That's it? Ookay... Where do I start?");
			Input.waitForReturnKey("Press enter to continue...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}

}
