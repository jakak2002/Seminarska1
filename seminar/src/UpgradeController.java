
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UpgradeController implements Initializable {

    @FXML
    private Label runlabel;
    @FXML
    private Label potionlabel;
    @FXML
    private Label deflabel;
    @FXML
    private Button runup;
    @FXML
    private Button potup;
    @FXML
    private Button defup;
    @FXML
    private Button heaup;
    @FXML
    private Button attup;
    @FXML
    private Label heavylabel;
    @FXML
    private Label attlabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Nastaviš labele da pišejo to kar hočš
        String atttext=FXMLDocumentController.igralec.atk+"/200  ->  "+((int)(FXMLDocumentController.igralec.atk*1.2)+"/200");
        attlabel.setText(atttext);
        String headmg=(FXMLDocumentController.igralec.heavyatk)+"/4.0  ->  "+
                ((FXMLDocumentController.igralec.heavyatk*1.2))+"/4.0  " ;
        String heacha=FXMLDocumentController.igralec.heavycha+"%/80%  ->  "+(FXMLDocumentController.igralec.heavycha+10)+"%/80%";
        heavylabel.setText(headmg+heacha);
        String pottext=FXMLDocumentController.igralec.pot+"/5";
        potionlabel.setText(pottext);
        String deftext=((int)(FXMLDocumentController.igralec.def*100))+"%dmg/40%dmg  ->  "+((int)(FXMLDocumentController.igralec.def*100-10))+"%dmg/40%dmg";
        deflabel.setText(deftext);
        String runtext=((int)(FXMLDocumentController.igralec.runcha*100))+"%/30%  ->  "+((int)(FXMLDocumentController.igralec.runcha*100+5))+"%/30%";
        runlabel.setText(runtext);
    }    

    @FXML
    private void run(ActionEvent event) {
         if(FXMLDocumentController.igralec.runcha<0.3){
            FXMLDocumentController.igralec.runcha=FXMLDocumentController.igralec.runcha+0.05;
            Stage stage = (Stage) runup.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void pot(ActionEvent event) {
         if(FXMLDocumentController.igralec.pot<5){
            FXMLDocumentController.igralec.pot++;
            Stage stage = (Stage) potup.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void def(ActionEvent event) {
        if(FXMLDocumentController.igralec.def>0.4){
            FXMLDocumentController.igralec.def=FXMLDocumentController.igralec.def-0.1;
            Stage stage = (Stage) attup.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void hea(ActionEvent event) {
         if((FXMLDocumentController.igralec.heavyatk<4.0)||(FXMLDocumentController.igralec.heavycha<80)){
            if(FXMLDocumentController.igralec.heavyatk<4.0)
                FXMLDocumentController.igralec.heavyatk=FXMLDocumentController.igralec.heavyatk*1.2;
            if(FXMLDocumentController.igralec.heavycha<80)
                FXMLDocumentController.igralec.heavycha=FXMLDocumentController.igralec.heavycha+10;
            Stage stage = (Stage) attup.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void att(ActionEvent event) {
        if(FXMLDocumentController.igralec.atk<200){
            FXMLDocumentController.igralec.atk=(int)(FXMLDocumentController.igralec.atk*1.2);
            Stage stage = (Stage) attup.getScene().getWindow();
            stage.close();
        }
    }
    
}
