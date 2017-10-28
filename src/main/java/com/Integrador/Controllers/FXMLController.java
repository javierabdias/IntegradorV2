package com.Integrador.Controllers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

//Clase Controller del splash
public class FXMLController implements Initializable {
    //Alv
    @FXML
    public AnchorPane Pane;
   
    @FXML
    private ImageView Image;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       TranslateTransition t= new TranslateTransition();
       ScaleTransition st = new ScaleTransition(Duration.seconds(4),Image) ;
       
       t.setDuration(Duration.millis(300));
       t.setNode(Image);
       t.setToX(-30);
       t.setAutoReverse(true);
       t.setCycleCount(Transition.INDEFINITE);
       st.setToX(4);
       st.setToY(4);
       ParallelTransition pt = new ParallelTransition(st,t);
       pt.play();
    }

 
    
}