public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    public boolean getLocation() {
        player.setHealthy(player.getrHealthy());
        System.out.println("Sağlık %100 Yenilendi !!");
        System.out.println("Şuan Güvenli Evdesiniz...");
        return true;

    }
}
