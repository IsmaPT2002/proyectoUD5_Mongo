package Actualizar;

import com.mongodb.client.MongoClients;  // importa la clase MongoClients de la biblioteca MongoDB
import com.mongodb.client.MongoClient;  // importa la interfaz MongoClient de la biblioteca MongoDB
import com.mongodb.client.MongoCollection;  // importa la clase MongoCollection de la biblioteca MongoDB
import com.mongodb.client.MongoDatabase;  // importa la clase MongoDatabase de la biblioteca MongoDB
import org.bson.Document;  // importa la clase Document de la biblioteca BSON
import org.bson.types.ObjectId;  // importa la clase ObjectId de la biblioteca BSON

// Actualizar la puntuación y el comentario de una calificación
public class ActualizarPuntyCom {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");  // crea un cliente de MongoDB
        MongoDatabase database = mongoClient.getDatabase("vinos");  // obtiene la base de datos "vinos" de MongoDB

        MongoCollection<org.bson.Document> collection = database.getCollection("calificacion");  // obtiene la colección "calificacion" de la base de datos

        Document filtro = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b011"));  // crea un documento para filtrar el documento a actualizar, en este caso por su _id
        Document update = new Document("$set", new Document("puntuacion", 3).append("comentario", "Me encantó este Riesling, con notas de frutas tropicales y una acidez equilibrada."));  // crea un documento para actualizar el documento, estableciendo la nueva puntuación y el nuevo comentario

        collection.updateOne(filtro, update);  // actualiza el documento que cumple con el filtro y aplica la actualización

        System.out.println("Calificación actualizada con éxito");  // imprime un mensaje de éxito

        mongoClient.close();  // cierra la conexión con la base de datos
    }
}


