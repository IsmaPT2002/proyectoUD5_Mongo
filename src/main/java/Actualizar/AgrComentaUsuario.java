package Actualizar;

// Importar las clases necesarias de la biblioteca de MongoDB
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

// Agregar un comentario a un vino
public class AgrComentaUsuario {
    // Definir un método "main" para ejecutar el código
    public static void main(String[] args) {
        // Crear un cliente de MongoDB y conectarse a la base de datos "vinos"
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("vinos");

        // Obtener una colección llamada "vino"
        MongoCollection<org.bson.Document> collection = database.getCollection("vino");

        // Obtener una colección llamada "usuario"
        MongoCollection<Document> usuarioCollection = database.getCollection("usuario");

        // Crear un filtro que busque un documento con "idUsuario" igual a 9
        Bson filter = Filters.eq("idUsuario", 9);

        // Crear un objeto "update" que agregue un comentario y una calificación a la lista "calificacion"
        // dentro del documento encontrado por el filtro
        Bson update = Updates.push("calificacion", Document.parse("{\n" +
                "        _id: ObjectId(\"5c82b53e94f5ba5b9829b040\"),\n" +
                "        valoracion: 6,\n" +
                "        comentario: 'Buen vino, pero un poco demasiado caro.',\n" +
                "        vino: {\n" +
                "          idVino: ObjectId(\"640b0a98f369c3cda9a3a130\"),\n" +
                "          nombre: 'Cabernet Sauvignon 2016',\n" +
                "          bodega: 'Bodega Catena Zapata'\n" +
                "        }\n" +
                "      }"));

        // Actualizar un documento en la colección "usuario" que coincide con el filtro y aplicar el objeto "update" a él
        UpdateResult result = usuarioCollection.updateOne(filter, update);

        // Imprimir el número de documentos actualizados
        System.out.println("Número de documentos actualizados: " + result.getModifiedCount());

        // Cerrar la conexión con la base de datos
        mongoClient.close();
    }
}
