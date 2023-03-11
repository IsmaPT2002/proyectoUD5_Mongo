package AgregarConLookup;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

// Obtener todas las calificaciones junto con el nombre del vino y la bodega correspondientes
public class ObtCalmasVinBod {
    public static void main(String[] args) {
        // Crea un cliente de MongoDB que se conecta al servidor local en el puerto 27017
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Obtiene la base de datos llamada "vinos" del cliente
        MongoDatabase database = mongoClient.getDatabase("vinos");

        // Obtiene la colección llamada "calificacion" de la base de datos
        MongoCollection<Document> calificaciones = database.getCollection("calificacion");

        // Obtiene la colección llamada "vino" de la base de datos
        MongoCollection<Document> vinos = database.getCollection("vino");

        // Obtiene la colección llamada "bodega" de la base de datos
        MongoCollection<Document> bodegas = database.getCollection("bodega");

        // Crea una lista de documentos que define las operaciones de agregación a realizar
        List<Document> pipeline = Arrays.asList(
                // Realiza una operación de lookup en la colección "vino" y agrega información de esa colección
                new Document("$lookup",
                        new Document("from", "vino")
                                .append("localField", "vino._id")
                                .append("foreignField", "_id")
                                .append("as", "vino")),
                // Descompone los documentos resultantes de la operación anterior para que haya uno por cada elemento del arreglo "vino"
                new Document("$unwind", "$vino"),
                // Realiza otra operación de lookup en la colección "bodega" y agrega información de esa colección
                new Document("$lookup",
                        new Document("from", "bodega")
                                .append("localField", "vino.bodega")
                                .append("foreignField", "_id")
                                .append("as", "bodega")),
                // Descompone los documentos resultantes de la operación anterior para que haya uno por cada elemento del arreglo "bodega"
                new Document("$unwind", "$bodega"),
                // Selecciona los campos que se quieren proyectar en los documentos resultantes
                new Document("$project",
                        new Document("_id", 1)
                                .append("puntuacion", 1)
                                .append("comentario", 1)
                                .append("vino.nombre", 1)
                                .append("bodega.nombre", 1))
        );

        // Ejecuta la operación de agregación en la colección "calificacion" y obtiene un iterable con los documentos resultantes
        AggregateIterable<Document> result = calificaciones.aggregate(pipeline);

        // Itera sobre los documentos resultantes y los imprime en formato JSON
        for (Document document : result) {
            System.out.println(document.toJson());
        }
    }
}
