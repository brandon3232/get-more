package com.example.getmore;


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
 @FXML private VBox masterPanel;
 @FXML private ImageView imagenAbecedario;


 public void init(String nombre, String apellido,Stage stage, RegistroController registroController1){
  labelHolaNombre.setText("Hola " + nombre);
  this.registroController = registroController1;
  this.stage = stage;

 }



 @FXML
 public void onImagenAbecedarioClicked(MouseEvent event){
  masterPanel.getChildren().removeAll();

 }


 @Override
 public void initialize(URL url, ResourceBundle resourceBundle) {
   arrowBack.setVisible(false);
  menuUsuario.setVisible(false);



 }
}
