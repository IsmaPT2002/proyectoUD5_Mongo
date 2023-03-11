package Exportar; // Paquete de Java en el que se encuentra la clase

import com.mongodb.client.MongoClients; // Importa la clase MongoClient de MongoDB para conectarse a la base de datos
import com.mongodb.client.MongoCollection; // Importa la clase MongoCollection para trabajar con colecciones en la base de datos
import com.mongodb.client.MongoDatabase; // Importa la clase MongoDatabase para trabajar con bases de datos en MongoDB
import org.bson.Document; // Importa la clase Document de MongoDB para trabajar con documentos BSON

import java.io.File; // Importa la clase File para trabajar con archivos en el sistema de archivos
import java.io.FileWriter; // Importa la clase FileWriter para escribir en archivos
import java.io.IOException; // Importa la clase IOException para manejar errores de entrada/salida
import java.io.PrintWriter; // Importa la clase PrintWriter para escribir texto formateado en archivos

// Exporta los documentos de la colección "bodega" a un archivo JSON
public class ExportarBodegas {

    public static void main(String[] args) { // Método principal que se ejecuta al iniciar el programa

        String connectionString = "mongodb://localhost:27017"; // URL de la base de datos MongoDB
        try (var mongoClient = MongoClients.create(connectionString)) { // Se conecta a la base de datos
            MongoDatabase database = mongoClient.getDatabase("vinos"); // Obtiene la base de datos "vinos"
            MongoCollection<Document> collection = database.getCollection("bodega"); // Obtiene la colección "bodega" de la base de datos

            File file = new File("JSON/bodegas.json"); // Crea un objeto File para representar el archivo de salida
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) { // Abre un flujo de escritura hacia el archivo
                for (Document doc : collection.find()) { // Itera sobre los documentos de la colección
                    out.println(doc.toJson()); // Escribe cada documento en formato JSON en el archivo
                }
                System.out.println("Exportación completada."); // Imprime un mensaje de éxito en la consola
            } catch (IOException e) { // Maneja cualquier excepción de entrada/salida
                System.err.println("Error al escribir en el archivo: " + e.getMessage()); // Imprime un mensaje de error en la consola
            }
        }
    }
}

