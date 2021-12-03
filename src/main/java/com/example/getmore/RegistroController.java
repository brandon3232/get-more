package com.example.getmore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegistroController implements Initializable {

    private Stage stage;

    public void setStage(Stage primayStage){
        stage = primayStage;
    }

    @FXML private TextField textFieldNombre;
    @FXML private TextField textFieldApellido;
    @FXML private TextField textFieldEdad;
    @FXML private ComboBox<String> comboBoxSexo;
    @FXML private Button buttonCrear;
    @FXML private Button buttonInicioSesion;
    @FXML private AnchorPane inicioSesionPane;
    @FXML private AnchorPane registroPane;


    ObservableList<String> comboSexoContent =
            FXCollections.observableArrayList(
                    "Masculino",
                    "Femenino"
            );


    @FXML
    public void onInicioSesionClicked(MouseEvent event){
        inicioSesionPane.setVisible(true);
        registroPane.setVisible(false);
    }

    @FXML
    public void onRegistroClicked(MouseEvent event){
        registroPane.setVisible(true);
        inicioSesionPane.setVisible(false);
    }



    @FXML
    public void eventAction(ActionEvent event) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(GetMoreApplication.class.getResource("menu-view.fxml"));
        Parent root = fxmlLoader.load();
        MenuController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(textFieldNombre.getText(),textFieldApellido.getText(),stage,this);
        stage.show();
        this.stage.close();


        /*Object evt = event.getSource();

        if (evt.equals(buttonCrear)) {//TODO:falta validar el combobox
            if (!textFieldNombre.getText().isEmpty() && !textFieldApellido.getText().isEmpty() && !textFieldEdad.getText().isEmpty()) {
                //TODO: aqui se va a ir agregando los datos de los usuarios registrados a la base de datos
                //TODO:hacer que se cierre la ventana de login y se abra el menu con los datos del usuario
            }
        } else {

            if (evt.equals(buttonInicioSesion)) {//TODO:falta validar el combobox
                if (!textFieldNombre.getText().isEmpty() && !textFieldApellido.getText().isEmpty()) {
                    //TODO: aqui se van a validad los datos de los usuarios que inician sesion
                    //TODO:hacer que se cierre la ventana de login y se abra el menu con los datos del usuario
                }

            }
        }*/

    }




    //TODO: validar campos de texto (nombre y apellido no mas de 15 caracteres,edad tiene que ser 0<edad<100)



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxSexo.setItems(comboSexoContent);
    }


}