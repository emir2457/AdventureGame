
public class Inventory {

    private boolean water, food, firewood;
    private String weaponName, armorName;
    private int damage, armor;

    Inventory() {
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.damage = 0;
        this.armor = 0;
        this.weaponName = null;
        this.armorName = null;
        
    }

    public Inventory(int armor, String armorName, int damage, boolean firewood, boolean food, boolean water, String weaponName) {
        this.armor = armor;
        this.armorName = armorName;
        this.damage = damage;
        this.firewood = firewood;
        this.food = food;
        this.water = water;
        this.weaponName = weaponName;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
        
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}

