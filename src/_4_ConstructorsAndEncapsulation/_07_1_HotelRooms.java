package _4_ConstructorsAndEncapsulation;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class _07_1_HotelRooms {
    static int getIndexOfRoom(ArrayList<_07_Room> hotelRooms) {
        Scanner scrNum = new Scanner(System.in);

        int num;

        do {
            num = scrNum.nextInt();

            if (num < 100) {
                System.out.println("\n" + "Invalid room number!");
            }
        } while (num < 100);

        for (_07_Room room : hotelRooms) {
            if (room.num == num) {
                return hotelRooms.indexOf(room);
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner scrStr = new Scanner(System.in);
        Scanner scrNum = new Scanner(System.in);

        // creating a new list where rooms' data will be stored
        ArrayList<_07_Room> hotel = new ArrayList<>();

        /* used for generating unique number for each room */
        AtomicInteger uniqueNum = new AtomicInteger(100);

        String option;

        do {
            System.out.println("\n" + " ----------------------------- ");
            System.out.println("| 1. SHOW ALL                 |");
            System.out.println("| 2. BOOKING                  |");
            System.out.println("| 3. LEAVING                  |");
            System.out.println("| 4. PRICE OF ROOM CALCULATOR |");
            System.out.println("| --------------------------- |");
            System.out.println("| 5) Add a new room           |");
            System.out.println("| 6) Change price per night   |");
            System.out.println("/ 7. EXIT                     /");
            System.out.println("------------------------------ ");

            System.out.println("\n" + "Choose an option (1-7): ");
            option = scrStr.nextLine();

            int roomIndex;

            switch (option) {
                case "1":
                    if (!hotel.isEmpty()) {
                        for (_07_Room room : hotel) {
                            room.printInfo();
                        }
                    } else {
                        System.out.println("\n" + "// Hotel's data is not updated //");
                    }
                    break;

                case "2":
                    if (!hotel.isEmpty()) {
                        System.out.println("\n" + "Choose a booking-open room by its number... ");
                        roomIndex = getIndexOfRoom(hotel);

                        if (roomIndex != -1) {
                            if (!hotel.get(roomIndex).getIsTaken()) {
                                System.out.println("\n" + "Booking room...");
                                hotel.get(roomIndex).book();

                                // info for taken room is printed (status is changed)
                                hotel.get(roomIndex).printInfo();
                            }
                            else {
                                System.out.println("\n" + "_07_Room #" + hotel.get(roomIndex).num + " is already booked!");
                            }
                        }
                        else {
                            System.out.println("* _07_Room does not exist!");
                        }
                    } else {
                        System.out.println("\n" + "// Hotel's data is not updated //");
                    }
                    break;

                case "3":
                    if (!hotel.isEmpty()) {
                        System.out.println("\n" + "Enter the number of room guests just left of... ");
                        roomIndex = getIndexOfRoom(hotel);

                        if (roomIndex != -1) {
                            if (hotel.get(roomIndex).getIsTaken()) {
                                System.out.println("\n" + "Leaving room...");
                                hotel.get(roomIndex).release();

                                // info for left room is printed (status is changed)
                                hotel.get(roomIndex).printInfo();
                            }
                            else {
                                System.out.println("_07_Room is not taken to be left!");
                            }
                        }
                        else {
                            System.out.println("* _07_Room does not exist!");
                        }
                    } else {
                        System.out.println("\n" + "// Hotel's data is not updated //");
                    }
                    break;

                case "4":
                    if (!hotel.isEmpty()) {
                        System.out.println("\n" + "Enter the number of room you would " +
                                "like to use for calculations... ");
                        roomIndex = getIndexOfRoom(hotel);

                        if  (roomIndex != -1) {
                            hotel.get(roomIndex).printInfo();

                            System.out.println("\n" + "How many days would you like to stay?");
                            int days;

                            do {
                                days = scrNum.nextInt();

                                if (days <= 1) {
                                    System.out.println("Invalid data!");
                                }
                            } while (days <= 1);

                            System.out.println("\n" + "| Price of ROOM #" + hotel.get(roomIndex).num +" for " +
                                    (days - 1) + " nights -> " + String.format("%.2f Euro |%n",
                                        (hotel.get(roomIndex).calculatePrice((days - 1)))));
                        } else {
                            System.out.println("* _07_Room does not exist!");
                        }
                    } else {
                        System.out.println("\n" + "// Hotel's data is not updated //");
                    }
                    break;

                case "5":
                    System.out.println("\n" + "-> Enter a password to access this option... ");
                    String password = scrStr.nextLine();

                    if (password.equals(_07_Room.getAdminAccessCode())) {
                        System.out.println("\n" + "| Service mode: ADDING ROOMS |");

                        int roomNum = uniqueNum.getAndIncrement();

                        System.out.println("What is the type of the room?");
                        System.out.println("single (s) - double (d) - apartment (a)");

                        String type;
                        boolean invalidType;

                        do {
                            type = scrStr.nextLine();

                            invalidType = !(type.charAt(0) == 's') && !(type.charAt(0) == 'S') &&
                                    !(type.charAt(0) == 'd') && !(type.charAt(0) == 'D') &&
                                    !(type.charAt(0) == 'a') && !(type.charAt(0) == 'A');

                            if (invalidType) {
                                System.out.println("Invalid type!");
                            }
                        } while (invalidType);

                        if (type.charAt(0) == 's' || type.charAt(0) == 'S') {
                            type = "single";
                        }
                        if (type.charAt(0) == 'd' || type.charAt(0) == 'D') {
                            type = "double";
                        }
                        if (type.charAt(0) == 'a' || type.charAt(0) == 'A') {
                            type = "apartment";
                        }

                        System.out.println("\n" + "Adding new room #" + roomNum + " to the hotel...");
                        hotel.add(new _07_Room(roomNum, type));
                    }
                    else {
                        System.out.println("Invalid password! Access denied!");
                    }
                    break;

                case "6":
                    if (!hotel.isEmpty()) {
                        System.out.println("\n" + "-> Choose a room by its number...");
                        roomIndex = getIndexOfRoom(hotel);

                        if (roomIndex != -1) {
                            System.out.println("\n" + "Enter password:");
                            String passkey = scrStr.nextLine();
                            hotel.get(roomIndex).setPricePerNight(passkey);

                            // printing data for room (with changed price)
                            hotel.get(roomIndex).printInfo();
                        }
                        else {
                            System.out.println("* _07_Room does not exist!");
                        }
                    } else {
                        System.out.println("\n" + "// Hotel's data is not updated //");
                    }
                    break;

                default:
                    if (!option.equals("7")) {
                        System.out.println("Invalid option!");
                    }
            }
        } while (!option.equals("7"));

        System.out.println("\n" + "Exiting the program... ");

        scrNum.close();
        scrStr.close();
    }
}