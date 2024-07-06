package Cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nRows, nSeats, curSeat, curRow;


        while(true) {
            System.out.println("Enter the number of rows:");
            nRows = scanner.nextInt();
            if (nRows <= 0) {
                System.out.println("\nWrong input!");
            }else {
                break;
            }
        }
        while(true) {
            System.out.println("Enter the number of seats in each row:");
            nSeats = scanner.nextInt();
            if (nSeats <= 0) {
                System.out.println("\nWrong input!");
            }else {
                break;
            }
        }


        int totalIncome = nRows * nSeats <= 60 ? 10 * nRows * nSeats :
                10 * nSeats * (nRows / 2) + (nRows * nSeats - nSeats * (nRows / 2)) * 8;
        int curIncome = 0;
        int ticketsPurchased = 0;


        String[][] nRoom = new String[nRows][nSeats];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nSeats; j++) {
                nRoom[i][j] = "S";
            }
        }


        while(true){
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int input = scanner.nextInt();
            if (input == 1) {
                printRoomState(nRoom);
            }else if (input == 2) {
                while(true) {
                    while(true) {
                        System.out.println("Enter a row number:");
                        curRow = scanner.nextInt();
                        if (curRow <= 0 || curRow > nRows) {
                            System.out.println("\nWrong input!");
                        }else {
                            break;
                        }
                    }
                    while(true) {
                        System.out.println("Enter a seat number in that row:");
                        curSeat = scanner.nextInt();
                        if (curSeat <= 0 || curSeat > nRows) {
                            System.out.println("\nWrong input!");
                        }else {
                            break;
                        }
                    }
                    if(nRoom[curRow - 1][curSeat - 1].equals("B")) {
                        System.out.println("\nThat ticket has already been purchased!");
                    }else{
                        break;
                    }
                }
                int tCost = nRows * nSeats <= 60 ? 10 : curRow <= nRows / 2 ? 10 : 8;
                curIncome += tCost;
                ticketsPurchased++;
                nRoom[curRow - 1][curSeat - 1] = "B";
                System.out.println("\nTicket price: $" + tCost);
            }else if (input == 3) {
                System.out.printf("%nNumber of purchased tickets :%d%nPercentage :%.2f%%%nCurrent income :$%d%nTotal income :$%d%n%n",
                        ticketsPurchased,100 * (float)ticketsPurchased/(nRows * nSeats),curIncome,totalIncome);
            }else if (input == 0) {
                break;
            }else{
                System.out.println("\nWrong input!");
            }
        }
    }


    public static void printRoomState(String[][] seats) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(" " + seats[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}