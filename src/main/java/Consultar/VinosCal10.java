package Consultar;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

// Consulta los vinos que tienen una calificación igual a 10
public class VinosCal10 {

    public static void main(String[] args) {

        // Conexión con la base de datos MongoDB
        String connectionString = "mongodb://localhost:27017";
        try (var mongoClient = MongoClients.create(connectionString)) {

            // Selección de la base de datos y la colección "vino"
            MongoDatabase database = mongoClient.getDatabase("vinos");
            MongoCollection<Document> collection = database.getCollection("vino");

            // Creación del filtro para buscar vinos con calificaciones igual a 10
            Bson filter = Filters.elemMatch("calificaciones", Filters.eq("puntuacion", 10));

            // Ejecución de la consulta y obtención de los resultados
            FindIterable<Document> result = collection.find(filter);

            // Iteración sobre los documentos de la consulta y su impresión en formato JSON
            for (Document doc : result) {
                System.out.println(doc.toJson());
            }

        }
    }
}
