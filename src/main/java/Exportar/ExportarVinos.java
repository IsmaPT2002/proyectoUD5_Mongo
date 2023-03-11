package Exportar;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportarVinos {
    public static void main(String[] args) {
        // Conectar con MongoDB
        String connectionString = "mongodb://localhost:27017";
        try (var mongoClient = MongoClients.create(connectionString)) {
            // Obtener objeto de base de datos y colección
            MongoDatabase database = mongoClient.getDatabase("vinos");
            MongoCollection<Document> collection = database.getCollection("vino");

            // Crear archivo de salida
            File file = new File("JSON/vinos.json");
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                // Iterar sobre los documentos y escribirlos en el archivo
                for (Document doc : collection.find()) {
                    out.println(doc.toJson());
                }
                System.out.println("Exportación completada.");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }
}
