package model;

/**
 * Robot Model Object
 */
public class Robot {
	
	private int x_position;
	private int y_position;
	private int f_direction;
	private boolean placed;

	public Robot() {
		this.placed = false;
	}
	
	public void place(String command) {
		
		String[] args;
		
		try {
			args = command.substring(command.indexOf("E")+2).split(",");
		} catch(StringIndexOutOfBoundsException ex) {
			return;
		}
		
		if (args.length > 3 || args.length <= 0) return;
		
		int x, y;
		try {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			return;
		}
		
		if (x != 0 && x != 1 && x != 2 && x!= 3) return;
		if (y != 0 && y != 1 && y != 2 && y!= 3) return;
		
		switch(args[2]) 
		{
		case "NORTH": this.f_direction = 0; break;
		case "EAST":  this.f_direction = 1; break;
		case "SOUTH": this.f_direction = 2; break;
		case "WEST":  this.f_direction = 3; break;
		default: return;
		}
		
		this.x_position = x;
		this.y_position = y;
		
		this.placed = true;
	}
	
	
	public void move() {
		if (!this.placed) return;
		
		switch(this.f_direction) 
		{
		case 0: // NORTH
			this.y_position += 1;
				
			if (y_position > 4) {
				y_position -= 1;
			}
			break;
		
		case 1: // EAST
			this.x_position += 1;
			
			if (x_position > 4) {
				x_position -= 1;
			}
			break;
			
		case 2: // SOUTH
			this.y_position -= 1;
			
			if (y_position < 0) {
				y_position += 1;
			}
			break;
			
		case 3: // WEST
			this.x_position -= 1;
			
			if (x_position < 0) {
				x_position += 1;
			}
			break;
		}
	}
	
	
	// rotates the robot to the left
	public void rotateLeft() {
		if (!this.placed) return;
		
		this.f_direction -= 1;
		
		if (this.f_direction < 0) {
			this.f_direction = 3; // WEST
		}
		
		return;
	}
	
	// rotates the robot to the right
	public void rotateRight() {
		if (!this.placed) return;
		
		this.f_direction += 1;
		
		if (this.f_direction > 3) {
			this.f_direction = 0; // NORTH
		}
		
		return;
	}

	public int getX_position() {
		return x_position;
	}

	public void setX_position(int x_position) {
		this.x_position = x_position;
	}

	public int getY_position() {
		return y_position;
	}

	public void setY_position(int y_position) {
		this.y_position = y_position;
	}

	public int getF_direction() {
		return f_direction;
	}

	public void setF_direction(int f_direction) {
		this.f_direction = f_direction;
	}
	
	public boolean isPlaced() {
		return this.placed;
	}
}
