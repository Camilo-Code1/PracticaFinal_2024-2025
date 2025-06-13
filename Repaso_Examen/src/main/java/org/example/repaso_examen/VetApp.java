package org.example.repaso_examen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VetApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VetApp.class.getResource("VetAppView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 680);
        stage.setTitle("VetDaw");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Cargando datos...");

        try (Connection connection = SQLDatabaseManager.getConnection()) {
            if (connection != null) {
                System.out.println("\nConexión exitosa a la base de datos.");

                // MOSTRAR LISTA MASCOTAS
                SQLAccessVetDaw vetDB = new SQLAccessVetDaw();
                System.out.println("\nLista de mascotas");
                for (Mascota m : vetDB.getAllMascotas()) {
                    System.out.println(m);
                }

                // INTENTO DE BUSQUEDA


                Mascota m = vetDB.getEncontrarMascotasByPasaporte("P00000010");
                System.out.println("\nFILTRO DE BUSQUEDA POR PASAPORTE");
                System.out.println(m);


                System.out.println("FILTRO DE BUSQUEDA POR DNI");
                List<Mascota> mascotas = vetDB.getMascotaByPropietarioDNI("12345678A");
                System.out.println("\nBusqueda por propietario DNI");
                for (Mascota p : mascotas){
                    System.out.println(p);
                }




                launch();
            } else {
                System.out.println("\nError al conectar con la base de datos.");

            }
        } catch (SQLException e) {
            System.out.println("\nError al probar la conexión: " + e.getMessage());

        }



    }
}