package Exportar;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Exporta los documentos de la colección "usuario" a un archivo JSON
public class ExportarUsuarios {
    public static void main(String[] args) {
        // Se define la cadena de conexión a la base de datos MongoDB
        String connectionString = "mongodb://localhost:27017";
        // Se crea un cliente de MongoDB con la cadena de conexión
        try (var mongoClient = MongoClients.create(connectionString)) {
            // Se obtiene la base de datos "vinos"
            MongoDatabase database = mongoClient.getDatabase("vinos");
            // Se obtiene la colección "usuario"
            MongoCollection<Document> collection = database.getCollection("usuario");

            // Se crea un archivo "usuarios.json" en la carpeta "JSON"
            File file = new File("JSON/usuarios.json");
            // Se crea un objeto PrintWriter para escribir en el archivo
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                // Se itera sobre los documentos de la colección "usuario"
                for (Document doc : collection.find()) {
                    // Se escribe el documento en formato JSON en el archivo
                    out.println(doc.toJson());
                }
                // Se imprime un mensaje indicando que la exportación ha sido completada
                System.out.println("Exportación completada.");
            } catch (IOException e) {
                // Se imprime un mensaje de error en caso de que falle la escritura en el archivo
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }
}


