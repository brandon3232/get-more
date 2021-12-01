package com.example.getmore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.ResourceBundle;


public class RegistroController implements Initializable {

    @FXML private TextField textFieldNombre;
    @FXML private TextField textFieldApellido;
    @FXML private TextField textFieldEdad;
    @FXML private ComboBox<String> comboBoxSexo;
    @FXML private Label labelIniciarSesion;
    @FXML private Button buttonCrear;
    @FXML private Button buttonIniciarSesion;
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
    public void eventAction(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(buttonCrear)) {//TODO:falta validar el combobox
            if (!textFieldNombre.getText().isEmpty() && !textFieldApellido.getText().isEmpty() && !textFieldEdad.getText().isEmpty()) {
                //TODO: aqui se va a ir agregando los datos de los usuarios registrados a la base de datos

            }
        } else {

            if (evt.equals(buttonIniciarSesion)) {
                if (!textFieldNombre.getText().isEmpty() && !textFieldApellido.getText().isEmpty()) {
                    //TODO: aqui se van a validad los datos de los usuarios que inician sesion

                }

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxSexo.setItems(comboSexoContent);
    }


}