import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    private final Image kriz=new Image("slike/krizisce.png");
    private final Image ravna=new Image("slike/ravna.png");
    private final Image prazna=new Image("slike/prazna.png");
    private final Image kot=new Image("slike/vogal.png");
    private final Image neves=new Image("slike/not.png");
    private final Image slepa=new Image("slike/rob.png");
    private final Image tripot=new Image("slike/T.png");
    
    private Map[] mape={
            new Map(3,3),
            new Map(4,4),
            new Map(5,5),
            new Map(6,6),
            new Map(7,7),
            new Map(8,8),
            new Map(9,9),
            new Map(10,10),
            new Map(11,11),
            new Map(12,12),
            new Map(13,13),
            new Map(14,14),
            new Map(15,15),
        };
    
     public Map mapa=null;//new Map(5,5);
     public static Player igralec=new Player();
     private static int sizec=0;
     private int st=0;
    
    
     private void gen(){
         
        
        mapa=mape[sizec];
        mapa.genMap();
     }
     
    @FXML
    private Button mapbutton;
    @FXML
    private Circle monster00;
    @FXML
    private Circle monster01;
    @FXML
    private Circle monster02;
    @FXML
    private Circle monster10;
    @FXML
    private Circle monster11;
    @FXML
    private Circle monster12;
    @FXML
    private Circle monster20;
    @FXML
    private Circle monster21;
    @FXML
    private Circle monster22;
    @FXML
    private Rectangle tre00;
    @FXML
    private Rectangle tre01;
    @FXML
    private Rectangle tre02;
    @FXML
    private Rectangle tre10;
    @FXML
    private Rectangle tre11;
    @FXML
    private Rectangle tre12;
    @FXML
    private Rectangle tre20;
    @FXML
    private Rectangle tre21;
    @FXML
    private Rectangle tre22;
    
    @FXML
    private ImageView slika00;
    @FXML
    private ImageView slika01;
    @FXML
    private ImageView slika02;
    @FXML
    private ImageView slika10;
    @FXML
    private ImageView slika11;
    @FXML
    private ImageView slika12;
    @FXML
    private ImageView slika20;
    @FXML
    private ImageView slika21;
    @FXML
    private ImageView slika22;
    @FXML
    private ImageView objpic;
    @FXML
    private Button usebutton;
    @FXML
    private Button downb;
    @FXML
    private Button rightb;
    @FXML
    private Button upb;
    @FXML
    private Button leftb;
    @FXML
    private Label label;
    @FXML
    private Button runbu;
    @FXML
    private Button potbu;
    @FXML
    private Button defbu;
    @FXML
    private Button heabu;
    @FXML
    private Button attbu;
    @FXML
    private Label fightInfo;
    @FXML
    private Label levelLabel;
    @FXML
    private Label StatusLabel;
    @FXML
    private Label MonsterLabel;
    
    @FXML
    public void pressMapButton(ActionEvent event) throws Exception {               
        openMap();
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        gen();
       fightInfo.setText("");
       StatusLabel.setText("Life Points: "+igralec.hp+"/400 \nEnergy: "+igralec.en+"/400");
       MonsterLabel.setText("");
       //mapa.genMap();
       System.out.println("neki dela");
       updateminimap();
       //Game.printar(mapa.mons);
    }    
    
    private void updateminimap(){
        clearminimap();
        int x=mapa.playerx;
        int y=mapa.playery;
        //x=3;y=2;
        update00(x,y);
        update01(x,y);
        update02(x,y);
        update10(x,y);
        update11(x,y);
        update12(x,y);
        update20(x,y);
        update21(x,y);
        update22(x,y);
        
        
    }
    private void update00(int x,int y){
        if((y-1>-1)&&(x-1>-1)){
            if(mapa.disc[y-1][x-1]==false)slika00.setImage(neves);
            else{
                tre00.setVisible(mapa.tre[y-1][x-1]);
                if(mapa.mons[y-1][x-1]>0)
                monster00.setVisible(true);
                switch(mapa.polja[y-1][x-1]){
                    case 0:slika00.setImage(prazna);break;
                    case 1:slika00.setImage(prazna);break;
                    case 2:slika00.setImage(kriz);break;
                    case 3:slika00.setImage(ravna); slika00.setRotate(90);break;
                    case 4:slika00.setImage(ravna);break;
                    case 5:slika00.setImage(kot);slika00.setRotate(90);break;
                    case 6:slika00.setImage(kot);break;
                    case 7:slika00.setImage(kot);slika00.setRotate(270);break;
                    case 8:slika00.setImage(kot);slika00.setRotate(180);break;
                    case 9:slika00.setImage(tripot);slika00.setRotate(180);break;
                    case 10:slika00.setImage(tripot);slika00.setRotate(90);break;
                    case 11:slika00.setImage(tripot);break;
                    case 12:slika00.setImage(tripot);slika00.setRotate(270);break;
                    case 13:slika00.setImage(slepa);slika00.setRotate(90);break;
                    case 14:slika00.setImage(slepa);break;
                    case 15:slika00.setImage(slepa);slika00.setRotate(270);break;
                    case 16:slika00.setImage(slepa);slika00.setRotate(180);break;
                }
            }
        }
    }
    private void update01(int x,int y){
        if(y-1>-1){
            if(mapa.disc[y-1][x]==false)slika01.setImage(neves);
            else{
                tre01.setVisible(mapa.tre[y-1][x]);
                if(mapa.mons[y-1][x]>0)
                monster01.setVisible(true);
                switch(mapa.polja[y-1][x]){
                    case 0:slika01.setImage(prazna);break;
                    case 1:slika01.setImage(prazna);break;
                    case 2:slika01.setImage(kriz);break;
                    case 3:slika01.setImage(ravna); slika01.setRotate(90);break;
                    case 4:slika01.setImage(ravna);break;
                    case 5:slika01.setImage(kot);slika01.setRotate(90);break;
                    case 6:slika01.setImage(kot);break;
                    case 7:slika01.setImage(kot);slika01.setRotate(270);break;
                    case 8:slika01.setImage(kot);slika01.setRotate(180);break;
                    case 9:slika01.setImage(tripot);slika01.setRotate(180);break;
                    case 10:slika01.setImage(tripot);slika01.setRotate(90);break;
                    case 11:slika01.setImage(tripot);break;
                    case 12:slika01.setImage(tripot);slika01.setRotate(270);break;
                    case 13:slika01.setImage(slepa);slika01.setRotate(90);break;
                    case 14:slika01.setImage(slepa);break;
                    case 15:slika01.setImage(slepa);slika01.setRotate(270);break;
                    case 16:slika01.setImage(slepa);slika01.setRotate(180);break;
                }
            }
        }
    }
    private void update02(int x,int y){
        if((x+1<mapa.polja[0].length)&&(y-1>-1)){
            if(mapa.disc[y-1][x+1]==false)slika02.setImage(neves);
            else{
                tre02.setVisible(mapa.tre[y-1][x+1]);
                if(mapa.mons[y-1][x+1]>0)
                monster02.setVisible(true);
                switch(mapa.polja[y-1][x+1]){
                    case 0:slika02.setImage(prazna);break;
                    case 1:slika02.setImage(prazna);break;
                    case 2:slika02.setImage(kriz);break;
                    case 3:slika02.setImage(ravna); slika02.setRotate(90);break;
                    case 4:slika02.setImage(ravna);break;
                    case 5:slika02.setImage(kot);slika02.setRotate(90);break;
                    case 6:slika02.setImage(kot);break;
                    case 7:slika02.setImage(kot);slika02.setRotate(270);break;
                    case 8:slika02.setImage(kot);slika02.setRotate(180);break;
                    case 9:slika02.setImage(tripot);slika02.setRotate(180);break;
                    case 10:slika02.setImage(tripot);slika02.setRotate(90);break;
                    case 11:slika02.setImage(tripot);break;
                    case 12:slika02.setImage(tripot);slika02.setRotate(270);break;
                    case 13:slika02.setImage(slepa);slika02.setRotate(90);break;
                    case 14:slika02.setImage(slepa);break;
                    case 15:slika02.setImage(slepa);slika02.setRotate(270);break;
                    case 16:slika02.setImage(slepa);slika02.setRotate(180);break;
                }
            }
        }
    }
    private void update10(int x,int y){
        if(x-1>-1){
            if(mapa.disc[y][x-1]==false)slika10.setImage(neves);
            else{
                tre10.setVisible(mapa.tre[y][x-1]);
                if(mapa.mons[y][x-1]>0)
                monster10.setVisible(true);
                switch(mapa.polja[y][x-1]){
                    case 0:slika10.setImage(prazna);break;
                    case 1:slika10.setImage(prazna);break;
                    case 2:slika10.setImage(kriz);break;
                    case 3:slika10.setImage(ravna); slika10.setRotate(90);break;
                    case 4:slika10.setImage(ravna);break;
                    case 5:slika10.setImage(kot);slika10.setRotate(90);break;
                    case 6:slika10.setImage(kot);break;
                    case 7:slika10.setImage(kot);slika10.setRotate(270);break;
                    case 8:slika10.setImage(kot);slika10.setRotate(180);break;
                    case 9:slika10.setImage(tripot);slika10.setRotate(180);break;
                    case 10:slika10.setImage(tripot);slika10.setRotate(90);break;
                    case 11:slika10.setImage(tripot);break;
                    case 12:slika10.setImage(tripot);slika10.setRotate(270);break;
                    case 13:slika10.setImage(slepa);slika10.setRotate(90);break;
                    case 14:slika10.setImage(slepa);break;
                    case 15:slika10.setImage(slepa);slika10.setRotate(270);break;
                    case 16:slika10.setImage(slepa);slika10.setRotate(180);break;
                }
            }
        }
    }
    private void update11(int x,int y){
        tre11.setVisible(mapa.tre[y][x]);
        if(mapa.mons[y][x]>0)
        monster11.setVisible(true);
        switch(mapa.polja[y][x]){
            case 0:slika11.setImage(prazna);break;
            case 1:slika11.setImage(prazna);break;
            case 2:slika11.setImage(kriz);break;
            case 3:slika11.setImage(ravna); slika11.setRotate(90);break;
            case 4:slika11.setImage(ravna);break;
            case 5:slika11.setImage(kot);slika11.setRotate(90);break;
            case 6:slika11.setImage(kot);break;
            case 7:slika11.setImage(kot);slika11.setRotate(270);break;
            case 8:slika11.setImage(kot);slika11.setRotate(180);break;
            case 9:slika11.setImage(tripot);slika11.setRotate(180);break;
            case 10:slika11.setImage(tripot);slika11.setRotate(90);break;
            case 11:slika11.setImage(tripot);break;
            case 12:slika11.setImage(tripot);slika11.setRotate(270);break;
            case 13:slika11.setImage(slepa);slika11.setRotate(90);break;
            case 14:slika11.setImage(slepa);break;
            case 15:slika11.setImage(slepa);slika11.setRotate(270);break;
            case 16:slika11.setImage(slepa);slika11.setRotate(180);break;
        }
        if(mapa.obj[y][x]==true) objpic.setVisible(true);
    }
    private void update12(int x,int y){
        if(x+1<mapa.polja[0].length){
            if(mapa.disc[y][x+1]==false)slika12.setImage(neves);
            else{
                tre12.setVisible(mapa.tre[y][x+1]);
                if(mapa.mons[y][x+1]>0)
                monster12.setVisible(true);
                switch(mapa.polja[y][x+1]){
                    case 0:slika12.setImage(prazna);break;
                    case 1:slika12.setImage(prazna);break;
                    case 2:slika12.setImage(kriz);break;
                    case 3:slika12.setImage(ravna); slika12.setRotate(90);break;
                    case 4:slika12.setImage(ravna);break;
                    case 5:slika12.setImage(kot);slika12.setRotate(90);break;
                    case 6:slika12.setImage(kot);break;
                    case 7:slika12.setImage(kot);slika12.setRotate(270);break;
                    case 8:slika12.setImage(kot);slika12.setRotate(180);break;
                    case 9:slika12.setImage(tripot);slika12.setRotate(180);break;
                    case 10:slika12.setImage(tripot);slika12.setRotate(90);break;
                    case 11:slika12.setImage(tripot);break;
                    case 12:slika12.setImage(tripot);slika12.setRotate(270);break;
                    case 13:slika12.setImage(slepa);slika12.setRotate(90);break;
                    case 14:slika12.setImage(slepa);break;
                    case 15:slika12.setImage(slepa);slika12.setRotate(270);break;
                    case 16:slika12.setImage(slepa);slika12.setRotate(180);break;
                }
            }
        }
    }
    private void update20(int x,int y){
        if((x-1>-1)&&(y+1<mapa.polja.length)){
            if(mapa.disc[y+1][x-1]==false)slika20.setImage(neves);
            else{
                tre20.setVisible(mapa.tre[y+1][x-1]);
                if(mapa.mons[y+1][x-1]>0)
                monster20.setVisible(true);
                switch(mapa.polja[y+1][x-1]){
                    case 0:slika20.setImage(prazna);break;
                    case 1:slika20.setImage(prazna);break;
                    case 2:slika20.setImage(kriz);break;
                    case 3:slika20.setImage(ravna); slika20.setRotate(90);break;
                    case 4:slika20.setImage(ravna);break;
                    case 5:slika20.setImage(kot);slika20.setRotate(90);break;
                    case 6:slika20.setImage(kot);break;
                    case 7:slika20.setImage(kot);slika20.setRotate(270);break;
                    case 8:slika20.setImage(kot);slika20.setRotate(180);break;
                    case 9:slika20.setImage(tripot);slika20.setRotate(180);break;
                    case 10:slika20.setImage(tripot);slika20.setRotate(90);break;
                    case 11:slika20.setImage(tripot);break;
                    case 12:slika20.setImage(tripot);slika20.setRotate(270);break;
                    case 13:slika20.setImage(slepa);slika20.setRotate(90);break;
                    case 14:slika20.setImage(slepa);break;
                    case 15:slika20.setImage(slepa);slika20.setRotate(270);break;
                    case 16:slika20.setImage(slepa);slika20.setRotate(180);break;
                }
            }
        }
    }
    private void update21(int x,int y){
        if(y+1<mapa.polja.length){
            if(mapa.disc[y+1][x]==false)slika21.setImage(neves);
            else{
                tre21.setVisible(mapa.tre[y+1][x]);
                if(mapa.mons[y+1][x]>0)
                monster21.setVisible(true);
                switch(mapa.polja[y+1][x]){
                    case 0:slika21.setImage(prazna);break;
                    case 1:slika21.setImage(prazna);break;
                    case 2:slika21.setImage(kriz);break;
                    case 3:slika21.setImage(ravna); slika21.setRotate(90);break;
                    case 4:slika21.setImage(ravna);break;
                    case 5:slika21.setImage(kot);slika21.setRotate(90);break;
                    case 6:slika21.setImage(kot);break;
                    case 7:slika21.setImage(kot);slika21.setRotate(270);break;
                    case 8:slika21.setImage(kot);slika21.setRotate(180);break;
                    case 9:slika21.setImage(tripot);slika21.setRotate(180);break;
                    case 10:slika21.setImage(tripot);slika21.setRotate(90);break;
                    case 11:slika21.setImage(tripot);break;
                    case 12:slika21.setImage(tripot);slika21.setRotate(270);break;
                    case 13:slika21.setImage(slepa);slika21.setRotate(90);break;
                    case 14:slika21.setImage(slepa);break;
                    case 15:slika21.setImage(slepa);slika21.setRotate(270);break;
                    case 16:slika21.setImage(slepa);slika21.setRotate(180);break;
                }
            }
        }
    }
    private void update22(int x,int y){
        if((y+1<mapa.polja[0].length)&&(x+1<mapa.polja.length)){
            if(mapa.disc[y+1][x+1]==false)slika22.setImage(neves);
            else{
                tre22.setVisible(mapa.tre[y+1][x+1]);
                if(mapa.mons[y+1][x+1]>0)
                monster22.setVisible(true);
                switch(mapa.polja[y+1][x+1]){
                    case 0:slika22.setImage(prazna);break;
                    case 1:slika22.setImage(prazna);break;
                    case 2:slika22.setImage(kriz);break;
                    case 3:slika22.setImage(ravna); slika22.setRotate(90);break;
                    case 4:slika22.setImage(ravna);break;
                    case 5:slika22.setImage(kot);slika22.setRotate(90);break;
                    case 6:slika22.setImage(kot);break;
                    case 7:slika22.setImage(kot);slika22.setRotate(270);break;
                    case 8:slika22.setImage(kot);slika22.setRotate(180);break;
                    case 9:slika22.setImage(tripot);slika22.setRotate(180);break;
                    case 10:slika22.setImage(tripot);slika22.setRotate(90);break;
                    case 11:slika22.setImage(tripot);break;
                    case 12:slika22.setImage(tripot);slika22.setRotate(270);break;
                    case 13:slika22.setImage(slepa);slika22.setRotate(90);break;
                    case 14:slika22.setImage(slepa);break;
                    case 15:slika22.setImage(slepa);slika22.setRotate(270);break;
                    case 16:slika22.setImage(slepa);slika22.setRotate(180);break;
                }
            }
        }
    }
    private void clearminimap(){
    objpic.setVisible(false);
    
    monster00.setVisible(false);
    monster01.setVisible(false);
    monster02.setVisible(false);
    monster10.setVisible(false);
    monster11.setVisible(false);
    monster12.setVisible(false);
    monster20.setVisible(false);
    monster21.setVisible(false);
    monster22.setVisible(false);
    
    tre00.setVisible(false);
    tre01.setVisible(false);
    tre02.setVisible(false);
    tre10.setVisible(false);
    tre11.setVisible(false);
    tre12.setVisible(false);
    tre20.setVisible(false);
    tre21.setVisible(false);
    tre22.setVisible(false);
    
    slika00.setImage(prazna);
    slika01.setImage(prazna);
    slika02.setImage(prazna);
    slika10.setImage(prazna);
    slika11.setImage(prazna);
    slika12.setImage(prazna);
    slika20.setImage(prazna);
    slika21.setImage(prazna);
    slika22.setImage(prazna);
    
    slika00.setRotate(0);
    slika01.setRotate(0);
    slika02.setRotate(0);
    slika10.setRotate(0);
    slika11.setRotate(0);
    slika12.setRotate(0);
    slika20.setRotate(0);
    slika21.setRotate(0);
    slika22.setRotate(0);
    }
    
    
    private void openMap() throws Exception {               
    try {
        int tempa=mapa.polja.length;
        int tempb=mapa.polja[0].length;
        int size;
        if(tempa>tempb)size=tempa;
        else size=tempb;
        Pane stolpec=new VBox();
        for(int i=0;i<mapa.polja.length;i++){
            Pane vrstica = new HBox();
            for(int j=0;j<mapa.polja[0].length;j++){
                
                ImageView slikca=new ImageView();
                if(mapa.disc[i][j]==false)  slikca.setImage(neves);//vrstica.getChildren().add(new ImageView(neves));//za skrit neraziskano mapo
                else                                                                                                                                              //
                    switch(mapa.polja[i][j]){
                        case 0:slikca.setImage(prazna);break;
                        case 1:slikca.setImage(prazna);break;
                        case 2:slikca.setImage(kriz);break;
                        case 3:slikca.setImage(ravna); slikca.setRotate(90);break;
                        case 4:slikca.setImage(ravna);break;
                        case 5:slikca.setImage(kot);slikca.setRotate(90);break;
                        case 6:slikca.setImage(kot);break;
                        case 7:slikca.setImage(kot);slikca.setRotate(270);break;
                        case 8:slikca.setImage(kot);slikca.setRotate(180);break;
                        case 9:slikca.setImage(tripot);slikca.setRotate(180);break;
                        case 10:slikca.setImage(tripot);slikca.setRotate(90);break;
                        case 11:slikca.setImage(tripot);break;
                        case 12:slikca.setImage(tripot);slikca.setRotate(270);break;
                        case 13:slikca.setImage(slepa);slikca.setRotate(90);break;
                        case 14:slikca.setImage(slepa);break;
                        case 15:slikca.setImage(slepa);slikca.setRotate(270);break;
                        case 16:slikca.setImage(slepa);slikca.setRotate(180);break;
                }
                slikca.setFitHeight((int)(960/size));
                slikca.setFitWidth((int)(960/size));
                vrstica.getChildren().add(slikca);
            }
            stolpec.getChildren().add(vrstica);   
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(stolpec));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}

    @FXML
    private void use(ActionEvent event) {
        tre();
        Game.tick(mapa);
        igralec.en+=10;
        if(mapa.obj[mapa.playery][mapa.playerx]==true)Game.objpickup(mapa);
        updategui();
        winCheck();
    }
    @FXML
    private void down(ActionEvent event) {
        napis(Game.movedown(mapa));
        updategui();
    }
    @FXML
    private void right(ActionEvent event) {
        napis(Game.moveright(mapa));
        updategui();
    }
    @FXML
    private void up(ActionEvent event) {
        napis(Game.moveup(mapa));
        updategui();
    }
    @FXML
    private void left(ActionEvent event) {
        napis(Game.moveleft(mapa));
        updategui();
    }
  
    public  void napis(String s){
        label.setText(s);
    }
    
    private void tre(){
        if(mapa.tre[mapa.playery][mapa.playerx]==true){
            napis(Game.trepickup(mapa));
            trewin();
            tre11.setVisible(false);
        }
    }
    private void trewin(){
        try {
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Upgrade.fxml"));
        
            Scene scene = new Scene(root);
        
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void killMonster(){
        if(Game.monhp<1){
            if(mapa.mons[mapa.playery][mapa.playerx]>0)mapa.mons[mapa.playery][mapa.playerx]--;
            igralec.en+=150;
            if (igralec.en>400)igralec.en=400;
            Game.monhp=0;
            igralec.guardc=0;
        }
       //updategui();
    }
    private void updategui(){
        //fightInfo.setText("monster:"+Game.monhp+"\nhp:"+igralec.hp+"\nenergy:"+igralec.en);
        if(Game.monhp>0)MonsterLabel.setText("Monster HP: "+Game.monhp+"/200");
        else MonsterLabel.setText("");
        StatusLabel.setText("Life Points: "+igralec.hp+"/400 \nEnergy: "+igralec.en+"/400");
        levelLabel.setText("");
        winCheck();
        updateminimap();
        if (igralec.en<0)End();
        if(st==0)fightInfo.setText("");
        st=0;
        
    }
    private void winCheck(){
        if(mapa.playerx==0 && mapa.playery==0){
            int objnum=0;
            for(int i=0;i<mapa.obj.length;i++)
                for(int j=0;j<mapa.obj[0].length;j++)
                    if(mapa.obj[i][j]==true)objnum++;
            if(objnum==0)win();
        }
    }
    private void win(){
        
    //to do nova mapa
    System.out.println("lmao");
    sizec+=1;
    if (sizec==13)End();
    levelLabel.setText("New Level-size:"+(sizec+3)+"x"+(sizec+3));
    gen();
   
    
    
    }
    private void End(){
    Stage stage = (Stage) slika11.getScene().getWindow();
    stage.close();
    }
    
    @FXML
    private void fightrun(ActionEvent event) {
        if(Game.fightChe(mapa)){
          if(Math.random()<=igralec.runcha){
            igralec.en-=200;
            Game.monhp=0;
            fightInfo.setText("");
          }
          else{
              st=1;
              fightInfo.setText("Failed");
          }
          killMonster();
          if(Game.fightEne())End();
          updategui();
        }
    }
    @FXML
    private void fightpot(ActionEvent event) {
        if(igralec.pot>0){
          igralec.hp+=200;
          igralec.en=400;
          igralec.pot-=1;
          updategui();
          fightInfo.setText("potion used");
          st=1;
        }         
    }
    @FXML
    private void fightdef(ActionEvent event) {
        if(Game.fightChe(mapa)){
          igralec.guardc=3;
          igralec.en-=20;
          if(Game.fightEne())End();
          updategui();
        }
        else napis("neveljavna poteza");
    }
    @FXML
    private void fighthea(ActionEvent event) {
        if(Game.fightChe(mapa)){
          if (Math.random()*100<=igralec.heavycha){
            Game.monhp-=igralec.heavyatk*igralec.atk;
            igralec.en-=40;
            fightInfo.setText("");
          }
          else{
              st=1;
              fightInfo.setText("Attack failed");
              igralec.en-=20;
          }
          killMonster();
          if(Game.fightEne())End();
          updategui();
        }
        else napis("neveljavna poteza");
    }
    @FXML
    private void fightatt(ActionEvent event) {
        if(Game.fightChe(mapa)){
          if (Math.random()<=0.95){
            Game.monhp-=igralec.atk;
            fightInfo.setText("");
          }
          else{ 
              st=1; 
              fightInfo.setText("Attack failed");
          }
          igralec.en-=20;       
          
          killMonster();
          if(Game.fightEne())End();     
          updategui();
        }
        else napis("neveljavna poteza");
    }
    
}
