package Exportar; // Declaración del paquete donde se encuentra la clase

import com.mongodb.client.MongoClients; // Importación de las clases necesarias para conectarse a MongoDB
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document; // Importación de la clase necesaria para manejar los documentos BSON de MongoDB

import java.io.File; // Importación de las clases necesarias para trabajar con archivos
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Exporta los documentos de la colección "calificacion" a un archivo JSON
public class ExportarCalificaciones {
    public static void main(String[] args) {

        String connectionString = "mongodb://localhost:27017"; // Cadena de conexión a la base de datos
        try (var mongoClient = MongoClients.create(connectionString)) { // Conexión a la base de datos
            MongoDatabase database = mongoClient.getDatabase("vinos"); // Obtiene la base de datos "vinos"
            MongoCollection<Document> collection = database.getCollection("calificacion"); // Obtiene la colección "calificacion"

            File file = new File("JSON/calificaciones.json"); // Crea un nuevo archivo en la ruta "JSON/calificaciones.json"
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) { // Crea un PrintWriter para escribir en el archivo
                for (Document doc : collection.find()) { // Recorre todos los documentos de la colección "calificacion"
                    out.println(doc.toJson()); // Escribe el documento en formato JSON en el archivo
                }
                System.out.println("Exportación completada."); // Muestra un mensaje en la consola si la exportación fue exitosa
            } catch (IOException e) { // Manejo de excepciones en caso de error de escritura en el archivo
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }
}


