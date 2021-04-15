
import java.util.Arrays;


public class Game {
    
    
    public static String moveup(Map mapa){
        Polje pol=new Polje(Polja.polja[(mapa.polja[mapa.playery][mapa.playerx])]);
        if((pol.gor==2)&&(mapa.mons[mapa.playery][mapa.playerx]<1)){
            mapa.playery=mapa.playery-1;
            tick(mapa);
            return "";
        }
        return("neveljavna poteza");
    }
    public static String movedown(Map mapa){
        Polje pol=new Polje(Polja.polja[(mapa.polja[mapa.playery][mapa.playerx])]);
        if((pol.dol==2)&&(mapa.mons[mapa.playery][mapa.playerx]<1)){
            mapa.playery=mapa.playery+1;
            tick(mapa);
            return "";
        }
        return("neveljavna poteza");
    }
    public static String moveleft(Map mapa){
        Polje pol=new Polje(Polja.polja[(mapa.polja[mapa.playery][mapa.playerx])]);
        if((pol.levo==2)&&(mapa.mons[mapa.playery][mapa.playerx]<1)){
            mapa.playerx=mapa.playerx-1;
            tick(mapa);
            return "";
        }
        return("neveljavna poteza");
    }     
    public static String moveright(Map mapa){
        Polje pol=new Polje(Polja.polja[(mapa.polja[mapa.playery][mapa.playerx])]);
        if((pol.desno==2)&&(mapa.mons[mapa.playery][mapa.playerx]<1)){
            mapa.playerx=mapa.playerx+1;
            tick(mapa);
            return "";
        }
        return("neveljavna poteza");
    }     
    public static void tick(Map mapa){
        mapa.disc[mapa.playery][mapa.playerx]=true;
        moveMonsters(mapa);
        FXMLDocumentController.igralec.staminaDecay();
        if((mapa.mons[mapa.playery][mapa.playerx]>0))fight(mapa);
        
    }
    
    static int monhp=0;
    public static void fight(Map mapa){
        if (mapa.mons[mapa.playery][mapa.playerx]>0)
            monhp=200;

        
    
    }
    public static boolean fightChe(Map mapa){
         if (mapa.mons[mapa.playery][mapa.playerx]<1)return false;
         if (monhp<1)return false;
         if (FXMLDocumentController.igralec.hp<1)return false;
         return true;
    }
    public static boolean fightEne(){
        Player pl=FXMLDocumentController.igralec;
         if (pl.guardc>0){
             pl.hp-=40*pl.def;
             pl.guardc-=1;
         }
           pl.hp-=40;
        if(pl.hp<1)return true;
        return false;
    }
    
    public static void oznaciprazne(Map mapa){
        for(int i=0;i<mapa.polja.length;i++){
            for(int j=0;j<mapa.polja[0].length;j++){
                if(mapa.polja[i][j]==1) 
                    mapa.disc[i][j]=true;
            }
        }
    }
    public static String objpickup(Map mapa){
        if(mapa.obj[mapa.playery][mapa.playerx]==true){
            mapa.obj[mapa.playery][mapa.playerx]=false;
            return"pobral si enega izmed ciljnih objektov";
        }   
        return"";
    }
    public  static String trepickup(Map mapa){
        if(mapa.tre[mapa.playery][mapa.playerx]==true){
            mapa.tre[mapa.playery][mapa.playerx]=false;
            return"pobral si power up";
        }   
        return"";
    }
    private static void moveMonsters(Map mapa){
        for(int i=0;i<mapa.mons.length;i++)
            for(int j=0;j<mapa.mons[0].length;j++)
                mapa.monsprev[i][j]=mapa.mons[i][j];
        
        Map.mFill(mapa.mons,0);
        
        if(mapa.monsprev[mapa.playery][mapa.playerx]>0){
            mapa.mons[mapa.playery][mapa.playerx]=mapa.monsprev[mapa.playery][mapa.playerx];
            mapa.monsprev[mapa.playery][mapa.playerx]=0;
        }
        
        for(int i=0;i<mapa.monsprev.length;i++){
            for(int j=0;j<mapa.monsprev[0].length;j++){
                for(int k=mapa.monsprev[i][j];k>0;k--){
                    
                    int[] temp={1,2,3,4};
                    
                    Polje pp=(Polja.polja[mapa.polja[i][j]]);
                    if(pp.gor!=2)Map.delNum(temp,1);
                    if(pp.desno!=2)Map.delNum(temp,2);
                    if(pp.dol!=2)Map.delNum(temp,3);
                    if(pp.levo!=2)Map.delNum(temp,4);
                    
                    if(mapa.playery==i-1 && mapa.playerx==j)Map.delNum(temp,1);
                    if(mapa.playery==i && mapa.playerx==j+1)Map.delNum(temp,2);
                    if(mapa.playery==i+1 && mapa.playerx==j)Map.delNum(temp,3);
                    if(mapa.playery==i && mapa.playerx==j-1)Map.delNum(temp,4);
                    
                    int temp2=temp[((int)(Math.random()*4))];
                    switch(temp2){
                        case 0: mapa.mons[i][j]++;break;
                        case 1: mapa.mons[i-1][j]++;break;
                        case 2: mapa.mons[i][j+1]++;break;
                        case 3: mapa.mons[i+1][j]++;break;
                        case 4: mapa.mons[i][j-1]++;break;
                    }
                } 
            }
        }
    }

    
    
    public static void printar(int[][] a){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    
}
