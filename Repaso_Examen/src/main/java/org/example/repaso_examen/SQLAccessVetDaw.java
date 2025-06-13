package org.example.repaso_examen;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessVetDaw {




    // OBTENER TODOS LOS TIPOS DE ANIMALES EN LA BASE DE DATOS
    public List<Tipo> getAllTipos(){
        List<Tipo> tipos = new LinkedList<>();

        String sql = "SELECT * FROM idTipo, Tipo FROM tipo";

        try (Connection con = SQLDatabaseManager.getConnection();
             Statement state = con.createStatement();
             ResultSet dataSet = state.executeQuery(sql);) {
                while (dataSet.next()) {
                 Tipo t = new Tipo (dataSet.getNString(2), dataSet.getInt(1));
                 tipos.add(t);
                }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }

        return tipos;
    }


    // OBTENER TODOS LOS PROPIETARIOS DE LA BBDD

    public List<Propietario> getAllPropietarios(){
        List<Propietario> propietarios = new LinkedList<>();

        String getpropietarios = "SELECT * FROM propietario";

        try (Connection con = SQLDatabaseManager.getConnection();
             Statement state = con.createStatement();
             ResultSet dataSet = state.executeQuery(getpropietarios);) {
            while (dataSet.next()) {
                Propietario p = new Propietario (
                        dataSet.getNString(1),
                        dataSet.getNString(2),
                        dataSet.getNString(3),
                        dataSet.getNString(4),
                        dataSet.getNString(5),
                        dataSet.getNString(6));

                propietarios.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }

        return propietarios;
    }


    // OBTENER TODOS LOS TIPOS DE MASCOTAS EN LA BASE DE DATOS
    public List<Mascota> getAllMascotas(){
        List<Mascota> mascotas = new LinkedList<>();

        String getMascotas = "SELECT m.*, t.tipo, p.* FROM vetdaw.mascota m JOIN vetdaw.propietario p ON p.dni = m.Propietario_dni JOIN vetdaw.tipo t ON t.idTipo = m.Tipo_idTipo;";

        try (Connection con = SQLDatabaseManager.getConnection();
             Statement state = con.createStatement();
             ResultSet dataSet = state.executeQuery(getMascotas);) {
            while (dataSet.next()) {
                Mascota m = new Mascota (
                        dataSet.getNString(2), // Nombre
                        dataSet.getNString(1), // Pasaporte
                        LocalDate.from(dataSet.getDate(4).toLocalDate()), // Fecha nacimiento
                        dataSet.getDouble(3), // Peso
                        new Propietario (dataSet.getNString(8),
                                dataSet.getNString(9), dataSet.getNString(10),
                                dataSet.getNString(11), dataSet.getNString(12),
                                dataSet.getNString(13)),
                        new Tipo(dataSet.getNString(7), dataSet.getInt(6)));


                mascotas.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }

        return mascotas;
    }




    public Mascota getEncontrarMascotasByPasaporte(String pasaporte){
        List <Mascota> mascotas = new LinkedList<>();


        Mascota mascotat = null;

        String sqlEncontrarMascotas = "SELECT m.*, p.* , t.tipo FROM Mascota m " +
                "JOIN Propietario p ON p.dni = m.Propietario_dni " +
                "JOIN tipo t ON t.idTipo = m.Tipo_idTipo " +
                "WHERE pasaporte = ?";

        try (Connection con = SQLDatabaseManager.getConnection();
             PreparedStatement statement = con.prepareStatement(sqlEncontrarMascotas);) {

            statement.setString(1, pasaporte);
            ResultSet dataSet = statement.executeQuery();


            while (dataSet.next()) {
                Mascota m = new Mascota (
                        dataSet.getNString(2), // Nombre
                        dataSet.getNString(1), // Pasaporte
                        LocalDate.from(dataSet.getDate(4).toLocalDate()), // Fecha nacimiento
                        dataSet.getDouble(3), // Peso
                        new Propietario (dataSet.getNString(8),
                                dataSet.getNString(9), dataSet.getNString(10),
                                dataSet.getNString(11), dataSet.getNString(12),
                                dataSet.getNString(13)),
                        new Tipo(dataSet.getNString(7), dataSet.getInt(6))
                );
                mascotat = m;
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
        return mascotat;
    }


    public List <Mascota> getMascotaByPropietarioDNI(String dni){
        List <Mascota> mascotas = new LinkedList<>();


        Mascota mascotat = null;

        String sqlEncontrarMascotas = "SELECT m.*, p.* , t.tipo FROM Mascota m " +
                "JOIN Propietario p ON p.dni = m.Propietario_dni " +
                "JOIN tipo t ON t.idTipo = m.Tipo_idTipo " +
                "WHERE p.dni = ?";

        try (Connection con = SQLDatabaseManager.getConnection();
             PreparedStatement statement = con.prepareStatement(sqlEncontrarMascotas);) {

            statement.setString(1, dni);
            ResultSet dataSet = statement.executeQuery();


            while (dataSet.next()) {
                Mascota d = new Mascota (
                        dataSet.getNString(2), // Nombre
                        dataSet.getNString(1), // Pasaporte
                        LocalDate.from(dataSet.getDate(4).toLocalDate()), // Fecha nacimiento
                        dataSet.getDouble(3), // Peso
                        new Propietario (dataSet.getNString(8),
                                dataSet.getNString(9), dataSet.getNString(10),
                                dataSet.getNString(11), dataSet.getNString(12),
                                dataSet.getNString(13)),
                        new Tipo(dataSet.getNString(7), dataSet.getInt(6))
                );
                mascotas.add(d);
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }

        return mascotas;
    }




    public static int agregarPropietario(Propietario propietario){
        int response = -1;

        String sqlAgregarPropietario = "INSERT INTO propietario VALUES (?,?,?,?,?,?)";

    try (Connection connection = SQLDatabaseManager.getConnection();
    PreparedStatement statement = connection.prepareStatement(sqlAgregarPropietario);) {

        statement.setString(1, propietario.getDni());
        statement.setString(2, propietario.getNombre());
        statement.setString(3, propietario.getApellido());
        statement.setString(4, propietario.getTelefono());
        statement.setString(5, propietario.getDireccion());
        statement.setString(6, propietario.getEmail());

        response = statement.executeUpdate();

    } catch (Exception e) {
        System.out.println("Error: "+ e.getMessage());
    }
        return response;
    }





    public static int agregarMascota(Mascota mascotas){
        int response = -1;

        String sqlAgregarMascota = "INSERT INTO mascota VALUES (?,?,?,?,?,?)";

        try (Connection connection = SQLDatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlAgregarMascota);) {

            statement.setString(1, mascotas.getPasaporte());
            statement.setString(2, mascotas.getNombre());
            statement.setDouble(3, mascotas.getPeso());
            statement.setDate(4, Date.valueOf(mascotas.getFechaNacimiento()));
            statement.setString(5, mascotas.getPropietario().getNombre());
            statement.setInt(6, mascotas.getTipo().getId());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
        return response;
    }


    public static int agregarConsulta(Consulta consulta){
        int response = -1;

        String sqlAgregarConsulta = "INSERT INTO consulta(Fecha, Duracion, Observaciones, Mascota_Pasaporte, Mascota_Propietario) VALUES (?,?,?,?,?)";

        try (Connection connection = SQLDatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlAgregarConsulta);) {

            statement.setDate(1, (new Date(consulta.getFecha())));
            statement.setInt(2, consulta.getDuracion());
            statement.setString(3, consulta.getObservaciones());
            statement.setString(4, consulta.getMascota().getPasaporte());
            statement.setString(6, consulta.getMascota().getPropietario().getDni());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
        return response;
    }
}
