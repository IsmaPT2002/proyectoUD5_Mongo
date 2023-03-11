package Agrupar;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;

import java.util.Arrays;

// Cantidad de comentarios que utilizan la palabra "vino" para cada vino
public class CantComPalabraVino {
    public static void main(String[] args) {
        // Conectar con MongoDB
        String connectionString = "mongodb://localhost:27017";
        try (var mongoClient = MongoClients.create(connectionString)) {
            // Obtener objeto de base de datos y colección
            MongoDatabase database = mongoClient.getDatabase("vinos");
            MongoCollection<Document> collection = database.getCollection("calificacion");

            // Pipeline de agregación: agrupar comentarios por vino y contar la cantidad de comentarios que utilizan la palabra "vino"
            var regex = ".*\\bvino\\b.*";
            var groupStage = Aggregates.group("$vino", Accumulators.sum("cantidadComentariosVino",
                    new Document("$cond", Arrays.asList(new Document("$regexMatch",
                                    new Document("input", "$comentario").append("regex", regex)),
                            1, 0))));
            var sortStage = Aggregates.sort(Sorts.ascending("_id.nombre"));

            // Ejecutar pipeline de agregación
            var results = collection.aggregate(Arrays.asList(groupStage, sortStage));
            System.out.println("Cantidad de comentarios que utilizan la palabra 'vino' en cada vino:");
            for (Document doc : results) {
                System.out.println(doc.toJson());
            }
        }
    }
}

