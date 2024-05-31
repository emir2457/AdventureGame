import java.util.Random;

public class Obstacle {

    private String name;
    private int damage,award,hp,maxSlot ;

    public Obstacle(String name, int damage, int award, int hp , int maxSlot) {
        this.award = award;
        this.damage = damage;
        this.hp = hp;
        this.name = name;
        this.maxSlot = maxSlot;
    }
    public int count() {
        Random r = new Random();
        return r.nextInt(this.maxSlot) + 1 ;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxSlot() {
        return maxSlot;
    }

    public void setMaxSlot(int maxSlot) {
        this.maxSlot = maxSlot;
    }

    
    






}
