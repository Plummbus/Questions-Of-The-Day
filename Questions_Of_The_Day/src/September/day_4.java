package September;

import java.util.Arrays;

/**
 * 
 * @author Franz Jacob Hernandez (herfrn)
 * @since 09-25-2022
 * 
 * Day 4 of "Questions of the Day" for ATA Study Group channel on slack.
 * There's no central topic for this day, just some problems that go over CS fundamentals.
 *
 */
public class day_4 {

	public static void main(String[] args) {
		
		multiplesOfSix();
		multiplesOfSix2();
		
		int[] singleIndexArray = new int[] { 1 };
		int[] oddArray = new int[] { 1, 2, 3, 4, 5 };
		int[] evenArray = new int[] { 1, 2, 3, 4, 5, 6};
		
		swapPairs(singleIndexArray);
		swapPairs(oddArray);
		swapPairs(evenArray);
		
		System.out.println(Arrays.toString(singleIndexArray));
		System.out.println(Arrays.toString(oddArray));
		System.out.println(Arrays.toString(evenArray));
		
		int testInt1 = 0;	//should return 0
		int testInt2 = 12;	//should return 3
		int testInt3 = 555;	//should return 6
		int testInt4 = 1046;	//should return 2
		int testInt5 = -473;	//should return 5
		
		System.out.println(testInt1 + " returns: " + sumToOne(testInt1));
		System.out.println(testInt2 + " returns: " + sumToOne(testInt2));
		System.out.println(testInt3 + " returns: " + sumToOne(testInt3));
		System.out.println(testInt4 + " returns: " + sumToOne(testInt4));
		System.out.println(testInt5 + " returns: " + sumToOne(testInt5));

	}
	
	/**
	 * Prints multiples of six from 6 to 600, uses modulo.
	 */
	public static void multiplesOfSix() {
		for (int i = 6; i <= 600; i++) {
			if (i % 6 == 0) {
				System.out.println(i);
			}	
		}
	}
	
	/**
	 * Prints multiples of six from 6 to 600, increments i by 6 each iteration.
	 */
	public static void multiplesOfSix2() {
		for (int i = 6; i <= 600; i+=6) {
			System.out.println(i);
		}
	}
	
	/**
	 * Given an integer array, swaps successive pairs of values. Leaves the last index
	 * untouched if the array length is odd.
	 * @param arr - an integer array
	 */
	public static void swapPairs(int[] arr) {
		//iterating through the array
		//incrementing by 2 instead of 1 because we care about each pair, rather than each value
		for (int i = 0; i < arr.length; i+=2) {
			//checking if at a certain value of i, if we even have a pair available
			if (i + 1 < arr.length) {
				//if we do have a pair available, swap the values using a temp variable.
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}
	
	/**
	 * This method takes in an integer keeps summing the invidivual digits of the integer together
	 * until there is only 1 digit left, then returns that digit.
	 * @param num - an integer
	 * @return numCheck - a single-digit integer from 1 to 9
	 */
	public static int sumToOne(int num) {
		
		boolean isSolo = false;
		//instantiating numCheck here so it doesn't get completely reset between loops
		int numCheck = num;		
		if (numCheck < 0) {
			numCheck *= -1;
		}
		
		//loop will break when we just have a 1-digit long integer
		while(!isSolo) {
			
		
			//getting the size we need for an array by converting the integer into a String and getting the length
			int[] digitStorage = new int[String.valueOf(numCheck).length()];
			int i = 0;
			
			
			//going to iterate through the number, popping off the digit in the 'ones' spot until there
			//are no digits left
			
			
			while (numCheck > 0) {
				//num % 10 gets us the digit in the 'ones' spot
				digitStorage[i] = numCheck % 10;
				//dividing num by 10 here reduces it by a power of 10, so 356 -> 35 (drop off whatever is in the 'ones' spot)
				numCheck = numCheck / 10;
				i++;
			}
			
			//can make this a different variable, was easier for me
			//to conecptualize by keeping it the same
			numCheck = 0;
			
			//iterate through digitStorage and sum all the values
			for (int x = 0; x < digitStorage.length; x++) {
				numCheck += digitStorage[x];
			}
			
			//if numCheck has just 1 digit, we've reached our answer
			if (numCheck >= 0 && numCheck < 10) {
				isSolo = true;
			}		 
		
		}
		return numCheck;
	}

}
