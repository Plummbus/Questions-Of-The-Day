package September;


/**
 * 
 * @author Franz Jacob hernandez (@herfrn)
 * @since 09-30-2022
 * 
 * "DnD Party, Part 2" - Day 7 of Questions of the Day for the discord/slack ATA study groups. 
 * 
 *
 */
public class Day_7 {

	
	public static void main(String[] args) {
		
		//Test code inside main just for testing Day 7's new code
		
		Party emptyParty = new Party(5);
		emptyParty.printParty();
		
		emptyParty.addToRoster("Bard");
		emptyParty.addToRoster("Druid");
		emptyParty.addToRoster("Sorcerer");
		emptyParty.addToRoster("Warlock");
		emptyParty.addToRoster("Artificer");
		emptyParty.addToRoster("Wizard");		//won't be in roster because it's full
		emptyParty.printParty();
		
		emptyParty.addAtIndex("Fighter", 2);	//will replace Sorcerer
		emptyParty.printParty();
		
		emptyParty.addAtIndex("Hunter", -1);	//should print custom error message
	}
	
	//TODO
	//try catch, throw
	//helper methods
	//break

	
	
	static class Party {
		
		/*
		 * 
		 * THIS IS CODE FROM YESTERDAY's PROMPT
		 * ALL EXCEPT THE ATTRIBUTE AND CONSTRUCTOR CAN BE DELETED
		 * 
		 */
		
		
		private String[] roster;
		
		public Party(String first, String second, String third, String fourth) {
			this.roster = new String[4];
			this.roster[0] = first;
			this.roster[1] = second;
			this.roster[2] = third;
			this.roster[3] = fourth;
		}
		
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
		
		/*
		 * 
		 * THESE ARE HELPER METHODS FOR DAY 7:
		 * 
		 */
		
		public Party(int size) {
			this.roster = new String[size];
		}
		
		public void printParty() {
			for (int i = 0; i < roster.length; i++) {
				System.out.printf("The role of party member #%d is: %s\n", i+1, roster[i]);
			}
		}
		
		
		public String[] getRoster() {
			return this.roster;
		}
		
		public boolean findRoleWithBreak(String role) {
			
			boolean roleFound = false;
			
			for (int i = 0; i < roster.length; i++) {
				if (roster[i].equals(role)) {
					roleFound = true;
					break;
				}
			}
			
			return roleFound;
		}
		
		
			
		public void addAtIndex(String role, int number) {
			try {
				roster[number] = role;
			} catch (Exception e) {
				System.out.println("Number passed is out of bounds for the roster array!");
			}
		}
		
		public void addToRoster(String role) {

			boolean emptySpot = false;
			
			for (int i = 0; i < roster.length; i++) {
				if (roster[i] == null) {
					emptySpot = true;
					roster[i] = role;
					System.out.println(role + " was placed in the roster at #" + (i + 1));
					break;
				}
			}
			
			if (!emptySpot) {
				System.out.println("Roster is full! Cannot place role in roster.");
			}
		}
	}

}
