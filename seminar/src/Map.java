import java.util.*;
public class Map{
    public int[][] polja;
    public int playery;
    public int playerx;
    public boolean[][] disc;
    
    public boolean[][] tre;
    public int[][] mons;
    public boolean[][] obj;
    
    public int[][] monsprev;
    private boolean[][] povezane;
    
    
    public Map(int[][]a ){polja=a;}
    public Map(int b, int a){//konstruktor, poveš velikost mape x,y, use mape je treba nardit tukej samostojno preden jih generiraš, nevem zakaj sm to tko naredu
        polja= new int [a][b];
        disc= new boolean[a][b];
        tre= new boolean[a][b];
        mFill(tre,false);
        obj= new boolean[a][b];
        mFill(obj,false);
        mons= new int[a][b];
        mFill(mons,0);
        monsprev= new int[a][b];
        mFill(mons,0);
        System.out.println("aaa");
    }
    public Map(Map a){//kopira enga druzga nevem zakaj mam
        this.polja=Arrays.copyOf(a.polja,a.polja.length);
    
    }
    
    public static void mFill (int[][] a, int b){
        for(int[] c :a){
            Arrays.fill(c,b);
        }
    }
    public static void mFill (boolean[][] a, boolean b){
        for(boolean[] c :a){
            Arrays.fill(c,b);
        }
    }
    
    public static void mCopy (int[][] a, int[][]b){
        a= new int[b.length][b[0].length];
        for(int i=0;i<b.length;i++){
            for (int j=0;j<b[0].length;j++){
                a[i][j]=b[i][j];
            }
        }
    }
           
    
    
    
    
    public void genMap(){//generiraj use aspekte mape
        genMapPol();
        placePlayer(0,0);
        genTre();
        mFill(disc,false);
        disc[0][0]=true;
        genMons(2);//1,2,3,4 placeholder uzami iz player fila
        genObj();
    }
    
    
    
    
    
    
    
    private void genObj(){
        int a=(int)(Math.random()*polja.length);
        int b=(int)(Math.random()*polja[0].length);
        if(((a!=0)||(b!=0))&&(polja[a][b]>1)) obj[a][b]=true;
    }
    private void genMons(int dif){
        for(int num=(int)Math.round((Math.sqrt(polja.length*polja[0].length)-4)/2*dif);num>0;num--){
            boolean temp=false;
            int a=0;
            int b=0;
            while (temp==false){
                a=(int)(Math.random()*polja.length);
                b=(int)(Math.random()*polja[0].length);
            if(((a!=0)||(b!=0))&&(polja[a][b]>1)) temp=true;
            }
             mons[a][b]++;
        }
    }
    private void genTre(){
        int num=(int)(Math.sqrt(polja.length*polja[0].length));
        while(num>0){
            int a=(int)(Math.random()*polja.length);
            int b=(int)(Math.random()*polja[0].length);
            if((polja[a][b]>1)&&(tre[a][b]==false)){
                tre[a][b]=true;
                num--;
            }
        }
    }
    private void placePlayer(int a, int b){
        if ((a>=0)&&(a<polja.length-1)&&(b>=0)&&(b<polja[0].length-1))
            playery=a;
            playerx=b;
    }
    private void genMapPol(){//generiraj fizično mapo usako polje posebaj
        mFill(polja,0);
        for(int i=0;i<polja.length;i++){
            for(int j=0;j<polja[0].length;j++){
                genPol(i,j);            
            }
        }
        if(!chSize()){
            System.out.println("labirint ne zadošča pogojem");
            genMapPol();
        }
    }
    private void genPol(int a, int b){//generiraj ab polje
        int[] c=posPol(a,b);//ugotovi izmed katerih lahko izbiraš
        polja[a][b]=c[((int)(Math.random()*c.length))];
        if (((a==0)&&(b==0))&&(polja[a][b]==1))genPol(a,b);//prvi more bit poiln
        if (polja[a][b]==0)genPol(a,b);//more imet usebino 
    }
    private int[] posPol(int a, int b){//ugotovi mozne
        //iz seznama useh brisi nemogoce 
        //ugotovi kaksni so pogoji iz sosed
        //ce se ne ujemajo z eno od moznosti jo brisi
        int[] mozne ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[] povezave=new int[4];
        
        //gor
        if ((a-1)==-1)povezave[0]=0;
        else povezave[0]=Polja.polja[(polja[a-1][b])].dol;
        //dol
        if ((a+1)==polja.length)povezave[1]=0;
        else povezave[1]=Polja.polja[(polja[a+1][b])].gor;
        //levo
        if ((b-1)==-1)povezave[2]=0;
        else povezave[2]=Polja.polja[(polja[a][b-1])].desno;
        //desno
        if ((b+1)==polja[0].length)povezave[3]=0;
        else povezave[3]=Polja.polja[(polja[a][b+1])].levo;
        
        
            //gor
            if (povezave[0]==0){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].gor==2){
                        delNum(mozne,j);
                    }
                }
            }
            if (povezave[0]==2){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].gor==0){
                        delNum(mozne,j);
                    }
                }
            }
            //dol
            if (povezave[1]==0){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].dol==2){
                        delNum(mozne,j);
                    }
                }
            }
            if (povezave[1]==2){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].dol==0){
                        delNum(mozne,j);
                    }
                }
            }
            //levo
            if (povezave[2]==0){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].levo==2){
                        delNum(mozne,j);
                    }
                }
            }
            if (povezave[2]==2){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].levo==0){
                        delNum(mozne,j);
                    }
                }
            }
            //desno
            if (povezave[3]==0){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].desno==2){
                        delNum(mozne,j);
                    }
                }
            }
            if (povezave[3]==2){
                for (int j=0;j<=16;j++){
                    if (Polja.polja[j].desno==0){
                        delNum(mozne,j);
                    }
                }
            }
        
        return mozne;
    }
    
    
    public static void delNum(int[] a, int b){//brisi iz arraya
        
        for(int i=0;i<a.length;i++){
            if (a[i]==b){a[i]=0;}
        }
        
    }
    
    private boolean chSize(){//preveri ce je vsaj 80% polj povezanih do ishodisca in ostale spremeni na prazne
        double min= polja.length*polja[0].length*0.8;
        povezane=new boolean[polja.length][polja[0].length];
        mFill(povezane,false);
        povezane[0][0]=true;
        boolean spr;
        do{
            spr=false;
            for(int i=0;i<polja.length;i++){
                for(int j=0;j<polja[0].length;j++){
                    if(povezane[i][j]){
                        //levo
                        if(j>0){
                            if((Polja.polja[polja[i][j]].levo==2)&&(!povezane[i][j-1])){
                                povezane[i][j-1]=true;
                                spr=true;
                            }
                        }
                        //desno
                        if(j<polja[0].length-1){
                            if((Polja.polja[polja[i][j]].desno==2)&&(!povezane[i][j+1])){
                                povezane[i][j+1]=true;
                                spr=true;
                            }
                        }
                        //gor
                        if(i>0){
                            if((Polja.polja[polja[i][j]].gor==2)&&(!povezane[i-1][j])){
                                povezane[i-1][j]=true;
                                spr=true;
                            }
                        }
                        //dol
                        if(i<polja.length-1){
                            if((Polja.polja[polja[i][j]].dol==2)&&(!povezane[i+1][j])){
                                povezane[i+1][j]=true;
                                spr=true;
                            }
                        }
                    }
                }
            }
        }while(spr==true);
        int povez=0;
        for(int i=0;i<povezane.length;i++){
            for(int j=0;j<povezane[0].length;j++){
                if(povezane[i][j])povez++;
                else polja[i][j]=1;
            }}
        if(povez>min)return true;
        return false;
    }
}
