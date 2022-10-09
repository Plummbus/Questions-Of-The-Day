package September;

/**
 * 
 * @author Franz Jacob hernandez (@herfrn)
 * @since 09-29-2022
 * 
 * 
 * "DnD Party, Part 1" - Day 6 of Questions of the Day for the discord/slack ATA study groups. Today's prompt covers topics covered in 4.3 Boolean Logic, 4.4 Comments/Debugging, and 5.1 Loops.
 * First-timers might have to look up extra concpets to attempt the prompt: (1) class constructors, (2) arrays, (3) helper methods. The optional challenge for the prompt
 * is at the bottom of the file: repeatRoles(). UML Diagram for class will be on the slack/discord post.
 * 
 * 
 */
public class Day_6 {

	public static void main(String[] args) {
		
		Party repeatParty = new Party("Cleric", "Barbarian", "Mage", "Barbarian");
		Party uniqueParty = new Party("Monk", "Ranger", "Paladin", "Theif");
		
		repeatParty.printParty();
		repeatParty.repeatRoles();
		
		uniqueParty.printParty();
		uniqueParty.repeatRoles();
		
		repeatParty.findRole("Barbarian");
		repeatParty.findRole("Mage");
		repeatParty.findRole("Warlock");
	}
	
	static class Party {
		
		private String[] roster;
		
		public Party(String first, String second, String third, String fourth) {
			this.roster = new String[4];
			this.roster[0] = first;
			this.roster[1] = second;
			this.roster[2] = third;
			this.roster[3] = fourth;
		}
		
		/**
		 * Iterates through the roster attribute and prints the String of each index to the console.
		 */
		public void printParty() {
			for (int i = 0; i < roster.length; i++) {
				System.out.printf("The role of party member #%d is: %s\n", i+1, roster[i]);
			}
		}
		
				
		/**
		 * Iterates through the roster attribute and prints a message to the console, depending on
		 * if the parameter "role" is a value present in roster.
		 * @param role - a String representation of a party member's class (ex. Barbarian, Thief, etc)
		 */
		public void findRole(String role) {
			int count = 0;
			String message = "";
			
			for (int i = 0; i < roster.length; i++) {
				if (roster[i].equals(role)) {
					count++;
				}
			}
			
			if (count == 0) {
				message += String.format("No one in the party has the role of %s, unfortunately.", role);
			} else if (count == 1) {
				message += String.format("A single party member has the role of %s!", role);
			} else {
				message += String.format("Multiple party members have the role of %s! There are %d of them.", role, count);
			}
			
			System.out.println(message);
		}
		
		
		/**
		 * Iterates through the roster attribute and prints a message to the console, depending on
		 * if there are repeat String values present in roster
		 */
		public void repeatRoles() {
			
			boolean repeatFound = false;
			int firstRepeat = 0;
			int secondRepeat = 0;
			String message = "";
			
			for (int i = 0; i < roster.length - 1; i++) {
				for (int j = i + 1; j < roster.length; j++) {
					if (roster[i].equals(roster[j])) {
						repeatFound = true;
						firstRepeat = i;
						secondRepeat = j;
					}
				}
			}
			
			if (repeatFound) {
				message += String.format("Repeats role were found!\n"
						+ "Party members #%d and #%d are both a %s", firstRepeat + 1, secondRepeat + 1, roster[firstRepeat]);
			} else {
				message += "No repeat roles were found in the party.";
			}
			
			System.out.println(message);
		}
		
	}

}
