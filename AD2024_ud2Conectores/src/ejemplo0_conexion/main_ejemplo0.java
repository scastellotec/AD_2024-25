package ejemplo0_conexion;

import java.sql.*;

public class main_ejemplo0 {
    public static void main(String[] args) {
        // Parametros para la conexion
        Connection conexion = null;
        String urlBbdd = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String password = "";

        try {
            // Me conecto al servidor
            conexion = DriverManager.getConnection(urlBbdd, usuario, password);

            // Preparo la query a ejecutar
            String sentenciaSql = "SELECT nombre, precio FROM productos";
            PreparedStatement sentencia = null;

            // Preparo el objeto que recogerá el resultado
            ResultSet resultado = null;

            try {
                // Preparo la query y la ejecuto
                sentencia = conexion.prepareStatement(sentenciaSql);
                resultado = sentencia.executeQuery();

                // Recorro todos los resultados
                while (resultado.next()) {
                    System.out.println("nombre: " + resultado.getString(1));
                    System.out.println("precio: " + resultado.getInt(2));
                }

                // Falta cerrar recursos

            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
