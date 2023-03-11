package Consultar;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

// Consulta las calificaciones del usuario con "idUsuario" = 10
public class CalUsuario10 {

    public static void main(String[] args) {

        // Establece la conexión con la base de datos
        String connectionString = "mongodb://localhost:27017";
        try (var mongoClient = MongoClients.create(connectionString)) {
            // Obtiene la base de datos "vinos"
            MongoDatabase database = mongoClient.getDatabase("vinos");
            // Obtiene la colección "usuario" de la base de datos
            MongoCollection<Document> collection = database.getCollection("usuario");
            // Crea un filtro para buscar el usuario con "idUsuario" = 10
            Bson filter = Filters.eq("idUsuario", 10);
            // Busca el primer usuario que cumple con el filtro
            Document user = collection.find(filter).first();
            // Obtiene la lista de calificaciones del usuario
            List<Document> calificaciones = user.getList("calificacion", Document.class);
            // Imprime cada calificación en formato JSON
            for (Document calificacion : calificaciones) {
                System.out.println(calificacion.toJson());
            }
        }
    }
}
