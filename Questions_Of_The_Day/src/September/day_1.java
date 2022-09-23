package September;

import java.util.Arrays;

/**
 * 
 * @author Franz Jacob Hernandez (herfrn)
 * @since 9/22/2022
 * 
 * Day 1 of "Questions of the Day" for ATA Study Group channel on slack.
 * There's no central topic for this day, just some problems that go over CS fundamentals.
 *
 */
public class day_1 {

	//main method is just for testing/showing that the methods work
	public static void main(String[] args) {
		
		helloWorld();
		int[] newArr = pushFront(new int[] {1, 2, 3, 4}, 0);
		System.out.println(Arrays.toString(newArr));
		System.out.println(fibonacci(6));
	}
	
	/**
	 * void method that prints "Hello World!" to the console 100 times
	 */
	public static void helloWorld() {
		//create a for loop and iterate through loop 100 times
		//since we're starting at i = 0, we can have the last loop be i = 99, which is how the for loop is currently written
		//if you wanted to start with i = 1, then the condition to break the loop would have to be <= instead of just <
		for(int i = 0; i < 100; i++){
            System.out.println("Hello World!");
        }
	}
	
	/**
	 * Given an integer array and an integer value, the method returns a new array with that integer value at the front
	 * of the integer array that was passed.
	 * @param arr - an integer array
	 * @param val - an integer value that will go inside the array
	 * @return newArr - the new array with the old array values + the integer value at the front
	 */
	public static int[] pushFront(int[] arr, int val) {
		int[] newArr = new int[arr.length + 1];
		newArr[0] = val;
		for (int i = 0; i < arr.length; i++) {
			newArr[i + 1] = arr[i];
		}
		
		return newArr;
	}
	
	/**
	 * Returns the integer value at the specific index of the Fibonacci sequence -> n = (n-1) + (n-2)
	 * @param num - index of sequence to stop at
	 * @return - the integer value of the desired index
	 */
	public static int fibonacci(int num) {
		//base case, if num is ever less than 2 (so 0 or 1)
		if (num < 2) {
			return num;	//will return 0 or 1
		//this is the recursive case, will keep getting called until we hit the base case
		} else {
			//need to decrement num so we eventually hit the base case, at which point all the called methods will start returning values
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}

}
