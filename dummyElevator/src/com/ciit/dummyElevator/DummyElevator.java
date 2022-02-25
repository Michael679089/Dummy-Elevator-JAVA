package com.ciit.dummyElevator;

//Imports
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;



public class DummyElevator {

	public static void main(String[] args) throws IOException, InterruptedException{
		InputStreamReader input = new InputStreamReader (System.in);
		BufferedReader reader = new BufferedReader (input);
		Queue<String> passengerList = new LinkedList<String>();
		Queue<Integer> FloorsOfPassenger = new LinkedList<Integer>();
		LinkedList<String> logList = new LinkedList<String>();
				
		
		
		// Variables
		boolean elevatorOn = false;
		boolean goingUp = false;
		char option = ' ';
		int x = 0;
		int elevtrSleep = 0;
		Integer floorInput = 0;
		String nameInput = "";
		
		
		while (option != 'N') 
		{
			System.out.println("Activate Elevator? Y = Yes / N = No / C = Check Log Book");
			System.out.print(">");
			option = reader.readLine().charAt(0); 
			
			//Check Option
			if (option == 'Y') {
				elevatorOn = true;
				goingUp = true;
			}
			else if (option == 'C') {
				for (String i: logList) {
					System.out.println(i);
				}
			}
			else if (option == 'N') {
				elevatorOn = false;
				goingUp = false;
				System.out.println("Bye bye!");
			}
			
					
			
			while (passengerList.size() < 10 && elevatorOn == true) {
				System.out.println("Number of Passengers: " + passengerList.size());
				System.out.print("Input Name: ");
				nameInput = reader.readLine();
				System.out.print("Input Floor: ");
				floorInput = Integer.parseInt(reader.readLine());
				while (floorInput > 25) {
					System.out.println("[Error] Wrong Input\n:");
					floorInput = Integer.parseInt(reader.readLine());
				}
				System.out.println(" ");
				
				
				passengerList.add(nameInput);
				FloorsOfPassenger.add(floorInput);
				logList.add("Name: " + nameInput + " - Floor: " + floorInput);
				} 
			
			
			
			// Elevator Mechanic
			while (elevatorOn == true && passengerList.size() > 0) 
			{
				// Going Up 
				while (goingUp == true  && passengerList.peek() != null) {
					x = x + 1;
					System.out.println("[floor: " + x + "]");
					System.out.println("Passengers left: " + passengerList.size() + "\n");
					if (FloorsOfPassenger.peek() == x) {
						FloorsOfPassenger.remove();
						passengerList.remove();
					}
					if (x == 25) {
						goingUp = false;
					}
					Thread.sleep(elevtrSleep);
				}
				
				// Going Down
				while (goingUp == false && passengerList.peek() != null) {
					x = x - 1;
					System.out.println("[floor: " + x + "]");
					System.out.println("Passengers left: " + passengerList.size() + "\n");
					if (FloorsOfPassenger.peek() == x) {
						FloorsOfPassenger.remove();
						passengerList.remove();
					}
					
					if (x == 0) {
						goingUp = true;
					}
					Thread.sleep(elevtrSleep);
				}
				
				if (passengerList.isEmpty()) {
					System.out.println("[floor: " + x + "]");
					System.out.println("Passengers left: " + passengerList.size() + "\n");
					System.out.println("All passengers have exited the elevator\n");
					x = 0;
				}
			}
			
			
		
			elevatorOn = false;
			goingUp = false;
		}
		
	}
}
	