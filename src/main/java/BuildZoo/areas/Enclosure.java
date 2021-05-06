package BuildZoo.areas;

import BuildZoo.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements IArea{

    private int capacity;
    private List<Animal> animals;

    public Enclosure() {
        this.capacity = 0;
        this.animals = new ArrayList<>();
    }

    public Enclosure(int capacity, List<Animal> animals) {
        this.capacity = capacity;
        this.animals = animals;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return animals.size() >= capacity;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    /**
     * @return Returns the IDs of the areas adjacent to this one.
     */
    @Override
    public ArrayList<Integer> getAdjacentAreas() {
        return null;
    }
}
