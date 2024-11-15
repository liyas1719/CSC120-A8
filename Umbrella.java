public class Umbrella implements Contract {

    public Number size;
    public int xlocationfeet;
    public int ylocationfeet;
    public boolean stillwet;
    public boolean open;

    public Umbrella(Number size, int xlocationfeet, int ylocationfeet, boolean stillwet, boolean open) {
        this.size = size;
        this.xlocationfeet = xlocationfeet;
        this.ylocationfeet = ylocationfeet;
        this.stillwet = stillwet;
        this.open = open;
        System.out.println("New umbrella created!");
    }

    // picking up umbrella
    // lifts up off ground
    public void grab(String item) {
        ylocationfeet = 1;
        System.out.println("Umbrella has been picked up");
    }

    // umbrella is dropped
    // returned to the ground
    public String drop(String item) {
        ylocationfeet= 0;
        System.out.println("Umbrella has been dropped");
        return "Umbrella has been dropped";
    }

    // identifies if umbrella is wet
    // leaves the umbrella dry
    public void examine(String item) {
        if (stillwet == true) {
            this.rest();
            stillwet = false;
            System.out.println("Umbrella is dry");
        } else {
            System.out.println("Umbrella is dry");
        }
    }

    // lifts umbrella upn and opens it
    // get umbrella wet
    public void use(String item) {
        this.fly(0, 5);
        this.grow();
        stillwet = true;
    }

    // moves umbrella forward or backward by 10 feet
    public boolean walk(String direction) {
        if (direction == "forward" || direction == "Forward" || direction == "w") {
            xlocationfeet = xlocationfeet + 10;
            return true;
        } else if (direction == "Back" || direction == "back" || direction == "s") {
            xlocationfeet = xlocationfeet - 10;
            return true;
        } else {
            System.out.println("Invalid direction.");
            return false;
        }
    }

    // puts umbrella above head, takes in person height and x location
    public boolean fly(int x, int y) {
        if (y < 0) {
            ylocationfeet = y; // where y is the height of person (so we know how high the umbrella is)
            xlocationfeet = x;
            return true;
        } else {
            return false;
        }
    }

    // closes umbrella
    public Number shrink() {
        size = 0;
        open = false;
        return size;
    }

    // opens umbrella
    public Number grow() {
        size = 10;
        open = true;
        return size;
    }

    // dries umbrella
    public void rest() {
        stillwet = false;
    }

    // closes or opens umbrella
    public void undo() {
        if (open == true) {
            open = false;
        } else {
            open  = true;
        }
    }

}
