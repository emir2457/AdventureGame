
import java.util.Scanner;

public class Player {

    private int damage, healthy, money, rHealthy;
    private String name, chaName;
    Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectChar() {
        switch (chaMenu()) {
            case 1:
            initPlayer("Samuray", 5, 21, 15);
                break;
            case 2:
            initPlayer("Okçu", 8, 16, 20);
                break;
            case 3:
            initPlayer("Şovalye", 10, 23, 5);
                break;
            default:
            initPlayer("Samuray", 5, 21, 15);
            break;

        }
        System.out.println("====================================");
        System.out.println(getName() + " Karakterini Seçtiniz !! ");
        System.out.println("");
        System.out.println("Karakter : " + getName() + "\t Hasar: " + getDamage() + "\t Sağlık : " + getHealthy() + "\t Para: " + getMoney());
        
    }
        public int chaMenu() {
        System.out.println("Karakter Seçininiz");
        System.out.println("1- Samuray \t"
                + //
                " Hasar : 6 \t Sağlık : 20 \t"
                + //
                " Para : 15");
        System.out.println("2- Okçu \t Hasar : 8 \t"
                + //
                " Sağlık : 16 \t"
                + //
                " Para : 20");
        System.out.println("3- Şövalye \t Hasar : 10 \t"
                + //
                " Sağlık : 23 \t"
                + //
                " Para : 5");

        System.out.print("Seçiminiz : ");
        int chaID = scan.nextInt();
        if (chaID < 1 || chaID > 3) {
            System.out.print("Lütfen geçerli bir karakter seçiniz. ");
            chaID = scan.nextInt();
        }

        return chaID;
    }

    public void initPlayer(String name, int damage, int healthy, int money){
        setName(name);
        setDamage(damage);
        setHealthy(healthy);
        setMoney(money);
        setrHealthy(healthy);
    }

    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChaName() {
        return chaName;
    }

    public void setChaName(String chaName) {
        this.chaName = chaName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }

}
