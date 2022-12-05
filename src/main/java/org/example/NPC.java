package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class NPC {
    private int atac;
    private int defence;
    private int shots;
    private int[] damage;
    private int health;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;

    public NPC(int atac, int defence, int shots, int[] damage, int health, int speed,
               boolean delivery, boolean magic, String name) {
        this.atac = atac;
        this.defence = defence;
        this.shots = shots;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
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

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
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

    @Override
    public String toString() {
        String sDelivery, sMagic;
        if (delivery) sDelivery = "может";
        else sDelivery = "не может";
        if (magic) sMagic = "может";
        else sMagic = "не может";
        return "Атака = " + atac + ", защита = " + defence + "\nвыстрелы = " + shots +
                ", damage = " + Arrays.toString(damage) + "\nhealth = " + health +
                ", speeds = " + speed + "\nдоставить " + sDelivery +
                ", колдовать " + sMagic + "\nимя персонажа: " + name + "\n ----------------------------------";
    }

}
