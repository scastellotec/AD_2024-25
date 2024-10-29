package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root", "");

            String sentenciaSql = "INSERT INTO productos (nombre, seccion, precio, stock) VALUES (?,?,?,?)";

            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);

            sentencia.setString(1, "Prueba Maven");
            sentencia.setString(2, "GestorProyectos");
            sentencia.setDouble(3, 0.0);
            sentencia.setInt(4, 0);
            sentencia.executeUpdate();

            conexion.close();
            sentencia.close();

        } catch (SQLException e) {
            //conexion.rollback();
            throw new RuntimeException(e);
        }
    }
}