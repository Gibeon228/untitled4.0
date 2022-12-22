package chars;

import java.util.List;

public abstract class NPC implements NPCInterface {
    private int attack;
    private int protection;
    private int[] damage;
    private double maxHealth;
    private double health;
    private int speed;
    private States state;
    private static int idCounter;
    private final int playerID;
    protected List<NPC> myTeam;
    protected Vector2 position;
    Vector2 destination;

    public NPC(int attack, int protection, int[] damage, double health, int speed, States state) {
        this.attack = attack;
        this.protection = protection;
        this.damage = damage;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.state = state;
        playerID = idCounter++;
    }

    public Vector2 getDestination() {
        if (destination == null)
            destination = position;
        return destination;
    }

    public Vector2 getPosition() {
        return position;
    }

    public List<NPC> getMyTeam() {
        return myTeam;
    }

    public States getState() {
        return state;
    }

    public int[] getDamage() {
        return damage;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public int getSpeed() {
        return speed;
    }


    public void setState(States state) {
        this.state = state;
        System.out.println(state);
    }

    public void setDestination(Vector2 destination) {
        this.destination = destination;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setHealth(double health) {
        if (health > getMaxHealth()) this.health = maxHealth;
        else this.health = health;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    @Override
    public String getInfo() {
        String str = state + "";
        String str2 = (int) health + "";
        return getClass().getSimpleName() + str2 + "/" + (int) maxHealth + " " + str;
    }

    public void updatePosition() {
        if (destination == null)
            destination = position;
        position.x += (destination.x - position.x) / 20;
        position.y += (destination.y - position.y) / 20;
    }

    public int getPlayerID() {
        return playerID;
    }


    protected void getAttack(NPC h) {
        setState(States.ATTACK);
        h.setState(States.HURT);

        if (attack == h.protection) {
            if (speed < position.getDistance(h.getPosition())) h.health -= (damage[0] + damage[1]) / 4;
            else h.health -= (damage[0] + damage[1]) / 2;
        }
        if (attack > h.protection) {
            if (speed < position.getDistance(h.getPosition())) h.health -= damage[1] / 2;
            else h.health -= damage[1];
        }
        if (attack < h.protection) {
            if (speed < position.getDistance(h.getPosition())) h.health -= damage[0] / 2;
            else h.health -= damage[0];
        }
        if (h.health <= 0) {
            h.health = 0;
            h.setState(States.DEAD);
        }
    }

    @Override
    public void step(List<NPC> team) {

    }
}


