public class Polje{//objekt polje za array, ma zapisane morebitne povezave med sosedami
    int gor,dol,levo,desno;//0=ni povezave, 1=nevem še, 2=povezava za zihr
    public Polje(int a, int b, int c, int d){
        gor=a;dol=b;levo=c;desno=d;   
    }
    public Polje(Polje pp){
        gor=pp.gor;dol=pp.dol;levo=pp.levo;desno=pp.desno;   
    }
}
