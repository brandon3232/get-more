package com.example.getmore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegistroController implements Initializable {

    private Stage stage;

    public void show() {
        stage.show();
    }

    public void init(String nombre,String apellido) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(GetMoreApplication.class.getResource("menu-view.fxml"));
        Parent root = fxmlLoader.load();
        MenuController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(nombre,apellido,stage,this);
        stage.show();
        this.stage.close();
    }

    public void setStage(Stage primayStage){
        stage = primayStage;
    }

    @FXML private TextField textFieldNombreReg;
    @FXML private TextField textFieldApellidoReg;
    @FXML private TextField textFieldEdadReg;
    @FXML private Label labelErrorReg;
    @FXML private Label labelErrorIS;
    @FXML private ComboBox<String> comboBoxSexo;
    @FXML private TextField textFieldNombreIS;
    @FXML private TextField textFieldApellidoIS;
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

        Object evt = event.getSource();

        if (evt.equals(buttonCrear)) {
            if (!comboBoxSexo.getSelectionModel().isEmpty() && !textFieldNombreReg.getText().isEmpty() && !textFieldApellidoReg.getText().isEmpty() && !textFieldEdadReg.getText().isEmpty()) {
                labelErrorReg.setVisible(false);

                String nombre = textFieldNombreIS.getText();
                String apellido = textFieldApellidoIS.getText();

                Usuario.guardarUsuario(nombre,apellido);



                init(textFieldNombreReg.getText(),textFieldApellidoReg.getText());
            }else{
                labelErrorReg.setText("Existen campos vacios");
            }
        } else {

            if (evt.equals(buttonInicioSesion)) {
                if (!textFieldNombreIS.getText().isEmpty() && !textFieldApellidoIS.getText().isEmpty()) {
                    labelErrorReg.setVisible(false);
                    String nombre = textFieldNombreIS.getText();
                    String apellido = textFieldApellidoIS.getText();

                    Usuario.buscarUsuario(nombre , apellido);


                    init(textFieldNombreIS.getText(),textFieldApellidoIS.getText());
                }else{
                    labelErrorIS.setText("Existen campos vacios");
                }
            }
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxSexo.setItems(comboSexoContent);
        inicioSesionPane.setVisible(true);
        registroPane.setVisible(false);
    }


}