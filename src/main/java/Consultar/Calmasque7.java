package Consultar; // declara el paquete Consultar

import com.mongodb.client.*; // importa la librería de MongoDB para Java
import com.mongodb.client.model.Projections; // importa la clase Projections de MongoDB para Java
import org.bson.Document; // importa la clase Document de MongoDB para Java
import java.util.List; // importa la clase List de Java

// Consulta los documentos de la colección "calificacion" donde el campo "puntuacion" sea mayor o igual a "8"
public class Calmasque7 {

    public static void main(String[] args) { // declara el método principal de la clase

        String connectionString = "mongodb://localhost:27017"; // declara una cadena de conexión a la base de datos
        try (var mongoClient = MongoClients.create(connectionString)) { // crea un cliente de MongoDB a través de la cadena de conexión

            MongoDatabase database = mongoClient.getDatabase("vinos"); // obtiene la base de datos "vinos" del cliente
            MongoCollection<Document> collection = database.getCollection("calificacion"); // obtiene la colección "calificacion" de la base de datos

            FindIterable<Document> iterable = collection.find(new Document("puntuacion", new Document("$gte", 8))) // crea un objeto FindIterable para buscar documentos donde el campo "puntuacion" sea mayor o igual a 8
                    .projection(Projections.include("vino.nombre", "vino.bodega.nombre", "usuario.nombre")); // proyecta los campos "vino.nombre", "vino.bodega.nombre" y "usuario.nombre"

            MongoCursor<Document> cursor = iterable.iterator(); // crea un objeto MongoCursor para iterar sobre los documentos encontrados
            while (cursor.hasNext()) { // mientras hayan documentos por iterar
                Document doc = cursor.next(); // obtiene el siguiente documento
                String vinoNombre = doc.getEmbedded(List.of("vino", "nombre"), String.class); // obtiene el nombre del vino del documento
                String bodegaNombre = doc.getEmbedded(List.of("vino", "bodega", "nombre"), String.class); // obtiene el nombre de la bodega del documento
                String usuarioNombre = doc.getEmbedded(List.of("usuario", "nombre"), String.class); // obtiene el nombre del usuario del documento
                System.out.println("Vino: " + vinoNombre + ", Bodega: " + bodegaNombre + ", Usuario: " + usuarioNombre); // imprime los nombres obtenidos
            }
        }
    }
}
