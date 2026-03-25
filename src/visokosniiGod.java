public class visokosniiGod {
        public static int leapYearCount(int year) {
            
            int count = 0;
            for (int y = 1; y <= year; y++) {
                if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            int year = 2024; // Example year
            int numberOfLeapYears = leapYearCount(year);
            System.out.println("Number of leap years up to " + year + ": " + numberOfLeapYears);

            year = 1900;
            numberOfLeapYears = leapYearCount(year);
            System.out.println("Number of leap years up to " + year + ": " + numberOfLeapYears);

            year = 2000;
            numberOfLeapYears = leapYearCount(year);
            System.out.println("Number of leap years up to " + year + ": " + numberOfLeapYears);
        }
    }


