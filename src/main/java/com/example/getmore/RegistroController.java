package com.example.getmore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.*;
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
    public void eventAction(ActionEvent event) throws IOException, ClassNotFoundException {

        Object evt = event.getSource();

        if (evt.equals(buttonCrear)) {
            if (!comboBoxSexo.getSelectionModel().isEmpty() && !textFieldNombreReg.getText().isEmpty() && !textFieldApellidoReg.getText().isEmpty() && !textFieldEdadReg.getText().isEmpty()) {


                String nombre = textFieldNombreReg.getText();
                String apellido = textFieldApellidoReg.getText();
                int edad = Integer.parseInt(textFieldEdadReg.getText());

                if(edad < 0 || edad > 100){
                    labelErrorReg.setText("edad tiene que ser mayor de 0 y menor de 100");
                    return;
                }

                labelErrorReg.setText("");
                Usuario.guardarUsuario(nombre,apellido,edad);
                init(nombre,apellido);
            }else{
                labelErrorReg.setText("Existen campos vacios");
            }
        } else {

            if (evt.equals(buttonInicioSesion)) {
                if (!textFieldNombreIS.getText().isEmpty() && !textFieldApellidoIS.getText().isEmpty()) {
                    labelErrorReg.setText("");
                    String nombre = textFieldNombreIS.getText();
                    String apellido = textFieldApellidoIS.getText();


                    try {
                        Usuario.buscarUsuario(nombre , apellido);
                        init(nombre,apellido);
                    } catch (ClassNotFoundException e) {
                        System.out.println("Error --> FileNotFountException" + e.getMessage());
                        labelErrorIS.setText("Usuario no encontrado ");
                    } catch (IOException e) {
                        System.out.println("Error --> IOException " + e.getMessage());
                        labelErrorIS.setText("Usuario no encontrado");
                    }

                }else{
                    labelErrorIS.setText("Existen campos vacios");
                }
            }
        }
    }

    EventHandler<KeyEvent> handlerLetters = new EventHandler<KeyEvent>() {
        private  boolean willConsume = false;
        private int maxLength = 15;
        @Override
        public void handle(KeyEvent event) {
            TextField temp = (TextField) event.getSource();
            if (willConsume){
                event.consume();
            }
            if(!event.getCode().toString().matches("[a-zA-Z]") && event.getCode() !=KeyCode.SHIFT){
                if(event.getEventType() == KeyEvent.KEY_PRESSED){
                    willConsume = true;
                }else if(event.getEventType() == KeyEvent.KEY_RELEASED){
                    willConsume = false;
                }
            }
            if(temp.getText().length() > (maxLength - 1)){
                if(event.getEventType() == KeyEvent.KEY_PRESSED){
                    willConsume = true;
                }else if(event.getEventType() == KeyEvent.KEY_RELEASED){
                    willConsume = false;
                }
            }
        }
    };

    EventHandler<KeyEvent> handlerNumbers = new EventHandler<KeyEvent>() {
        private  boolean willConsume = false;
        private int maxLength = 2;
        @Override
        public void handle(KeyEvent event) {
            TextField temp = (TextField) event.getSource();
            if (willConsume){
                event.consume();
            }
            if(!event.getText().matches("[0-9]")){
                if(event.getEventType() == KeyEvent.KEY_PRESSED){
                    willConsume = true;
                }else if(event.getEventType() == KeyEvent.KEY_RELEASED){
                    willConsume = false;
                }
            }
            if(temp.getText().length() > (maxLength - 1)){
                if(event.getEventType() == KeyEvent.KEY_PRESSED){
                    willConsume = true;
                }else if(event.getEventType() == KeyEvent.KEY_RELEASED){
                    willConsume = false;
                }
            }
        }
    };



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxSexo.setItems(comboSexoContent);
        inicioSesionPane.setVisible(true);
        registroPane.setVisible(false);
        textFieldNombreReg.addEventFilter(KeyEvent.ANY, handlerLetters);
        textFieldApellidoReg.addEventFilter(KeyEvent.ANY, handlerLetters);
        textFieldEdadReg.addEventFilter(KeyEvent.ANY, handlerNumbers);
        textFieldNombreIS.addEventFilter(KeyEvent.ANY, handlerLetters);
        textFieldApellidoIS.addEventFilter(KeyEvent.ANY, handlerLetters);

    }
}