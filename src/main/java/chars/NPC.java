package chars;

import java.util.List;
import java.util.Arrays;

public abstract class NPC implements NPCInterface {
    private int atac;
    private int defence;
    private int shots;
    private int[] damage;
    private int maxHealth;
    private int health;
    private int speed;
    private boolean delivery;
    private String name;
    protected List<NPC> team;

    public NPC(int atac, int defence, int shots, int[] damage, int health, int speed,
               boolean delivery, String name) {
        this.atac = atac;
        this.defence = defence;
        this.shots = shots;
        this.damage = damage;
        this.maxHealth = health;
        this.speed = speed;
        this.delivery = delivery;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int[] getDamage() {
        return damage;
    }

    public void setAtac(int atac) {
        this.atac = atac;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getInfo() {
        String sDelivery, sMagic;
        if (delivery) sDelivery = "может";
        else sDelivery = "не может";
        return getClass().getSimpleName() + " атака = " + atac + ", защита = " + defence + "\nвыстрелы = " + shots +
                ", damage = " + Arrays.toString(damage) + "\nhealth = " + maxHealth +
                ", speeds = " + speed + "\nдоставить " + sDelivery +
                "\nимя персонажа: " + name + "\n ----------------------------------";
    }


    @Override
    public void step(List<NPC> team) {

    }
}


