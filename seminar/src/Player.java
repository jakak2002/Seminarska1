public class Player {
    public int hp;
    public int en;
    public int atk;
    public int heavycha;
    public double heavyatk;
    public double def;
    public int guardc;
    public int pot;
    public double runcha;
    
    public Player(){
        hp=400;
        en=400;
        atk=40;
        heavycha=30;
        heavyatk=1.8;
        def=0.8;
        guardc=0;
        pot=0;
        runcha=0.1; 
    }
    public void staminaDecay(){
        this.en-=10;
    }
    
}
