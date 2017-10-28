package com.Integrador.Main;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author eliaslc
 */
public class LogIn extends Validaciones implements Runnable {
    
     private Stage s;
     
    public LogIn(Stage s){
        this.s=s;
    }
        @Override
        public void run(){
            
                Platform.runLater(() -> {
                    Stage sta1;
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/fxml/LogIn.fxml"));
                        Scene sc= new Scene(root);
                        sta1 = new Stage();
                        sta1.setScene(sc);
                        sta1.setResizable(false);
                        sta1.setTitle("Bienvenido");
                        sta1.show();
                        sta1.centerOnScreen();
                        valCerrar(sta1);
                        s.close();
                    }catch (IOException e) {
                        e.printStackTrace();                           
                    }
                }); 
            }
     }