
import java.util.Scanner;

public class Game {

    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("Macera Oyununa Hoşgeldiniz ! ");
        player = new Player("Emir");
        player.selectChar();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("====================================");
            System.out.println();
            System.out.println("1 - Güvenli ev --> Size ait güvenli bir mekan, düşman yok ! ");
            System.out.println("2 - Mağara --> Zombi Çıkma İhtimali Yüksek !! ");
            System.out.println("3 - Orman  --> Vampirlerle Karşılaşabilirsiniz !!  ");
            System.out.println("4 - Nehir  --> Ayı ile karşılaşabilirsiniz !! ");
            System.out.println("5 - Mağaza --> Silah ve Zırh alabilirsiniz.  ");
            System.out.println();
            System.out.println("====================================");
            System.out.print("Gitmek istediğiniz yeri seçiniz : ");

            int selectLocation = scan.nextInt();
            while (selectLocation < 1 || selectLocation > 5) {
                System.out.println("Lütfen geçerli bir yer seçiniz !! ");
                selectLocation = scan.nextInt();

            }
            switch (selectLocation) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isFood() && player.getInv().isFirewood() && player.getInv().isWater()) {
                    System.out.println("Tebrikler Bütün Malzemeleri Topladınız.");
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.println("");
                System.out.println("Oyun bitti.");
            }
        }

    }

}
