package Consultar;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.regex.Pattern;

// Consulta los usuarios que tienen un 1 en el campo "email"
public class Usuarioconun1enEmail {

    public static void main(String[] args) {

        // Se establece la conexión con la base de datos MongoDB
        String connectionString = "mongodb://localhost:27017";
        try (var mongoClient = MongoClients.create(connectionString)) {

            // Se obtiene la base de datos y la colección a consultar
            MongoDatabase database = mongoClient.getDatabase("vinos");
            MongoCollection<Document> collection = database.getCollection("usuario");

            // Se crea una expresión regular para buscar el número 1 en el campo "email"
            Pattern pattern = Pattern.compile("1");
            Bson filter = Filters.regex("email", pattern);

            // Se realiza la consulta y se obtiene un cursor para iterar sobre los resultados
            MongoCursor<Document> cursor = collection.find(filter).iterator();

            // Se recorren los resultados y se imprimen
            try {
                while (cursor.hasNext()) {
                    Document doc = cursor.next();
                    System.out.println(doc.toJson());
                }
            } finally {
                cursor.close();
            }

        }
    }
}