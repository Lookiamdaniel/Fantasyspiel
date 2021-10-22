public class Weapon {

    private String name;
    private int material;
    private int range;
    private int special;

    public Weapon(String name, int material, int range, int special) {
        this.name = name;
        this.material = material;
        this.range = range;
        this.special = special;
    }
    public int getMaterial(){
        return material;
    }
    public int getRange(){
        return range;
    }
    public String getName(){
        return name;
    }
}