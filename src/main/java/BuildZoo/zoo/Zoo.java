package BuildZoo.zoo;

import BuildZoo.Codes;
import BuildZoo.animals.*;
import BuildZoo.areas.*;
import BuildZoo.cashCount.ICashCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Zoo implements IZoo {

    private Map<Integer, IArea> areaMap = new HashMap<>();


    /**
     * Adds a new area to the zoo.
     *
     * @param area The area to be added.
     * @return An ID by which the added area can be uniquely identified
     */
    @Override
    public int addArea(IArea area) {
        int uniquelyID = 0;
        if (!(area instanceof Entrance)) {
            uniquelyID = generateUniqueId();
        }
        areaMap.put(uniquelyID, area);
        return uniquelyID;
    }

    /**
     * Removes the specified area from the zoo.
     *
     * @param areaId The ID of the area to be removed.
     */
    @Override
    public void removeArea(int areaId) {
        areaMap.remove(areaId);
    }

    /**
     * Returns the area associated with the given ID.
     *
     * @param areaId The ID of the area to be fetched.
     * @return The area corresponding to the given ID.
     */
    @Override
    public IArea getArea(int areaId) {
        return areaMap.get(areaId);
    }

    /**
     * Tries to add the given animal to the specified area
     *
     * @param areaId The ID of the area the animal is to be added to.
     * @param animal The animal to be added.
     * @return Returns a code indicating success or failure. See {@link}.
     */
    @Override
    public byte addAnimal(int areaId, Animal animal) {
        IArea area = getArea(areaId);
        if (area instanceof PicnicArea) {
            return Codes.NOT_A_HABITAT;
        }

        if (area instanceof Aquarium) {
            if (animal instanceof Seals || animal instanceof Sharks || animal instanceof Starfish) {
                if (((Aquarium) area).isFull()) {
                    return Codes.HABITAT_FULL;
                } else {
                    for (Animal animal1 : ((Aquarium) area).getAnimals()) {
                        if (!animal1.isCompatibleWith(animal)) {
                            return Codes.INCOMPATIBLE_INHABITANTS;
                        }
                    }
                }
            } else {
                return Codes.WRONG_HABITAT;
            }
        } else if (area instanceof Cage) {
            if (animal instanceof Buzzards || animal instanceof Parrots) {
                if (((Cage) area).isFull()) {
                    return Codes.HABITAT_FULL;
                } else {
                    for (Animal animal1 : ((Cage) area).getAnimals()) {
                        if (!animal1.isCompatibleWith(animal)) {
                            return Codes.INCOMPATIBLE_INHABITANTS;
                        }
                    }
                }
            } else {
                return Codes.WRONG_HABITAT;
            }
        } else if (area instanceof Enclosure) {
            if (animal instanceof Gazelles || animal instanceof Lion || animal instanceof Zebra) {
                if (((Enclosure) area).isFull()) {
                    return Codes.HABITAT_FULL;
                } else {
                    for (Animal animal1 : ((Enclosure) area).getAnimals()) {
                        if (!animal1.isCompatibleWith(animal)) {
                            return Codes.INCOMPATIBLE_INHABITANTS;
                        }
                    }
                }
            } else {
                return Codes.WRONG_HABITAT;
            }
        }
        return Codes.ANIMAL_ADDED;
    }

    /**
     * Allows visitors to move between areas in the given direction (from -> to).
     *
     * @param fromAreaId The ID of the area from which the destination is to be accessible.
     * @param toAreaId   The ID of the destination area.
     */
    @Override
    public void connectAreas(int fromAreaId, int toAreaId) {

    }

    /**
     * Checks if the given path obeys the one-way system.
     *
     * @param areaIds The path is provided as a list of area IDs. It starts with the area ID at index 0.
     * @return Returns true if visitors are allowed to visit the areas in the order given by the passed in list.
     */
    @Override
    public boolean isPathAllowed(ArrayList<Integer> areaIds) {
        return false;
    }

    /**
     * Visits the areas in the specified order and records the names of all animals seen.
     *
     * @param areaIdsVisited Areas IDs in the order they were visited.
     * @return Returns a list of the names of all animals seen during the visit in the order they were seen.
     */
    @Override
    public ArrayList<String> visit(ArrayList<Integer> areaIdsVisited) {
        return null;
    }

    /**
     * Finds all areas that cannot be reached from the entrance of the zoo.
     *
     * @return The IDs of all inaccessible areas (unordered).
     */
    @Override
    public ArrayList<Integer> findUnreachableAreas() {
        return null;
    }

    /**
     * Sets a new ticket price in pounds and pence.
     *
     * @param pounds The first part of the cost before the point e.g. 17 for a ticket that costs £17.50
     * @param pence  The second part of the cost after the point e.g. 50 for a ticket that costs £17.50
     */
    @Override
    public void setEntranceFee(int pounds, int pence) {

    }

    /**
     * Stocks the ticket machine with the provided pool of cash.
     *
     * @param coins The number of notes and coins of different denominations available.
     */
    @Override
    public void setCashSupply(ICashCount coins) {

    }

    /**
     * Used to inspect the ticket machine's currently available pool of cash.
     *
     * @return The amount of each note and coin currently in the machine.
     */
    @Override
    public ICashCount getCashSupply() {
        return null;
    }

    /**
     * Takes an amount of cash inserted into the ticket machine and returns the appropriate change
     * (if any) after deducting the amount of the entrance fee as set by @setEntranceFee.
     *
     * @param cashInserted The notes and coins inserted by the user buying a ticket.
     * @return The change returned to the user (see assignment instructions for precise specification).
     */
    @Override
    public ICashCount payEntranceFee(ICashCount cashInserted) {
        return null;
    }


    public int generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str = "" + idOne;
        int uid = str.hashCode();
        String filterStr = "" + uid;
        str = filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }

}
