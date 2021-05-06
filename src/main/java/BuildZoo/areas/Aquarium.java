package BuildZoo.areas;

import BuildZoo.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Aquarium implements IArea {
    private int capacity;
    private List<Animal> animals;

    public Aquarium() {
        this.capacity = 0;
        this.animals = new ArrayList<>();
    }

    public Aquarium(int capacity, List<Animal> animals) {
        this.capacity = capacity;
        this.animals = animals;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public boolean isFull() {
        return animals.size() >= capacity;
    }

    /**
     * @return Returns the IDs of the areas adjacent to this one.
     */
    @Override
    public ArrayList<Integer> getAdjacentAreas() {
        return null;
    }

}
