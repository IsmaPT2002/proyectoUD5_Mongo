// Importamos las clases necesarias para conectarnos a la base de datos de MongoDB y manejar documentos BSON
package AgregarConLookup;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

// Obtener todas las calificaciones realizadas por un usuario en particular, junto con el nombre del vino y la bodega correspondientes
public class ObtCalporUsumasVinoBod {
    public static void main(String[] args) {
// Creamos una instancia de cliente de MongoDB y nos conectamos a una base de datos llamada "vinos"
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("vinos");
        // Obtenemos las colecciones "usuario", "calificacion", "vino" y "bodega" de la base de datos
        MongoCollection<Document> usuarios = database.getCollection("usuario");
        MongoCollection<Document> calificaciones = database.getCollection("calificacion");
        MongoCollection<Document> vinos = database.getCollection("vino");
        MongoCollection<Document> bodegas = database.getCollection("bodega");

        // Definimos el id del usuario que deseamos buscar
        int idUsuario = 10;

        // Creamos una lista de documentos para usar como pipeline de agregación
        List<Document> pipeline = Arrays.asList(
                // Filtramos las calificaciones para obtener solo las que corresponden al usuario con el id especificado
                new Document("$match",
                        new Document("usuario.idUsuario", idUsuario)),
                // Realizamos un lookup para unir los documentos de la colección "calificacion" con los documentos de la colección "vino"
                // usando los campos "vino.idVino" y "_id" como clave local y extranjera, respectivamente
                new Document("$lookup",
                        new Document("from", "vino")
                                .append("localField", "vino.idVino")
                                .append("foreignField", "_id")
                                .append("as", "vino")),
                // Desagregamos los documentos resultantes del lookup, creando un documento por cada uno de los elementos del arreglo "vino"
                new Document("$unwind", "$vino"),
                // Realizamos otro lookup para unir los documentos resultantes del paso anterior con los documentos de la colección "bodega"
                // usando los campos "vino.bodega" y "_id" como clave local y extranjera, respectivamente
                new Document("$lookup",
                        new Document("from", "bodega")
                                .append("localField", "vino.bodega")
                                .append("foreignField", "_id")
                                .append("as", "bodega")),
                // Desagregamos los documentos resultantes del último lookup, creando un documento por cada uno de los elementos del arreglo "bodega"
                new Document("$unwind", "$bodega"),
                // Proyectamos los campos que deseamos obtener en el resultado final
                new Document("$project",
                        new Document("_id", 1)
                                .append("puntuacion", 1)
                                .append("comentario", 1)
                                .append("vino.nombre", 1)
                                .append("bodega.nombre", 1))
        );

        // Ejecutamos el pipeline de agregación sobre la colección "calificacion" y obtenemos el resultado como un iterable de documentos
        AggregateIterable<Document> result = calificaciones.aggregate(pipeline);
        // Iteramos sobre los documentos del resultado e imprimimos cada uno de ellos en formato JSON
        for (Document document : result) {
            System.out.println(document.toJson());
        }

    }
}