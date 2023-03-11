// Importamos las librerías necesarias
package Actualizar;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

// Importamos el método "eq" de la clase "Filters"
import static com.mongodb.client.model.Filters.eq;

// Eliminar una calificación de un vino
public class EliminarCalificacionVino {
    public static void main(String[] args) {
        // Creamos un objeto MongoClient que nos permite conectarnos a la base de datos
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Obtenemos la base de datos "vinos" a la que nos conectamos anteriormente
        MongoDatabase database = mongoClient.getDatabase("vinos");

        // Obtenemos la colección "vino" de la base de datos "vinos"
        MongoCollection<Document> collection = database.getCollection("vino");

        // Actualizamos un documento en la colección "vino" usando el método "updateOne"
        // Eliminamos un elemento de un array dentro del documento
        collection.updateOne(eq("_id", new ObjectId("640b0a98f369c3cda9a3a128")),
                new Document("$pull", new Document("calificaciones",
                        new Document("puntuacion", 8))));

        // Buscamos el documento actualizado en la colección "vino" usando el método "find"
        Document vino = collection.find(eq("_id", new ObjectId("640b0a98f369c3cda9a3a128"))).first();

        // Imprimimos el documento como un objeto JSON
        System.out.println(vino.toJson());
    }
}



