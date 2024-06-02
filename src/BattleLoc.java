
public abstract class BattleLoc extends Location {

    protected Obstacle obstacle;
    protected String award;

    BattleLoc(Player player, String name, Obstacle obstacle, String Award) {

        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation() {

        int obsCount = obstacle.count();
        System.out.println("Şuan buradasınız :  " + this.getName());
        System.out.println("Dikkatli Ol !! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor !! ");
        System.out.println("Savaş veya Kaç (Savaşmak için S tuşuna bas)");
        String selectChoice = scan.nextLine();
        selectChoice = selectChoice.toUpperCase();
        if (selectChoice.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " Bölgesindeki Tüm Düşmanları Yendin !! ");
                if (this.award.equals("Food") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " Kazandınız ! ");
                    player.getInv().setFood(true);

                } else if (this.award.equals("Water") && player.getInv().isWater() == false) {
                    System.out.println(this.award + " Kazandınız ! ");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
                    System.out.println(this.award + " Kazandınız ! ");
                    player.getInv().setFirewood(true);
                }
                return true;

            } 
            if(player.getHealthy() <= 0) {
                System.out.println("Öldünüz");
                return false;
            }
        }
        return true;

    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = obstacle.getHp();
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHp() > 0) {
                System.out.println("<V>ur veya <K>aç : ");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println("Vurdun ! ");
                    obstacle.setHp(obstacle.getHp() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHp() > 0) {
                        System.out.println("");
                        System.out.println("Canavar Size Vurdu !");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage()) - player.getInv().getArmor());
                        afterHit();
                    }
                } else {
                    return false;
                   
                }

                if (obstacle.getHp() < player.getHealthy()) {
                    System.out.println("Canavarları Yendin !! ");
                    player.setMoney(player.getMoney() + obstacle.getAward());
                    System.out.println("Güncel Paranız : " + player.getMoney());
                    obstacle.setHp(defObsHealth);
                   

                } else {
                    return false;

                }

            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Oyuncunun Bilgileri \n-----------");
        System.out.println("Can: " + player.getHealthy());
        System.out.println("Hasar: " + player.getTotalDamage());
        System.out.println("Para: " + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Silah: " + player.getInv().getWeaponName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Zırh: " + player.getInv().getArmorName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Değerleri\n-----------");
        System.out.println("Can: " + obstacle.getHp());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Ganimet: " + obstacle.getAward());

    }

    public void afterHit() {
        System.out.println("Oyuncu Canı : " + player.getHealthy());
        System.out.println(obstacle.getName() + " Canı : " + obstacle.getHp());
    }

}
