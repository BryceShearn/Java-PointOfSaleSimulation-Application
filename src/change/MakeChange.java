package change;

import java.util.Scanner;
public class MakeChange {

	public static void main(String[] args) {
		
		Scanner cashRegister = new Scanner(System.in);	
		                         //variables
		double itemPrice, tenderedAmount,tenderDue= 0.0, seperateChange= 0.0;
		int pennies, nickels, dimes, quarters,ones, tens, fives, twenties;
								//constants
		final double PENNIES = .01, NICKELS = .05, DIMES = .1, QUARTERS = .25, ONES = 1;
		final double FIVES = 5, TENS = 10, TWENTIES = 20;
		
	//	computerImage();		   //menu
		System.out.print("What is the price of the item?:");
		itemPrice = cashRegister.nextDouble();		

		System.out.print("Enter amount tendered:");
		tenderedAmount = cashRegister.nextDouble();
		
		tenderDue = tenderedAmount - itemPrice;
		 //loop menu for invalid user input or incorrect tender amount
			while (tenderedAmount == itemPrice) {
				System.out.println("No change due ~ sale complete");
			}
			while (tenderDue < 0) {
				System.out.println("Insufficient tender entered");
				saleLimiterResponse(cashRegister);
			}
			while (tenderDue > 5000 ) {
				System.out.println("Number exceeds transaction limit");
				saleLimiterResponse(cashRegister);
			}
						//prints non descriptive total
		System.out.printf("Change Due: [$%.2f", tenderDue);System.out.print("]" + "\n");
			//determines amount of each currency to proceed with printouts
		twenties = (int) Math.floor(tenderDue/TWENTIES);
		tens = (int) Math.floor((tenderDue - twenties * TWENTIES)/TENS);
		fives = (int) Math.floor((tenderDue - twenties * TWENTIES - tens * TENS)/FIVES);
		ones = (int) Math.floor((tenderDue - twenties * TWENTIES - tens * TENS - fives * FIVES));
		seperateChange = tenderDue - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * ONES;
			
		seperateChange = Math.round(seperateChange * 100.0) /100.0;
		quarters =  (int) Math.floor(seperateChange/QUARTERS);
	    seperateChange = tenderDue - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * ONES - quarters * QUARTERS;
			
		seperateChange = Math.round(seperateChange * 100.0) /100.0;
		dimes =  (int) Math.floor(seperateChange/DIMES);
		seperateChange = tenderDue - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * ONES - quarters * QUARTERS - dimes * DIMES;
			
		seperateChange = Math.round(seperateChange * 100.0) /100.0;
		nickels =  (int) Math.floor(seperateChange/NICKELS);
		seperateChange = tenderDue - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * ONES - quarters * QUARTERS - dimes * DIMES - nickels * NICKELS;
			
		seperateChange = Math.round(seperateChange * 100.0) /100.0;
		pennies =  (int) Math.floor(seperateChange/PENNIES);
			
						//printouts for seperatingChange
			if (twenties > 0) {
				System.out.println("$20.00: [" + twenties + "]");
			}
			if (tens > 0) {
				System.out.println("$10.00: [" + tens + "]");
			}
			if (fives > 0) {
				System.out.println("$5.00: [" + fives + "]");
			}	
			if (ones > 0) {
				System.out.println("$1.00: [" + ones + "]");
			}	
			if (quarters > 0) {
			System.out.println("$0.25: [" + quarters + "]");
			}	
			if (dimes > 0) {
			System.out.println("$0.10: [" + dimes + "]");
			}
			if (nickels > 0) {
			System.out.println("$0.05: [" + nickels + "]");
			}
			if (pennies > 0) {
			System.out.println("$0.01: [" + pennies + "]");
			}
	}	
	
		public static int saleLimiterResponse(Scanner cashRegister) {			
	            
	    	System.out.println("[1] = ABORT TRANSACTION ");
	    	System.out.println("[2] = MANAGEMENT OVERRIDE");

	    				
	    		int response = cashRegister.nextInt();
	    			
	    		switch (response) {			
	    				
	    		case 1:   // register user selects [1] = YES (incorrect total entry) and returns the user to total entry menu
	    			System.out.println("Please begin a new transaction");
	    			break;
	    		case 2:
	    			System.out.println("Please enter Management Override ID:");
	    			int managementUserId = cashRegister.nextInt();
	    			System.out.println("Please enter Management Override PIN:");
	    			int managementUserPin = cashRegister.nextInt();
	    			System.out.println("Invalid Management Credentials");
	    			System.out.println("Wait a minute..this isn't real!");
	    			System.out.println("aborting transaction");
	    			break;
	    		}
	    		int zero = 0;
	    		return zero;	
	/*	}
	    		
	    		public static int computerImage() {
System.out.println("                                                                       ");
System.out.println("                                                                       ");
System.out.println("       OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO0OOOOOOOOOOO");
System.out.println("       8                      Pr|me <|> Systems                .d888888");
System.out.println("       8    oooooooooooooooooooooooooooooooooooooooooooooooood888888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8              *______________________*            88888888");
System.out.println("       8    8              |**TOTAL          00.00|            88888888");
System.out.println("       8    8              |                      |            88888888");
System.out.println("       8    8              |----------------------|            88888888");
System.out.println("       8    8              |                      |            88888888");
System.out.println("       8    8              |                      |            88888888");
System.out.println("       8    8              *----------------------*            88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8                                                  88888888");
System.out.println("       8    8 REG                                           01 88888888");
System.out.println("       8   .odoooooooooooooooooooooooooooooooooooooooooooo[BJS]88888888");
System.out.println("       8 .od88888888888888888888888888888888888888888888888888888888888");
System.out.println("       8888888888888888888888888888888888888888888888888888888888888888");

	    		int twelve = 12;
	    		return twelve; */
		}
}




	




