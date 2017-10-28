package com.Integrador.Persistence;

import com.Integrador.Main.LogIn;
import javafx.stage.Stage;
/**
 *
 * @author eliaslc allvvvvvvvv
 */

//Clase utilzada como hilo para realizar la conexion a la base de datos
public class Conexion extends Thread {
    private Stage s;
    //Variable a utilizar para terminar con la animacion del splash
    private boolean exito;

    public Conexion(Stage s){
        this.s=s;
    }
    
    @Override 
    public void run(){
     
         if(getExito()){ 
           new LogIn(s).run();
         }
    
    }
 
    //Metodo para obtener el exito en la conexion con la base de datos
    private boolean getExito(){
        try{
          EManagerFactory.getEntityManagerFactory();
        }catch(Exception e){
            System.out.println("ERROR CON HIBERNATE");
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    
    //Metodo publico para obtener el resultado en el a utilizar en el controlador del splash
    public boolean getExitoConexion(){
        return exito;
    }
}