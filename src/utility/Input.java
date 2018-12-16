package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	private static BufferedReader getReader()
	{
		BufferedReader scanf = new BufferedReader(new InputStreamReader(System.in));
		return scanf;
	}
	public static String getInputString(String message) throws IOException
	{
		System.out.print(message);
		String input = getReader().readLine();
		return input;
	}
	public static int getInputInteger(String message) throws IOException
	{
		System.out.print(message);
		int output = Integer.parseInt(getReader().readLine());
		return output;
	}
	public static double getInputDouble(String message)throws IOException
	{
		System.out.print(message);
		double output = Double.parseDouble(getReader().readLine());
		return output;
	}
	public static char getInputChar(String message)throws IOException
	{
		System.out.print(message);
		char output = (getReader().readLine().charAt(0));
		return output;
	}
	
	public static void waitForReturnKey(String message)throws IOException
	{
		System.out.print(message);
		String output = getReader().readLine();
				
		return;
	}
}
