package com.jenu.lbdsa.t3.queue;

/*

Problem Statement:
       Budh International Circuit organised Formula 1 Racing in Noida.

While inspecting the circuit the management found that the fuel tanks that were setup had limited capacity of fuel and it also happened that if a car starts from some fuel tank it wont be able to reach the other fuel tank.
Now the management had the challenge of fixing point of start of race such the race completes at the same point.

Given Inputs:

    Fuel capacity at each fuel pump.
    Distance to the next fuel pump.
    There exist a point from where if the race is started it would complete.


To Find: 
      Find out the petrol pump starting at which you can go around and come back to that particular petrol pump.

*/

public class PetrolPump {

	static int startingPetrolPump(int[] petrol, int[] distance) {
		int totalPumps = petrol.length;
		int currentPetrol;
		int i = 0;
		int startingPump = 0;

		while (startingPump < totalPumps) {
			currentPetrol = petrol[i] - distance[i];
			while (currentPetrol >= 0) {
				i = (i + 1) % totalPumps;
				currentPetrol += petrol[i] - distance[i];
				if (i == startingPump) {
					return startingPump;
				}
			}
			startingPump = ++i;
			i = i % totalPumps;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] petrol = { 3, 5, 3, 8, 6 };
		int[] distance = { 4, 7, 4, 8, 1 };
		int startingPump = startingPetrolPump(petrol, distance);
		System.out.println("Starting Petrol Pump : " + startingPump);
	}
	
}
