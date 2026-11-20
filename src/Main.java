Scanner in = new Scanner(System.in);

void main() {
    char[][] seats = new char[5][6];

    String [] movieNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"};

    fillSeats(seats);


    int option = -1;
    do {

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

private void showOfAvailableAndBookedSeats(char[][] seats) {
    int booked = 0;
    int available = 0;
    for (int i = 0; i <seats.length; i++){
        for (int j = 0; j < seats[i].length; j++){
            if (seats[i][j] == 'o'){
                available++;
            }else {
                booked++;
            }
        }
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
        if (seat < 10 || seat > 99) {
            System.out.println("Invalid seat number");
            seat = in.nextInt();
            int row = seat / 10;
            int colum = seat % 10;
            if (row >= seats.length || colum >= seats[0].length) {
                System.out.println("Invalid seats");
                System.out.print("Please enter seat again: ");
                seat = in.nextInt();
            } else {
                if (seats[row - 1][colum - 1] == 'o') {
                    System.out.println("Seat is avilable arredy");
                    System.out.print("Please enter seat again: ");
                    seat = in.nextInt();
                } else {
                    seats[row - 1][colum - 1] = 'o';
                    end = false;
                }
            }
        }
    } while (end);

}

private void bookSeat(int target, char[][] seats) {

    boolean end = true;
    do {
        if (target < 10 || target > 99) {
            System.out.println("Invalid seat number");
            target = in.nextInt();

            int row = target / 10;
            int colum = target % 10;
            if (row >= seats.length || colum >= seats[0].length) {
                System.out.println("Invalid seats");
                System.out.print("Please enter seat again: ");
                target = in.nextInt();
            } else {
                if (seats[row - 1][colum - 1] == 'x') {
                    System.out.println("Seat not avilable");
                    System.out.print("Please enter seat again: ");
                    target = in.nextInt();
                } else {
                    seats[row - 1][colum - 1] = 'x';
                    end = false;
                }
            }
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
