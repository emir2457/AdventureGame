
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
                selectItemID = armorMenu();
                buyArmor(selectItemID);
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

    public int armorMenu() {
        System.out.println("1 - Hafif Zırh\t <Para :15  - Defans : 1  >");
        System.out.println("2 - Orta Zırh\t  <Para :25  - Defans : 3>");
        System.out.println("3 - Ağır Zırh\t  <Para :40  - Defans :  >");
        System.out.println("4 - Çıkış Yap");

        int selectArmorID = scan.nextInt();
        return selectArmorID;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String armorName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                armorName = "Hafif Zırh";
                price = 15;
                break;
            case 2:
                avoid = 3;
                armorName = "Orta Zırh";
                price = 25;
                break;
            case 3:
                avoid = 5;
                armorName = "Ağır Zırh";
                price = 40;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor");
                break;
            default:
                System.out.println("Geçersiz İşlem");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmor(avoid);
                player.getInv().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);
                System.out.println(armorName + " başarıyla satın alındı !! \n Engellenen Vuruş : " + player.getInv().getArmor());    
            }
            else{
                System.out.println("Para yetersiz !! ");
            }


        }




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
                System.out.println("Geçersiz İşlem");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setDamage(damage);
                player.getInv().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println(weaponName + " satın aldınız , Önceki Hasar : " + player.getDamage() + " Yeni hasarınız : " + player.getTotalDamage());

            } else {
                System.out.println("Paranız yetersiz...");
            }
        }

    }
}
