public class Umbrella implements Contract {

    public Number size;
    public int xLocationFeet;
    public int yLocationFeet;
    public boolean stillWet;
    public boolean open;

    /**
     * constructor for  umbrella 
     * @param size size of the umbrella
     * @param xLocationFeet location of the umbrella in feet
     * @param yLocationFeet how high up umbrella is in feet (ground or in hand or in use)
     * @param stillWet indicates whether or not the umbrella is still wet
     * @param open indicates whether tor not the umbrella is open
     */
    public Umbrella(Number size, int xLocationFeet, int yLocationFeet, boolean stillWet, boolean open) {
        this.size = size;
        this.xLocationFeet = xLocationFeet;
        this.yLocationFeet = yLocationFeet;
        this.stillWet = stillWet;
        this.open = open;
        System.out.println("New umbrella created!");
    }

    /**
     * method that picks up umbrella by changing the ylocationfeet
     * @param item the umbrella being grbbed
     */
    public void grab(String item) {
        yLocationFeet = 1;
        System.out.println("Umbrella has been picked up");
    }

    /**
     * method that drops umbrella by changing the ylocationfeet
     * @param item the umbrella being dropped
     */
    public String drop(String item) {
        yLocationFeet= 0;
        System.out.println("Umbrella has been dropped");
        return "Umbrella has been dropped";
    }

    /**
     * method that determines if the umbrella is still wet and dries it
     * @param item the umbrella being examined
     */
    public void examine(String item) {
        if (stillWet == true) {
            this.rest();
            stillWet = false;
            System.out.println("Umbrella is dry");
        } else {
            System.out.println("Umbrella is dry");
        }
    }

    /**
     * method that uses umbrella by changing its ylocationfeet, making it grow, and getting it wet
     * @param item the umbrella being used
     */
    public void use(String item) {
        this.fly(0, 5);
        this.grow();
        stillWet = true;
    }

    /**
     * method that changes umbrella xLocationFeet to simulate walking movement
     * @param item the umbrella being dropped
     */
    public boolean walk(String direction) {
        if (direction == "forward" || direction == "Forward" || direction == "w") {
            xLocationFeet = xLocationFeet + 10;
            return true;
        } else if (direction == "Back" || direction == "back" || direction == "s") {
            xLocationFeet = xLocationFeet - 10;
            return true;
        } else {
            System.out.println("Invalid direction.");
            return false;
        }
    }

    /**
     * method that puts umbrella above someone's head by changing xLocationFeet and yLocationFeet
     * @param x location of person
     * @param y height of person
     */
    public boolean fly(int x, int y) {
        if (y < 0) {
            yLocationFeet = y;
            xLocationFeet = x;
            return true;
        } else {
            return false;
        }
    }

    /**
     * method that closes umbrella by changing size and whether or not it's open
     * @return the size of the umbrella
     */
    public Number shrink() {
        size = 0;
        open = false;
        return size;
    }

/**
     * method that grows umbrella when used by changing size and whether or not it's open
     * @return the size of umbrella
     */
    public Number grow() {
        size = 10;
        open = true;
        return size;
    }

    /**
     * method that dries umbrella
     */
    public void rest() {
        stillWet = false;
    }

     /**
     * method that opens or closes umbrella depending on current state (undoing the act of opening or closing it)
     */
    public void undo() {
        if (open == true) {
            open = false;
        } else {
            open  = true;
        }
    }

}
