package ejercicio2_tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ejemploTransaccion {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root", "");

            // Iniciamos transaccion
            conexion.setAutoCommit(false);

            String sentenciaSql = "INSERT INTO productos (nombre, seccion, precio, stock) VALUES (?,?,?,?)";

            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);

            sentencia.setString(1, "TV interactiva NEWLINE");
            sentencia.setString(2, "Componentes");
            sentencia.setDouble(3, 1999.98);
            sentencia.setInt(4, 10);
            sentencia.executeUpdate();

            sentencia.setString(1, "Puntero lase Trust");
            sentencia.setString(2, "Componentes");
            sentencia.setDouble(3, 29.98);
            sentencia.setInt(4, 0);
            sentencia.executeUpdate();

            sentencia.setString(1, "Cable HDMI");
            sentencia.setString(2, "Cables y Redes");
            sentencia.setDouble(3, 29.98);
            sentencia.setInt(4, 50);
            sentencia.executeUpdate();

            // Si llegamos a este punto commiteamos
            conexion.commit();
            // Devuelvo el auto commit a su estado inicial
            conexion.setAutoCommit(true);

            conexion.close();
            sentencia.close();

        } catch (SQLException e) {
            //conexion.rollback();
            throw new RuntimeException(e);
        }
    }
}
