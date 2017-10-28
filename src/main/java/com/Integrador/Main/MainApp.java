package com.Integrador.Main;

import com.Integrador.Persistence.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

 
    @Override
    public void start(Stage s) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        scene.setFill(Color.TRANSPARENT);
        s.initStyle(StageStyle.TRANSPARENT);
        s.setScene(scene);
        s.centerOnScreen();
        s.show();
        Conexion c= new Conexion(s);
        c.start();
    }

   static void main(String[] args) {   launch(args);  }
}