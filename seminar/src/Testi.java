import java.util.*;
public class Testi
{
    public static int[] a=new int[3];public static int[] b;
    
    public static void sampleMethod()
    {
        a[0]=1;a[1]=2;a[2]=3;
        b=Arrays.copyOf(a,2);
        System.out.println(Arrays.toString(a));
        //Map.delNum(a,2); 
        System.out.println(Arrays.toString(a));
    }
    public static Map mapa= new Map(3,3);
    //mapa.polja[0][0]=1;//{{1,1,1},{4,11,4},{16,0,1}};
    
}
