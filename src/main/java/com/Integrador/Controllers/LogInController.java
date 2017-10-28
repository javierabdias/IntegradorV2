package com.Integrador.Controllers;
import com.Integrador.Main.Validaciones;
import com.Integrador.Persistence.EManagerFactory;
import com.Integrador.Persistence.Usuarios;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.persistence.EntityManager;
/**
 * FXML Controller class
 *
 * @author eliaslc
 */
public class LogInController extends Validaciones implements Initializable {
    
    @FXML
    private JFXTextField User;
    
    @FXML
    private JFXPasswordField Pass;

    @FXML
    private JFXButton In;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TextFieldNumeros(User);
        setTextFieldLimit(User,11);
         setTextFieldLimit(Pass,30);
        In.setOnAction((ActionEvent e)->{
            if(User.getText().trim().equals("")||Pass.getText().trim().equals("")){
                System.out.println("no funca");
            } else{
                verify(Integer.valueOf(User.getText()),Pass.getText());
            }
        });
    
    }    
    
    
    //Metodo para verificar el ingreso del usuario
    private void verify(int user, String pass){
        
        EntityManager manager = EManagerFactory.getEntityManagerFactory().createEntityManager();
        manager.getTransaction().begin();
        Usuarios u = manager.find(Usuarios.class, user);
        manager.getTransaction().commit();
        manager.close();
        
        if(u==null){
            System.out.println("Usuario Inexistente");
        } else if(u.getContrasena().equals(pass)){
            
            switch (u.getTipoUsuario()) {
                case "ADMINISTRADOR":
                        System.out.println("Se logueo un  Administrador");
                    break;
                case "RECEPCIONISTA":
                        System.out.println("Se logueo un Recepcionista");
                    break;
                case "CAJERO":
                        System.out.println("Se logueo un Cajero");
                    break;
                
            }   
        } else {
            System.out.println("Contraseña incorrecta");
            
        }
    }
}