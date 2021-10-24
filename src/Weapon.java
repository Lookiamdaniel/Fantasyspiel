public class Weapon {

    private String name;
    private int material;
    private int range;
    private int special;
    private Weapon weapon;

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

    //mit den folgenden Methoden werden die klassischen Monster kreiert.
    public void createKönigsmörder(){
        Weapon weapon = new Weapon("Königsmörder", 5, 3, 1);
    }
    public void createFlinkehände(){
        Weapon weapon = new Weapon("Königsmörder", 5, 3, 1);
    }
    public void createKilometerkiller(){
        Weapon weapon = new Weapon("Kilometerkiller", 1, 9, 1);
    }
    public void createBerserker(){
        weapon = new Weapon("Berserker", 7, 2, 1);
    }
}
