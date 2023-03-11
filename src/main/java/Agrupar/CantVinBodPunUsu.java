package Agrupar;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.Arrays;

// Exclusividad de vinos, bodegas, puntaciones y usuarios
public class CantVinBodPunUsu {
    public static void main(String[] args) {
        // Conectar con MongoDB
        String connectionString = "mongodb://localhost:27017";
        try (var mongoClient = MongoClients.create(connectionString)) {
            // Obtener objeto de base de datos y colección
            MongoDatabase database = mongoClient.getDatabase("vinos");
            MongoCollection<Document> collection = database.getCollection("calificacion");

            // Realizar agrupación por puntuación y contar cantidad de calificaciones por puntuación
            var groupStage1 = Aggregates.group("$puntuacion", Accumulators.sum("count", 1));
            var sortStage1 = Aggregates.sort(Sorts.descending("_id"));

            // Ejecutar pipeline de agregación
            var results1 = collection.aggregate(Arrays.asList(groupStage1, sortStage1));
            System.out.println("Agrupación por puntuación:");
            for (Document doc : results1) {
                System.out.println(doc.toJson());
            }

            // Cambiar de colección
            collection = database.getCollection("usuario");

            // Realizar agrupación por nombre de usuario y contar cantidad de usuarios por nombre
            var groupStage2 = Aggregates.group("$nombre", Accumulators.sum("count", 1));
            var sortStage2 = Aggregates.sort(Sorts.ascending("_id"));

            // Ejecutar pipeline de agregación
            var results2 = collection.aggregate(Arrays.asList(groupStage2, sortStage2));
            System.out.println("\nAgrupación por usuario:");
            for (Document doc : results2) {
                System.out.println(doc.toJson());
            }

            // Cambiar de colección
            collection = database.getCollection("bodega");

            // Realizar agrupación por nombre de bodega y contar cantidad de vinos por bodega
            var groupStage3 = Aggregates.group("$nombre", Accumulators.sum("count", 1));
            var sortStage3 = Aggregates.sort(Sorts.ascending("_id"));

            // Ejecutar pipeline de agregación
            var results3 = collection.aggregate(Arrays.asList(groupStage3, sortStage3));
            System.out.println("\nAgrupación por bodega:");
            for (Document doc : results3) {
                System.out.println(doc.toJson());
            }

            // Cambiar de colección
            collection = database.getCollection("vino");

            // Realizar agrupación por nombre de vino y contar cantidad de vinos por nombre
            var groupStage4 = Aggregates.group("$nombre", Accumulators.sum("count", 1));
            var sortStage4 = Aggregates.sort(Sorts.ascending("_id"));

            // Ejecutar pipeline de agregación
            var results4 = collection.aggregate(Arrays.asList(groupStage4, sortStage4));
            System.out.println("\nAgrupación por vino:");
            for (Document doc : results4) {
                System.out.println(doc.toJson());
            }
        }
    }
}



