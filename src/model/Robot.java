package model;

import utility.Input;
import java.io.IOException;

/**
 * Robot Model Object
 */
public class Robot {
	
	private String name;
	private int x_position;
	private int y_position;
	private int f_direction;

	public Robot(String inputName) {
		this.name = inputName;
		this.x_position = 0;
		this.y_position = 0;
		this.f_direction = 0;
	}
	
	public void getCommand() {
		
		int command = 0;
		
		System.out.println("\nCommands for " + this.name + ":");
		System.out.println("1] Place");
		System.out.println("2] Move");
		System.out.println("3] Left");
		System.out.println("4] Right");
		System.out.println("5] Report");
		
		// keep asking while the command number entered is invalid
		while (command < 1 || command > 5) {
			try {
				command = Input.getInputInteger("Enter the number of your command: ");
			} catch (NumberFormatException | IOException e) {
				System.err.println(e.getMessage());
			}
			
			if (command < 1 || command > 5) System.out.println("Invalid command number. Please enter again.");
		}
		
		switch(command)
		{
		case 1: place();  break;
		case 2: move();   break;
		case 3: left();   break;
		case 4: right();  break;
		case 5: report(); break;
		default: getCommand();
		}
		
		return;
	}
	
	public void place() {
	
		do {
			try {
				this.x_position = Input.getInputInteger("\nEnter Position X: ");
			} catch (NumberFormatException | IOException e) {
				System.err.println(e.getMessage());
				return;
			}
			
			if (this.x_position < 0 || this.x_position > 4)
				System.out.println(this.name + ": Invalid Position X. Please enter again.");
			
		} while (this.x_position < 0 || this.x_position > 4);
		
		do {
			try {
				this.y_position = Input.getInputInteger("Enter Position Y: ");
			} catch (NumberFormatException | IOException e) {
				System.err.println(e.getMessage());
			}
			
			if (this.y_position < 0 || this.y_position > 4)
				System.out.println(this.name + ": Invalid Position Y. Please enter again.");
			
		} while (this.y_position < 0 || this.y_position > 4);
			
		do {
			try {
				System.out.println("Directions: \n1] North \n2] East \n3] South \n4] West");
				this.f_direction = Input.getInputInteger("Enter number of direction: ")-1; // get the number and subtract 1
			} catch (NumberFormatException | IOException e) {
				System.err.println(e.getMessage());
			}
			
			if (this.f_direction < 0 || this.f_direction > 3)
				System.out.println(this.name + ": Invalid Face Direction number. Please enter again.");
			
		} while(this.f_direction < 0 || this.f_direction > 3);
		
		return;
	}
	
	
	public void move() {
		System.out.println("Moving forward...");
		switch(this.f_direction) 
		{
		case 0: // NORTH
			this.y_position += 1;
				
			if (y_position > 4) {
				System.out.println("Woops.. I almost fell off table.");
				y_position -= 1;
			}
			break;
		
		case 1: // EAST
			this.x_position += 1;
			
			if (x_position > 4) {
				System.out.println("Woops.. I almost fell off table.");
				x_position -= 1;
			}
			break;
			
		case 2: // SOUTH
			this.y_position -= 1;
			
			if (y_position < 0) {
				System.out.println("Woops.. I almost fell off table.");
				y_position += 1;
			}
			break;
			
		case 3: // WEST
			this.x_position -= 1;
			
			if (x_position < 0) {
				System.out.println("Woops.. I almost fell off table.");
				x_position += 1;
			}
			break;
		}
	}
	
	
	// rotates the robot to the left
	public void left() {
		System.out.println("Rotating to the left...");
		this.f_direction -= 1;
		
		if (this.f_direction < 0) {
			this.f_direction = 3; // WEST
		}
		
		return;
	}
	
	
	// rotates the robot to the right
	public void right() {
		System.out.println("Rotating to the right...");
		this.f_direction += 1;
		
		if (this.f_direction > 3) {
			this.f_direction = 0; // NORTH
		}
		
		return;
	}
	
	
	// prints the position and the direction of the robot is facing
	public void report() {
		
		System.out.println("\nReporting position...\n<-- X - Y ----- F -->");
		System.out.println("    " + this.x_position + "   " + this.y_position + "     " + getDirectionString() + "\n");
		
		System.out.println("   0   1   2   3   4 ");
		System.out.println("  --- --- --- --- ---");
		
		
		
		for (int y=4; y >= 0; y--) {
			if (y == this.y_position) {
				System.out.print("   ");
				for(int x=0; x<= 4; x++) {
					if (x == this.x_position) {
						System.out.print(getIcon());
					} else {
						System.out.print("    ");
					}
					if (x==4) System.out.print(" | " + y + "\n\n");
				}
				
			} else {
				System.out.println("                     | " + y + "\n");
			}
		}
		return;
	}
	
	private String getDirectionString() {
		
		String direction = "";
		
		switch (this.f_direction)
		{
		case 0: direction = "NORTH"; break;
		case 1: direction = "EAST";  break;
		case 2: direction = "SOUTH"; break;
		case 3: direction = "WEST";  break;
		}
		
		return direction;
	}
	
	private char getIcon() {
		char icon = ' ';
		switch (this.f_direction)
		{
		case 0: icon = '^'; break; // NORTH
		case 1: icon = '>'; break; // EAST
		case 2: icon = 'v'; break; // SOUTH
		case 3: icon = '<'; break; // WEST
		}
		
		return icon;
	}

}
