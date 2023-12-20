public class Player {
    // Class attributes(variables/fields)
    private String name;
    private int numPlayers = 1;
    private int x;
    private int y;
    private int z;
    private int direction; // North = 1, South = 2, Up = 3, Down = 4, East = 5, West = 6
    private int hp;


    // Constructors - build objects
    public Player () {
        name = "P" + numPlayers;
        x = 0;
        y = 0;
        z = 0;
        direction = 1;
        hp = 20;
    }

    public Player(String name, int x, int y, int z){
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        direction = 1;
        hp = 20;
    }

    public Player(String name, int x, int y, int z, int hp, int direction){
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        this.hp = hp;
    }

    // Accessor methods

    public int getNumPlayers() {
        return numPlayers;
    }

    public String getName() {
        return name;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getZ(){
        return z;
    }

    public int getHp(){
        return hp;
    }

    public int getDirection(){
        return direction;
    }

    // Mutator methods(setters)

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void move(int direction, int units) {
        if (direction > 0 || direction <= 6) {
            this.direction = direction;
            if (direction == 1) {
                this.x += units;
            } else if (direction == 2) {
                this.x -= units;
            } else if (direction == 3) {
                this.y += units;
            } else if (direction == 4) {
                this.y -= units;
            } else if (direction == 5) {
                this.z += units;
            } else if (direction == 6) {
                this.z -= units;
            }
        } else {
            System.out.println("Error: direction value must be between 1 and 6");
        }
    }

    public void teleport(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void teleport(Player player) {
        x = player.x;
        y = player.y;
        z = player.z;
    }

    public void attack(Player player, int damage) {
        player.hp -= damage;

        if(player.hp < 0) {
            player.hp = 0;
        }

        hp += (damage*0.5);
    }

    public String toString(){
        String s = ("Name: " + name + "\nHealth: " + hp + "\nCoordinates: X " + x + " Y " + y + " Z " + z + "\nDirection: " + direction);
        return s;
    }

    // Other

    public double getDistance(int x, int y, int z) {
        double distance = Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2) + Math.pow((z - this.z), 2));
        return distance;
    }

    public double getDistance(Player player) {
        double distance = Math.sqrt(Math.pow((player.x - this.x), 2) + Math.pow((player.y - this.y), 2) + Math.pow((player.z - this.z), 2));
        return distance;
    }
}

