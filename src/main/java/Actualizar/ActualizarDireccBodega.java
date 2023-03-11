package Actualizar; // Definición del paquete ActualizarDocumentos

import com.mongodb.client.MongoClients; // Importación de la clase MongoClients de la biblioteca MongoDB
import com.mongodb.client.MongoClient; // Importación de la clase MongoClient de la biblioteca MongoDB
import com.mongodb.client.MongoCollection; // Importación de la clase MongoCollection de la biblioteca MongoDB
import com.mongodb.client.MongoDatabase; // Importación de la clase MongoDatabase de la biblioteca MongoDB
import com.mongodb.client.result.UpdateResult; // Importación de la clase UpdateResult de la biblioteca MongoDB
import org.bson.Document; // Importación de la clase Document de la biblioteca BSON
import org.bson.conversions.Bson; // Importación de la clase Bson de la biblioteca BSON

import static com.mongodb.client.model.Filters.eq; // Importación de la clase eq de la biblioteca MongoDB
import static com.mongodb.client.model.Updates.set; // Importación de la clase set de la biblioteca MongoDB

// Actualizar la dirección de una bodega
public class ActualizarDireccBodega { // Definición de la clase pública ActualizarDireccBodega
    public static void main(String[] args) { // Definición del método principal main
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"); // Creación de una nueva instancia de MongoClient que apunta al servidor MongoDB en localhost:27017
        MongoDatabase database = mongoClient.getDatabase("vinos"); // Obtiene la base de datos "vinos" del servidor MongoDB
        MongoCollection<Document> collection = database.getCollection("bodega"); // Obtiene la colección "bodega" de la base de datos "vinos"

        String nombreBodega = "Weingut Max Ferd. Richter"; // Define el nombre de la bodega a actualizar
        String nuevaDireccion = "Nueva dirección de la bodega"; // Define la nueva dirección de la bodega

        Bson filter = eq("nombre", nombreBodega); // Crea un objeto Bson que representa el filtro para buscar la bodega por su nombre
        Bson update = set("direccion", nuevaDireccion); // Crea un objeto Bson que representa la actualización a realizar, estableciendo el campo "direccion" con la nueva dirección
        UpdateResult result = collection.updateOne(filter, update); // Actualiza un solo documento que cumple con el filtro especificado y lo actualiza con el documento de actualización especificado.

        System.out.println("Número de documentos modificados: " + result.getModifiedCount()); // Muestra en la consola el número de documentos modificados

        mongoClient.close(); // Cierra la conexión con el servidor MongoDB
    }
}
