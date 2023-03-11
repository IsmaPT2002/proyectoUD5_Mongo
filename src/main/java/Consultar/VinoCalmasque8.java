package Consultar;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

// Consulta los vinos que tienen una puntuación mayor a 8
public class VinoCalmasque8 {

    public static void main(String[] args) {

        // Establecer la cadena de conexión para conectarse a la base de datos de MongoDB
        String connectionString = "mongodb://localhost:27017";
        // Crear un objeto MongoClient para conectarse a la base de datos
        try (var mongoClient = MongoClients.create(connectionString)) {
            // Obtener una referencia a la base de datos "vinos"
            MongoDatabase database = mongoClient.getDatabase("vinos");
            // Obtener una referencia a la colección "calificacion" en la base de datos
            MongoCollection<Document> collection = database.getCollection("calificacion");

            // Crear un filtro para buscar los documentos donde la puntuación sea mayor a 8
            Bson filter = Filters.gt("puntuacion", 8);

            // Ejecutar la consulta en la colección y obtener un iterador de resultados
            FindIterable<Document> result = collection.find(filter);

            // Recorrer los documentos del resultado e imprimirlos en formato JSON
            for (Document doc : result) {
                System.out.println(doc.toJson());
            }

        }
    }
}



