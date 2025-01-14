import Model.Autor;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Arrays;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main1 {
    public static void main(String[] args) {
        // URI de conexión con el servidor MongoDB
        String uri = "mongodb://localhost:27017/";
        // Establezco la conexion
        MongoClient mongoClient = MongoClients.create(uri);

        /* OPERACIONES QUE QUIERO REALIZAR */

        // Para poder usar POJOs
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        // Referencio la bbdd de la conexión establecida con MongoDB
        MongoDatabase bbdd = mongoClient.getDatabase("accesodatos").withCodecRegistry(pojoCodecRegistry);;

        // Creo una colección nueva
        bbdd.createCollection("autores");
        
        // Referencio la colección
        MongoCollection<Autor> autores = bbdd.getCollection("autores", Autor.class);


        Autor a1 = new Autor("Sergio Perez", Arrays.asList("Terror", "Comedia"),true,1901);

        autores.insertOne(a1);



        // Cierre de la conexion
        mongoClient.close();
    }
}
