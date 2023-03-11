package Consultar; // declara el paquete Consultar

import com.mongodb.client.*; // importa la librería de MongoDB para Java
import com.mongodb.client.model.Filters; // importa la clase Filters de MongoDB para Java
import org.bson.Document; // importa la clase Document de MongoDB para Java
import org.bson.conversions.Bson; // importa la clase Bson de MongoDB para Java

// Consulta los documentos de la colección "bodega" donde el campo "anhoFundacion" sea menor a "1990"
public class Bodantes1990 {

    public static void main(String[] args) { // declara el método principal de la clase

        String connectionString = "mongodb://localhost:27017"; // declara una cadena de conexión a la base de datos
        try (var mongoClient = MongoClients.create(connectionString)) { // crea un cliente de MongoDB a través de la cadena de conexión
            MongoDatabase database = mongoClient.getDatabase("vinos"); // obtiene la base de datos "vinos" del cliente
            MongoCollection<Document> collection = database.getCollection("bodega"); // obtiene la colección "bodega" de la base de datos
            Bson filter = Filters.lt("anhoFundacion", "1990-01-01T00:00:00.000Z"); // crea un filtro para buscar documentos donde el campo "anhoFundacion" sea menor a "1990-01-01T00:00:00.000Z"

            FindIterable<Document> result = collection.find(filter); // ejecuta la consulta y devuelve un iterable de documentos

            for (Document doc : result) { // itera sobre los documentos encontrados
                System.out.println(doc.toJson()); // imprime el documento en formato JSON
            }
        }
    }
}
