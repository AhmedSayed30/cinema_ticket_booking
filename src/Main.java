Scanner in = new Scanner(System.in);

void main() {

    char[][] seats = initCinema();

    String [] movieNames = insertMonies();

    fillSeats(seats);


    int option = -1;
    do {

        System.out.println("=============================Welcome to Cinema Booking System===========================\n"+
                "           ======================How can I help you?====================");

        showMenu();

        System.out.print("Please enter your option : ");

        option = in.nextInt();

        switch (option){
            case 1:
                displaySeats(seats);
                break;
            case 2:
                System.out.print("Please enter number of seat : ");
                int target = in.nextInt();
                bookSeat(target,seats);
                displaySeats(seats);
                break;
            case 3:
                System.out.print("Please enter number of seat : ");
                int seat = in.nextInt();
                CancelBooking(seat,seats);
                displaySeats(seats);
                break;
            case 4:
                ShowAllMovies(movieNames);
                break;
            case 5:
                showOfAvailableAndBookedSeats(seats);
                break;
            case 0:
                break;
            default:
                
        }
    } while (option != 0);
}

private String[] insertMonies() {
    System.out.print("Enter number of movies: ");
    int numberOfMovies = in.nextInt();
    in.nextLine();
    String[] movieNames = new String[numberOfMovies];

    for (int i = 0; i < numberOfMovies; i++){
        System.out.print("Enter movie " + (i + 1) + " name: ");
        movieNames[i] = in.nextLine();
    }
    return movieNames;
}

private char[][] initCinema() {
    System.out.println("=============================Welcome to Cinema Booking System===========================\n"+
            "         ======================Welcome to Cinema Booking System Admin level====================");
    int row = 0;
    int colum = 0;
    do {
        System.out.print("Enter number of rows: ");
        row = in.nextInt();
        System.out.print("Enter number of colums: ");
        colum = in.nextInt();
        if (row <= 0 || colum <= 0){
            System.out.println("Invalid dimensions. Please try again.");
        }
    }while (row <= 0 || colum <= 0);
    return new char[row][colum];
}

private void showOfAvailableAndBookedSeats(char[][] seats) {
    int booked = 0;
    int available = 0;
    int totalSeats = seats.length * seats[0].length;
    displaySeats(seats);
    for (int i = 0; i <seats.length; i++){
        for (int j = 0; j < seats[i].length; j++){
            if (seats[i][j] == 'o'){
                available++;
            }else {
                booked++;
            }
        }
    }
    double occupancy = (double) booked / totalSeats * 100;
    if (occupancy >= 80) {
        System.out.println("Almost Full");
    }
    System.out.println("Booked seats is : " + booked + ", Available seats is : " + available);
}

private void ShowAllMovies(String[] movieNames) {
    for (int i = 0; i < movieNames.length; i++){
        System.out.print(movieNames[i] + "   ");
    }
    System.out.println("\n");
}

private void CancelBooking(int seat, char[][] seats) {
    boolean end = true;
    do {
        // Note: This approach assumes a single-digit column number (1-9).
        // For more flexible seat numbering, row and column should be entered separately
        // or separated by a delimiter (e.g., 1-12).
            int row = seat / 10;
            int colum = seat % 10;
            if (row < 1 || row > seats.length || colum < 1 || colum > seats[0].length) {
                System.out.println("Invalid seats");
            } else {
                if (seats[row - 1][colum - 1] == 'o') {
                    System.out.println("Seat is avilable arredy");
                } else {
                    seats[row - 1][colum - 1] = 'o';
                    end = false;
                }
                if (end){
                    System.out.print("Please enter seat again: ");
                    seat = in.nextInt();
                }
            }

    } while (end);

}

private void bookSeat(int target, char[][] seats) {

    boolean end = true;
    do {
        // Note: This approach assumes a single-digit column number (1-9).
        // For more flexible seat numbering, row and column should be entered separately
        // or separated by a delimiter (e.g., 1-12).

        int row = target / 10;
            int colum = target % 10;

            if (row < 1 || row > seats.length || colum < 1 || colum > seats[0].length) {
                System.out.println("Invalid seats");
            } else {
                if (seats[row - 1][colum - 1] == 'x') {
                    System.out.println("Seat not avilable");
                } else {
                    seats[row - 1][colum - 1] = 'x';
                    end = false;
                }
            }
            if (end){
                System.out.print("Please enter seat again: ");
                target = in.nextInt();
            }

    } while (end);
}

private void displaySeats(char[][] seats) {
    for (int i = 0; i <= seats.length-1; i++){
        for (int j = 0; j <= seats[i].length-1; j++){
            System.out.print(seats[i][j] + "   ");
        }
        System.out.println(" ");
    }
}

private void fillSeats(char[][] seats) {
    for (int i = 0; i <= seats.length-1; i++){
        for (int j = 0; j <= seats[i].length-1; j++){
            seats[i][j] = 'o';
        }
    }
}

private void showMenu() {
    System.out.println("\n1. Display Seats\n" +
            "2. Book Seat\n" +
            "3. Cancel Booking\n" +
            "4. Show all movies.\n" +
            "5. Show number of available and booked seats\n" +
            "0. Exit\n");
}
