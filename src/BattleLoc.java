public abstract class BattleLoc extends Location{
    Obstacle obstacle;

    BattleLoc(Player player, String name) {
    
        super(player);
        this.obstacle = obstacle;
        this.name = name;

    }
    public boolean getLocation(){
        return true;
    }
}
