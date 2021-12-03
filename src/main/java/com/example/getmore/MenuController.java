package com.example.getmore;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

 private RegistroController registroController;
 private Stage stage;


 @FXML private VBox menuUsuario;
 @FXML private ImageView buttonMenuUsuario;
 @FXML private Label labelResultados;
 @FXML private Label labelCerrarSesion;
 @FXML private Label labelSalir;
 @FXML private Label labelHolaNombre;
 @FXML private ImageView arrowBack;
 @FXML private ImageView imagenAbecedario;
 @FXML private VBox vBoxMenu;
 @FXML private VBox vBoxSubMenu11;
 @FXML private VBox vBoxSubMenu12;

 public void init(String nombre, String apellido,Stage stage, RegistroController registroController1){
  labelHolaNombre.setText("Hola " + nombre);
  this.registroController = registroController1;
  this.stage = stage;
 }

 @FXML
 public void onLableCerrarSesionClicked(MouseEvent event){

  registroController.show();
  stage.close();
 }

 @FXML
 public void onImagenAbecedarioClicked(MouseEvent event){
  vBoxMenu.setVisible(false);
  vBoxSubMenu11.setVisible(true);
  arrowBack.setVisible(true);
 }


 @FXML
 public void onButtonMenuUsuarioClicked(MouseEvent event){

  if (menuUsuario.isVisible()){
   menuUsuario.setVisible(false);
  }else{
   menuUsuario.setVisible(true);
  }

 }

 @FXML
 public void onArrowBackClicked(MouseEvent event){
  vBoxMenu.setVisible(true);
  vBoxSubMenu11.setVisible(false);
  vBoxSubMenu12.setVisible(false);
  arrowBack.setVisible(false);

 }


 @FXML
 public void onLabelSalirClicked(MouseEvent event){
  Platform.exit();
  System.exit(0);
 }

 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {
   arrowBack.setVisible(false);
  menuUsuario.setVisible(false);
  vBoxMenu.setVisible(true);

 }
}
