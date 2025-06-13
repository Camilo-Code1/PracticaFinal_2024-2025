package org.example.repaso_examen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VetAppController implements Initializable {

    private Mascota mascota;
    private Propietario propietario;
    private Consulta consulta;
    private ObservableList<Mascota> listaMascotas = FXCollections.observableArrayList();
    private SQLAccessVetDaw vetDB = new SQLAccessVetDaw();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        List<Mascota> mascotasSQL = vetDB.getAllMascotas();
//        mascotas.addAll(mascotasSQL);
    }

    public void onRegistrarButtonClick(ActionEvent actionEvent) {
    }

    public void onListaButtonClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(VetApp.class.getResource("TablaMascotas.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 680);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Pasando a Lista");
    }

    public void OnBtnSaveInFile(ActionEvent actionEvent) {
    }

    public void onSalirButtonClick(ActionEvent actionEvent) {
    }

    public void onRegistrarMasButtonClick(ActionEvent actionEvent) {
    }

    public void onRegistrarConButtonClick(ActionEvent actionEvent) {
    }

    public void onBuscarButtonClick(ActionEvent actionEvent) {
    }


    public void onVolverMenuClick(ActionEvent event) {
        System.out.println("Volver Menu");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(VetApp.class.getResource("VetAppView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 680);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}