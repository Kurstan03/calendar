import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("Input: ");
            Scanner scanner = new Scanner(System.in);
            String date = scanner.nextLine();
            String[] yearAndMonth = date.split(" ");
            int year = Integer.parseInt(yearAndMonth[0]);
            int month = Integer.parseInt(yearAndMonth[1]);

            boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
            String monthName;
            int totalDaysOfMonth;
            switch (month) {
                case 1 -> {
                    monthName = "January";
                    totalDaysOfMonth = 31;
                }
                case 2 -> {
                    monthName = "February";
                    if (isLeapYear) {
                        totalDaysOfMonth = 29;
                    } else {
                        totalDaysOfMonth = 28;
                    }
                }
                case 3 -> {
                    monthName = "March";
                    totalDaysOfMonth = 31;
                }
                case 4 -> {
                    monthName = "April";
                    totalDaysOfMonth = 30;
                }
                case 5 -> {
                    monthName = "May";
                    totalDaysOfMonth = 31;
                }
                case 6 -> {
                    monthName = "June";
                    totalDaysOfMonth = 30;
                }
                case 7 -> {
                    monthName = "July";
                    totalDaysOfMonth = 31;
                }
                case 8 -> {
                    monthName = "August";
                    totalDaysOfMonth = 31;
                }
                case 9 -> {
                    monthName = "September";
                    totalDaysOfMonth = 30;
                }
                case 10 -> {
                    monthName = "October";
                    totalDaysOfMonth = 31;
                }
                case 11 -> {
                    monthName = "November";
                    totalDaysOfMonth = 30;
                }
                case 12 -> {
                    monthName = "December";
                    totalDaysOfMonth = 31;
                }
                default -> throw new Exception("Month must be in the range 1–12.");
            }

            int firstDayOfWeek = getFirstDayOfWeek(year, month);

            System.out.printf("%s %s\n M  T  W  T  F  S  S%n", monthName, year);
            for (int i = 0; i < firstDayOfWeek; i++) {
                System.out.print("   ");
            }
            for (int i = 1; i <= totalDaysOfMonth; i++) {
                System.out.printf("%2d ", i);
                if ((firstDayOfWeek + i) % 7 == 0) {
                    System.out.println();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input(write only numbers)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getFirstDayOfWeek(int year, int month) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int dow = (1 + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7; // formula of Zeller
        return (dow + 5) % 7; // 0 - Monday, 6 - Sunday
    }
}