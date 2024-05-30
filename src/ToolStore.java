
public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "Mağaza");

    }

    public boolean getLocation() {
        System.out.println("====================================");
        System.out.println("1 - Silahlar \n2 - Zırhlar \n3 - Çıkış");
        System.out.println("====================================");
        System.out.print("Seçiminiz : ");
        int select = scan.nextInt();
        System.out.println("Para : " + player.getMoney());
        int selectItemID;
        switch (select) {
            case 1:
                selectItemID = weaponMenu();
                buyWeapon(selectItemID);
                break;
            case 2:

                break;
            case 3:
                System.out.println("Çıkış yapılıyor.");
                break;
            default:
                break;
        }
        return true;

    }

    public int weaponMenu() {
        System.out.println("1 - Tabanca\t <Para : 5 - Hasar : 2>");
        System.out.println("2 - Kılıç\t <Para : 35 - Hasar : 3>");
        System.out.println("3 - Tüfek\t <Para : 45 - Hasar : 7>");
        System.out.println("4 - Çıkış...");
        System.out.println("Silah Seçiniz :");
        int selectWeaponID = scan.nextInt();
        return selectWeaponID;

    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String weaponName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                weaponName = "Tabanca";
                price = 5;
                break;

            case 2:
                damage = 3;
                weaponName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                weaponName = "Tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor.");
                break;
            default:
                break;
        }
        if (player.getMoney() > price) {
            player.getInv().setDamage(damage);
            player.getInv().setWeaponName(weaponName);
            player.setMoney(player.getMoney() - price);
            System.out.println(weaponName + " Silahını Satın Aldınız. Önceki Hasar :  " + player.getDamage() + " Yeni Hasar : " + (player.getDamage() + player.getInv().getDamage()));
            System.out.println("Kalan Para : " + player.getMoney());
        } else {
            System.out.println("Bakiye yetersiz !!");
        }

    }
}
