package com.example.getmore;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClaseController implements Initializable {

 private RegistroController registroController;
 private Stage stage;


 MenuController menuController;

 public void init2(String nombre, String apellido,Stage stage, MenuController menuController1){
  labelHolaNombre.setText("Hola " + nombre);
  this.menuController = menuController1;
  this.stage = stage;
 }

 @FXML private VBox menuUsuario;
 @FXML private ImageView buttonMenuUsuario;
 @FXML private Label labelResultados;
 @FXML private Label labelCerrarSesion;
 @FXML private Label labelSalir;
 @FXML private Label labelHolaNombre;
 @FXML private ImageView arrowBack;

 @FXML private Button buttonSiguiente;
 @FXML private Button buttonAtras;


 @FXML
 public void onLableCerrarSesionClicked(MouseEvent event){

  registroController.show();
  stage.close();
 }



 @FXML
 public void onButtonMenuUsuarioClicked(MouseEvent event){

  if (menuUsuario.isVisible()){
   menuUsuario.setVisible(false);
   buttonSiguiente.setVisible(true);
  }else{
   menuUsuario.setVisible(true);
   buttonSiguiente.setVisible(false);
  }

 }

 @FXML
 public void onArrowBackClicked(MouseEvent event){


 }


 @FXML
 public void onLabelSalirClicked(MouseEvent event){
  Platform.exit();
  System.exit(0);
 }

 @FXML
 public void onButtonSiguienteClicked(MouseEvent event){


 }

 @FXML
 public void onButtonAtrasClicked(MouseEvent event){


 }



 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {

  menuUsuario.setVisible(false);
  buttonAtras.setVisible(false);


 }
}
