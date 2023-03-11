// Se establece el paquete de la clase
package AgregarConLookup;

// Importaciones de las clases necesarias
import com.mongodb.client.*;
import org.bson.Document;
import java.util.Arrays;
import java.util.List;

// Obtiene todas las bodegas junto con los nombres de sus vinos y las calificaciones correspondientes
public class ObtBodmasVinCal {
    public static void main(String[] args) {    // Se establece la conexión con el servidor de MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Se obtiene la base de datos "vinos"
        MongoDatabase database = mongoClient.getDatabase("vinos");

        // Se obtienen las colecciones "vino", "bodega" y "calificacion"
        MongoCollection<Document> vinos = database.getCollection("vino");
        MongoCollection<Document> bodegas = database.getCollection("bodega");
        MongoCollection<Document> calificaciones = database.getCollection("calificacion");

        // Se define el pipeline para la agregación
        List<Document> pipeline = Arrays.asList(
                // Se realiza una operación $lookup para unir la colección "vino" con la colección "bodega" y se guarda el resultado en el campo "vinos"
                new Document("$lookup",
                        new Document("from", "vino")
                                .append("localField", "_id")
                                .append("foreignField", "bodega")
                                .append("as", "vinos")),
                // Se descompone el array "vinos" para obtener un registro por cada vino en cada bodega
                new Document("$unwind", "$vinos"),
                // Se realiza una operación $lookup para unir la colección "calificacion" con la colección "vino" y se guarda el resultado en el campo "calificaciones"
                new Document("$lookup",
                        new Document("from", "calificacion")
                                .append("localField", "vinos._id")
                                .append("foreignField", "vino")
                                .append("as", "calificaciones")),
                // Se agrupa los resultados por el nombre de la bodega y se guarda un array con el nombre de los vinos y sus calificaciones
                new Document("$group",
                        new Document("_id", "$nombre")
                                .append("vinos",
                                        new Document("$push",
                                                new Document("nombre", "$vinos.nombre")
                                                        .append("calificaciones", "$calificaciones"))))
        );

        // Se realiza la agregación y se almacenan los resultados en "result"
        AggregateIterable<Document> result = bodegas.aggregate(pipeline);

        // Se imprime el resultado en formato JSON
        for (Document document : result) {
            System.out.println(document.toJson());
        }
    }
}
