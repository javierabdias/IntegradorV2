package com.Integrador.Main;
import com.Integrador.Persistence.EManagerFactory;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
/**
 *
 * @author eliaslc
 */
public abstract class Validaciones {
    
    //Validad el cerrar de ventanas
     public void valCerrar(Stage sta){
        sta.setOnCloseRequest((WindowEvent event) -> {
            EManagerFactory.getEntityManagerFactory().close();
        });
     }
     
      //Validar solo numeros
      public static void TextFieldNumeros(TextField tf){
       tf.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
           if (!newValue.matches("[\\d*]")) {
               tf.setText(newValue.replaceAll("[^\\d]", ""));
           }
       });
    }
       
      
      //Validar solo letras
      public static void TextFieldLetras(JFXTextField tf){
        tf.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if(!newValue.matches("[A-Za-z]")){
                tf.setText(newValue.replaceAll("[^A-Za-z]", ""));
            }
        });
      }
      
        //Limitar la cantidad de caracteres de un TextField
  public static void setTextFieldLimit(TextField tf, int Limit){
     tf.lengthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
         if (newValue.intValue() > oldValue.intValue()) {
             // Check if the new character is greater than LIMIT
             if (tf.getText().length() >= Limit) {
                 // if it's 11th character then just setText to previous one
                 tf.setText(tf.getText().substring(0,Limit));
             }
         }
     });   
  }
    
}