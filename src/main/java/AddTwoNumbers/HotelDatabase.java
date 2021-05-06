package AddTwoNumbers;

import java.util.HashMap;

public class HotelDatabase {
    private HashMap<Integer, Integer> Rooms = new HashMap<>();
    private int totalGuests;

    public void addGuestsToRoom(int room_number, int number_of_guests_to_add) {
        Integer integer = Rooms.get(room_number);
        if (integer.equals(0)) {
            Rooms.put(room_number, number_of_guests_to_add);
            totalGuests += number_of_guests_to_add;
        } else {
            System.out.println("This Room is already booked");
        }
    }

    public void removeGuestsFromRoom(int room_number) {
        Integer integer = Rooms.get(room_number);
        if (!integer.equals(0)) {
            Rooms.put(room_number, 0);
            totalGuests -= integer;
        } else {
            System.out.println("There is no guest in this room.");
        }
    }

    public int getTotal(){
        return totalGuests;
    }
}
