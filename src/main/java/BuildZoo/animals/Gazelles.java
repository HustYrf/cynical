package BuildZoo.animals;

public class Gazelles extends Animal{

    private final String nickName = "Gazelles";
    /**
     * @return Returns this animal's given name.
     */
    @Override
    public String getNickname() {
        return nickName;
    }

    /**
     * Check whether two animals can live together.
     *
     * @param animal The animal for which to check compatibility with this animal.
     * @return Returns true for compatible animals and false otherwise.
     */
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return animal instanceof Zebra;
    }
}
