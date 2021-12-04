package com.example.getmore;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

 private RegistroController registroController;
 private Stage stage;









 private Stage stage1;

 public void show() {
  stage1.show();
 }

 public void init1(String nombre,String apellido) throws IOException {
  FXMLLoader fxmlLoader = new FXMLLoader(GetMoreApplication.class.getResource("clase-view.fxml"));
  Parent root = fxmlLoader.load();
  ClaseController controller = fxmlLoader.getController();
  Scene scene = new Scene(root);
  Stage stage = new Stage();
  stage.setScene(scene);
  controller.init2(nombre,apellido,stage,this);
  stage.show();
  this.stage1.close();
 }





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
 @FXML private VBox vBoxSubMenu13;
 @FXML private VBox vBoxSubMenu14;
 @FXML private Button buttonSiguiente;
 @FXML private Button buttonAtras;
 @FXML private ImageView imagenA;
 @FXML private Label labelNombre2;


 public void init(String nombre, String apellido,Stage stage, RegistroController registroController1){
  labelHolaNombre.setText("Hola " + nombre);
  labelNombre2.setText(nombre + " " + apellido);
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
  buttonSiguiente.setVisible(true);
  buttonAtras.setVisible(false);
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
  vBoxMenu.setVisible(true);
  vBoxSubMenu11.setVisible(false);
  vBoxSubMenu12.setVisible(false);
  arrowBack.setVisible(false);
  buttonSiguiente.setVisible(false);
  buttonAtras.setVisible(false);

 }


 @FXML
 public void onLabelSalirClicked(MouseEvent event){
  Platform.exit();
  System.exit(0);
 }

 @FXML
 public void onButtonSiguienteClicked(MouseEvent event){
   if(vBoxSubMenu11.isVisible()){
     vBoxSubMenu12.setVisible(true);
     vBoxSubMenu11.setVisible(false);
     buttonAtras.setVisible(true);
   }else if(vBoxSubMenu12.isVisible()) {
    vBoxSubMenu13.setVisible(true);
    vBoxSubMenu12.setVisible(false);
   }else{
    vBoxSubMenu14.setVisible(true);
    vBoxSubMenu13.setVisible(false);
    buttonSiguiente.setVisible(false);
   }
 }

 @FXML
 public void onButtonAtrasClicked(MouseEvent event){

  if(vBoxSubMenu14.isVisible()){
   vBoxSubMenu14.setVisible(false);
   vBoxSubMenu13.setVisible(true);
   buttonSiguiente.setVisible(true);
  }else if(vBoxSubMenu13.isVisible()){
   vBoxSubMenu13.setVisible(false);
   vBoxSubMenu12.setVisible(true);
  }else if(vBoxSubMenu12.isVisible()){
   vBoxSubMenu12.setVisible(false);
   vBoxSubMenu11.setVisible(true);
   buttonAtras.setVisible(false);
   buttonAtras.setVisible(false);
  }
 }

 @FXML
 public void onImagenAClicked(MouseEvent event) throws IOException {

  init1("brandon","gutierrez");

 }

 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {

  arrowBack.setVisible(false);
  menuUsuario.setVisible(false);
  vBoxMenu.setVisible(true);
  vBoxSubMenu11.setVisible(false);
  vBoxSubMenu12.setVisible(false);
  vBoxSubMenu13.setVisible(false);
  vBoxSubMenu14.setVisible(false);
  buttonSiguiente.setVisible(false);
  buttonAtras.setVisible(false);


 }
}
