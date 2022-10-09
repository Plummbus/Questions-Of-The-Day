package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {
	
	public enum Element {
		C, H, N, O, P, S
	}
	
	public static void main(String[] args) {
		String el = translateSymbol(Element.C);
		String el2 = translateSymbol("H");
		System.out.println(el);
		System.out.println(el2);
		System.out.println(Arrays.toString(Element.values()));
		
		ArrayList<String> meh = blah();
		System.out.println(meh.toString());
		
		System.out.println(Arrays.toString(twoSum(new int[] {3, 3}, 6)));
		String word = "asd";
		System.out.println(word.length());

	}
	
	public static ArrayList<String> blah() {
		ArrayList<String> arList = new ArrayList<String>();
		for (Element e : Element.values()) {
			arList.add(e.name());
		}
		return arList;
	}
	
	public static String translateSymbol(Element element) {
		String answer = "";
		switch (element.name()) {
		case "C":
			answer += "Carbon";
			break;
		case "H":
			answer += "Hydrogen";
			break;
		case "N":
			answer += "Nitrogen";
			break;
		case "O":
			answer += "Oxygen";
			break;
		case "P":
			answer += "Phosphorus";
			break;
		case "S":
			answer += "Sulfur";
			break;
		default:
			break;
		}
		
		return answer;
    }
	
	public static String translateSymbol(String elementStr) {
		return translateSymbol(Element.valueOf(elementStr));
    }
	
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
            	System.out.println("i: index " + i + " is: " + nums[i]);
            	System.out.println("j: index " + j + " is: " + nums[j]);
                if (nums[i] + nums[j] == target) {
                	System.out.println(i);
                	System.out.println(j);
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
	
	
	
}
