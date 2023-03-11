package Agrupar;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;

import java.util.Arrays;

// Cantidad de vinos producidos por cada bodega
public class CantVinosPorBod {
    public static void main(String[] args) {
        // Conectar con MongoDB
        String connectionString = "mongodb://localhost:27017";
        try (var mongoClient = MongoClients.create(connectionString)) {
            // Obtener objeto de base de datos y colección
            MongoDatabase database = mongoClient.getDatabase("vinos");
            MongoCollection<Document> collection = database.getCollection("bodega");

            // Pipeline de agregación: agrupar vinos por bodega y contar la cantidad de vinos por bodega
            var groupStage1 = Aggregates.group("$nombre", Accumulators.sum("cantidadVinos", 1));
            var sortStage1 = Aggregates.sort(Sorts.descending("cantidadVinos"));

            // Ejecutar pipeline de agregación
            var results1 = collection.aggregate(Arrays.asList(groupStage1, sortStage1));
            System.out.println("Cantidad de vinos producidos por cada bodega:");
            for (Document doc : results1) {
                System.out.println(doc.toJson());
            }
        }
    }
}
