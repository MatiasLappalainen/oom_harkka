import java.util.ArrayList;
import java.util.Random;

class Color {

    // Define class parameters
    String name;
    String hex;

    public Color(String name, String hex) {
        this.hex = hex;
        this.name = name;
    }

    /**
     * Method compares two colors, and returns boolean,
     * if they are equal
     * @.pre != null
     * @.post RESULT === (comparable.length === 7 && comparable[0] === '#')
     */
    public boolean isEqual(String comparable) {
        return this.hex.equals(comparable);
    }

    // Return color name
    public String getName() {
        return this.name;
    }

    // Return color name
    public String getHex() {
        return this.hex;
    }

}
