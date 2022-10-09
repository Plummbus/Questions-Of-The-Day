package September;

import java.util.Arrays;


/**
 * 
 * @author Franz Jacob Hernandez (herfrn)
 * @since 9/23/2022
 * 
 * Day 3 of "Questions of the Day" for ATA Study Group channel on slack.
 * There's no central topic for this day, just some problems that go over CS fundamentals.
 *
 */
public class day_3 {

	//code block for main method just for testing/showcase purposes
	public static void main(String[] args) {
		
		printSum();
		
		int count = 0;
		for (int i = 0; i < 1001; i ++) {
			boolean result = isPrime(i);
			if (isPrime(i)) {
				count++;
			}
			String message = String.format("Is %d a prime number: %b", i, result);
			System.out.println(message);
		}
		System.out.println("Number of primes: " + count);
		
		int[] testDupes = { 0, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7, 7, 8, 8 };
		int[] moreDupes = { -3, -3, -3, -3, -3, -3 };
		int[] noDupes = { 0 };
		
		System.out.println(Arrays.toString(removeDupes1(testDupes)));
		System.out.println(Arrays.toString(removeDupes1(moreDupes)));
		System.out.println(Arrays.toString(removeDupes1(noDupes)));
		
		System.out.println(Arrays.toString(removeDupes2(testDupes)));
		System.out.println(Arrays.toString(removeDupes2(moreDupes)));
		System.out.println(Arrays.toString(removeDupes2(noDupes)));
		
		System.out.println(Arrays.toString(removeDupes3(testDupes)));
		System.out.println(Arrays.toString(removeDupes3(moreDupes)));
		System.out.println(Arrays.toString(removeDupes3(noDupes)));


	}
	
	/**
	 * Prints the numbers from 0 to 100, and the sum of all the numbers thus far.
	 */
	public static void printSum() {
		
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			sum += i;
			String message = String.format("Number: %d; Sum so far: %d", i, sum);
			System.out.println(message);
		}	
	}
	
	/**
	 * Method takes in an integer and retruns true if the integer is a prime number,
	 * false if it is NOT a prime number.
	 * @param num - an integer
	 * @return a boolean
	 */
	public static boolean isPrime(int num) {
		if (num < 0) {
			num *= -1;
		}
		
		if (num == 0 || num == 1) {
			return false;
		} else if (num == 2 || num == 3) {
			return true;
		} else {
			for (int i = num - 1; i > 1; i--) {
				if (num % i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Method that takes a sorted integer array, and returns a new array
	 * with only distinct values from that array that was passed. This implementation
	 * does not use any built-in methods.
	 * @param originalArr - an integer array
	 * @return finalArr - a resized, distinct-values-only version of originalArr
	 */
	public static int[] removeDupes1(int[] originalArr) {
		
		//creating a temp array with the same length
		int[] tempArr = new int[originalArr.length];
		//another index counter, going to use this to track where we are in tempArr
		int secondaryIndex = 0;
		//we will count how many dupes we find as we iterate through the array
		int dupes = 0;
		
		//iterate through originalArr
		for (int i = 0; i < originalArr.length - 1; i++) {
			//current is whatever index we're at on originalArr
			int current = originalArr[i];
			
			//if current is a diferent integer than the integer directly after it....	
			if (current != originalArr[i + 1]) {
				//add current to the tempArr at the secondaryIndex index
				tempArr[secondaryIndex] = current;
				//increment secondary index, so we'd push a new value to the next 'empty' spot
				secondaryIndex++;
			} else {
				dupes++;
			}
		}
		
		//push last distinct value from originalArr to tempArr
		tempArr[secondaryIndex] = originalArr[originalArr.length - 1];
		
		int[] finalArr = new int[tempArr.length - dupes];
		for (int j = 0; j < finalArr.length; j++) {
			finalArr[j] = tempArr[j];
		}
		return finalArr;
	}
	
	
	/**
	 * Method that takes a sorted integer array, and returns a new array
	 * with only distinct values from that array that was passed. This implementation
	 * uses two built-in methods: split() and parseInt().
	 * @param originalArr - an integer array
	 * @return finalArr - a resized, distinct-values-only version of originalArr
	 */
	public static int[] removeDupes2(int[] arr) {
		int current = arr[0];
		String temp = current + ",";
		boolean isFound = false;
		
		for (int i = 1; i < arr.length; i++) {
			//if we find a value that's greater than our current value of i (a different value)
			//concat that value onto our string temp
			if (current != arr[i]) {
				temp += arr[i] + ",";
				//and then that value becomes our new value of i
				current = arr[i];
			}
		}
		
		//create a string array of just the integer values and remove all the ',' characters
		String[] stringArray = temp.split(",");
		//create an int[] of the same length as the stringArray
		int[] finalArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			//iterate through stringArray and pass each value to the finalArray
			//turn each String representation of integer into an actual integer
			finalArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		return finalArray;
	}
	
	/**
	 * Method that takes a sorted integer array, and returns a new array
	 * with only distinct values from that array that was passed. This implementation
	 * passes the array to a IntStream, removes the duplicate values with distinct(), then
	 * reverts the IntStream back into an array.
	 * @param originalArr - an integer array
	 * @return finalArr - a resized, distinct-values-only version of originalArr
	 */
	public static int[] removeDupes3(int[] arr) {
		return Arrays.stream(arr).distinct().toArray();
	}

}
