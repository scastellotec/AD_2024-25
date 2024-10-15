package ejercicio1_world;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class ejercicio1_3 {
    public static void main(String[] args) throws SQLException, IOException {

        // 1. Me conecto a la BBDD
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/world",
                                                    "root", "");

        // 2. Preparar la consulta que quiero realizar
        String sentenciaSql = "SELECT Code FROM country";

        // 3. Completar los parametro que falten en la consulta
        PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);

        // 4. Ejecutar la consulta y recoger resultado
        ResultSet resultado = sentencia.executeQuery();

        while (resultado.next()) {
            String codigoPais = resultado.getString(1);

            // Por cada pais tengo que hacer otra consulta
            // 2. Preparar la consulta que quiero realizar
            sentenciaSql = "SELECT name, population FROM city WHERE CountryCode = ? ORDER BY population DESC";

            // 3. Completar los parametro que falten en la consulta
            PreparedStatement sentenciaCiudad = conexion.prepareStatement(sentenciaSql);
            sentenciaCiudad.setString(1, codigoPais);

            // 4. Ejecutar la consulta y recoger resultado
            ResultSet resultadoCiudad = sentenciaCiudad.executeQuery();

            // 5. Iterar sobre los resultados obtenidos y hacer lo que me piden

            // 5.1 Crear el archivo TXT y abro el stream para escribir
            BufferedWriter bfWriter = new BufferedWriter(new FileWriter("paises/"+codigoPais+".txt"));

            while (resultadoCiudad.next()) {
                // deberia quedar algo asi: Zaragoza (905123)
                String ciudadPoblacion = resultadoCiudad.getString(1)+" ("+resultadoCiudad.getInt((2))+")";
                // 5.2 Escribo cada linea en el archivo de txt
                bfWriter.write(ciudadPoblacion);
                bfWriter.newLine();
            }

            //5.3 Volcar buffe en el txt y cerrar
            bfWriter.flush(); // Aunque con el close ya se hace directamente
            bfWriter.close();
            sentenciaCiudad.close();
            resultadoCiudad.close();
        }

        // 6. Cerrar y liberar recursos
        resultado.close();
        sentencia.close();
        conexion.close();

    }
}
