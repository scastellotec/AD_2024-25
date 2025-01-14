import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo para MongoDB");

        // URI de conexión con el servidor MongoDB
        String uri = "mongodb://localhost:27017/";
        // Establezco la conexion
        MongoClient mongoClient = MongoClients.create(uri);

        /* OPERACIONES QUE QUIERO REALIZAR */

        // Referencio la bbdd de la conexión establecida con MongoDB
        MongoDatabase bbdd = mongoClient.getDatabase("accesodatos");

        // Creo una colección nueva
        bbdd.createCollection("autores");

        // Referencio la colección
        MongoCollection<Document> autores = bbdd.getCollection("autores");

        // Creo un nuevo autor
        Document autor1 = new Document();
        autor1.append("nombre", "Antonio Machado");

        Document autor2 = new Document();
        autor2.append("nombre", "Edgar Allan Poe");
        autor2.append("Anno_nacimiento", 1809);

        // INSERT MODO 1: Los añado de una sola vez
        //autores.insertMany(Arrays.asList(autor1, autor2));

        // INSERT MODO2: Lo añado a la colección de uno en uno
        autores.insertOne(autor1);

        // En este caso recojo el resultado con un objeto InsertOneResult
        InsertOneResult resultado = autores.insertOne(autor2);
        System.out.println(resultado.getInsertedId());

        // Documento un poco mas complejos
        Document autor3 = new Document("nombre", "William Shakespeare")
                .append("Anno_nacimiento", 1591)
                .append("Categorias", Arrays.asList("Teatro", "Terror", "Poesia"))
                .append("Libros", Arrays.asList(new Document("titulo","Romeo y Julieta")
                                                .append("numero_paginas", 500)
                                                .append("puntuacion", 4)))
                .append("Ciudad_nacimiento", new Document("nombre","Stratford-upon-Avon")
                                .append("municipio","Warwickshire "));

        autores.insertOne(autor3);









        // Cierro la conexion
        mongoClient.close();
    }
}
