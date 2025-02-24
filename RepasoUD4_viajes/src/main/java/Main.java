import Model.Avion;
import Model.Vuelo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main {

    public static void main(String[] args) {
        // Creo la conexión con la base de datos
        String uri = "mongodb://localhost:27017/";
        MongoClient mongoClient = MongoClients.create(uri);

        // Configuro la conexión para poder trabajar con el POJO de Vuelo
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(
                                     getDefaultCodecRegistry(),
                                     fromProviders(pojoCodecProvider));
        MongoDatabase database = mongoClient.getDatabase("viajes").withCodecRegistry(pojoCodecRegistry);
        MongoCollection<Vuelo> collection = database.getCollection("vuelos", Vuelo.class);

        // Insertamos algunos vuelos
        Avion avionf15 = new Avion("F15",2);
        Avion avion747 = new Avion("747",300);
        Avion avionCesna = new Avion("Cesna",6);

        InsertOneResult resultado = collection.insertOne(new Vuelo("Zaragoza", "Londres", avionf15));
        System.out.println("El ObjectId insertado es: "+resultado.getInsertedId());
        resultado = collection.insertOne(new Vuelo("Zaragoza", "Tenerife", avion747));
        System.out.println("El ObjectId insertado es: "+resultado.getInsertedId());
        resultado = collection.insertOne(new Vuelo("Zaragoza", "Milan", avionCesna));
        System.out.println("El ObjectId insertado es: "+resultado.getInsertedId());



    }
}
