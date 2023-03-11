package Actualizar; // Definición del paquete ActualizarDocumentos

import com.mongodb.client.MongoClients; // Importación de la clase MongoClients de la biblioteca MongoDB
import com.mongodb.client.MongoClient; // Importación de la clase MongoClient de la biblioteca MongoDB
import com.mongodb.client.MongoCollection; // Importación de la clase MongoCollection de la biblioteca MongoDB
import com.mongodb.client.MongoDatabase; // Importación de la clase MongoDatabase de la biblioteca MongoDB
import org.bson.Document; // Importación de la clase Document de la biblioteca BSON

// Actualizar la contraseña de un usuario
public class ActualizarContraUsu { // Definición de la clase pública ActualizarContraUsu
    public static void main(String[] args) { // Definición del método principal main
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017"); // Creación de una nueva instancia de MongoClient que apunta al servidor MongoDB en localhost:27017
        MongoDatabase database = mongoClient.getDatabase("vinos"); // Obtiene la base de datos "vinos" del servidor MongoDB

        MongoCollection<org.bson.Document> collection = database.getCollection("usuario"); // Obtiene la colección "usuario" de la base de datos "vinos"

        Document filtro = new Document("idUsuario", 10); // Crea un documento de filtro con el campo "idUsuario" igual a 10
        Document update = new Document("$set", new Document("password", "nuevaContraseña")); // Crea un documento de actualización que establece el campo "password" a "nuevaContraseña"
        collection.updateOne(filtro, update); // Actualiza un solo documento que cumple con el filtro especificado y lo actualiza con el documento de actualización especificado.

        System.out.println("Contraseña actualizada con éxito"); // Muestra en la consola el mensaje "Contraseña actualizada con éxito"
        mongoClient.close(); // Cierra la conexión con el servidor MongoDB
    }
}
