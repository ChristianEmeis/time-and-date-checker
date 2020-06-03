package name;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Time {

	public static void main(String[] args) {
		Scanner inputRAR = new Scanner (System.in);
		String input = inputRAR.next();
		inputRAR.close(); 
		int year, month, day, hour, minute = 0;
		boolean validDate = true;
		boolean validTime = true;
		if (input.contains(":")) {
			String[] splitted = input.split(":");
			if (splitted.length == 2) {
				try {
					hour = Integer.parseInt(splitted[0]);
					minute = Integer.parseInt(splitted[1]);
					String input2 = hour + ":" + minute;
					try {
						LocalTime.parse(input2);
						System.out.println("Valid time: " + input2);
					} catch (DateTimeParseException | NullPointerException e) {
						System.out.println("This time is invalid: " + input2);
					}
				} catch (NumberFormatException e) {
					System.out.println("This time is invalid!");
				}

			}
			else {
				System.out.println("Pay attention to the format: hour:minute");
				
			}
		}

		if (input.contains(".")) {
			String[] splitted = input.split("\\.");
			try {
				day = Integer.parseInt(splitted[0]);
				month = Integer.parseInt(splitted[1]) - 1;
				year = Integer.parseInt(splitted[2]);
				Calendar cal = Calendar.getInstance();
				cal.setLenient(false);
				cal.set(year, month, day, 0, 0);
				try {
					cal.getTime();
					System.out.println("Valid date string: " + cal.getTime());
				} catch (Exception e) {
					System.out.println("Invalid date string: " + splitted[0] + "." + splitted[1] + "." + splitted[2]);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid date string!");
			}
		}
	}

}
