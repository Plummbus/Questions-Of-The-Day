package September;

import java.util.Arrays;

/**
 * 
 * @author Franz Jacob Hernandez (herfrn)
 * @since 9/23/2022
 * 
 * Day 2 of "Questions of the Day" for ATA Study Group channel on slack.
 * There's no central topic for this day, just some problems that go over CS fundamentals.
 *
**/
public class day_2 {

	public static void main(String[] args) {
		printOdds();
		
		int[] insertArr = insertAt(new int[] {1, 2, 3, 4, 5}, 10, 2);		//inserting in the middle
		System.out.println(Arrays.toString(insertArr));
		insertArr = insertAt(insertArr, 0, 0);								//inserting at the first index
		System.out.println(Arrays.toString(insertArr));
		insertArr = insertAt(insertArr, 100, insertArr.length - 1);			//inserting at the last index
		System.out.println(Arrays.toString(insertArr));
		
		mostSignificantDigit(802230038.0000123);		//big number test case
		mostSignificantDigit(-.00056999);				//negative with leading zeroes test case
	}
	
	/**
	 * Prints all the odd integers from 1 to 255 (inclusive)
	 */
	public static void printOdds() {
		for (int i = 1; i < 256; i+=2) {
			System.out.println(i);
		}
	}
	
	/**
	 * Given an integer array, an integer value, and an integer index, returns a new array
	 * with the value at the specified index, with the rest of the array indicies filled in with the values
	 * in order from the passed array. Values will be shifted indicies in new array if the passed value displaces them.
	 * @param arr - an integer array
	 * @param value - an integer value
	 * @param index - the index where the value is to be placed
	 * @return newArr - the old array with the value at the specified index, possibly with some values shifted over
	 */
	public static int[] insertAt(int[] arr, int value, int index) {
		
		if (index >= 0 && index <= arr.length - 1) {		//some basic error checking for a valid index
			int[] newArr = new int[arr.length + 1];		//since we're adding another value to the array, we know the new size will be 1 bigger than it originally was
			for (int i = 0; i <= arr.length; i++) {		//need less than or equal to since we're looking for arr[i - 1] once we get passed the target index.
				if (i == index) {
					newArr[i] = value;					//place value at this index if i = target index
				} else  if (i < index) {
					newArr[i] = arr[i];					//if we haven't made it to the target yet, jsut copy that values index to index
				} else {
					newArr[i] = arr[i - 1];				//if we're passed the target index, we need to account for the new array's index being 1 off from the original, since it has a new value in the way
				}
			}
			return newArr;
		} else {
			return null;
		}
	}
	
	

	/**
	 * Given a double, this method will print the most significant digit of that double(left-most digit). Will account for negative values.
	 * 
	 * @param num - a double value
	 */
	public static void mostSignificantDigit(double num) {
		double input = num;		//copying num to another variable so we can use the original input in the output message later on.
		int modifier = 10;
		int sigDig = 0;
		
		if (input < 0) {
			input *= -1;	//flip signs if negative
		}
		
		if (input >= 1) {
			while (input >= 10) {
				input = input / 10;				//reduce input by powers of 10 till it's less than 10, greater than equal to 1,
												//so if our double was 8532, it would become 8.532
			}
		} else {
			while (input <= 1) {		
				input = input * modifier;		//keep multiplying input by 10 until it's at least greater than or equal to 1,
			}									//once it's greater than equal to 1, we can just grab that number and round down to have our int
		}
		
		sigDig = (int) input;	//casting from double to int truncates
		String message = String.format("Inputted number: %f"
				+ "\nSignificant digit: %d", num, sigDig);
		System.out.println(message);
			
	}

}
