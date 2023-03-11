// Se define el paquete donde se encuentra la clase "GenerarVinos"
package Generar;

// Se importan las clases necesarias para utilizar MongoDB y trabajar con documentos BSON
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

// Se importa la clase "Arrays" para poder crear listas de documentos BSON
import java.util.Arrays;

// Se define la clase "GenerarVinos"
public class GenerarVinos {
    // Método principal que se ejecutará al correr la clase
    public static void main(String[] args) {
        // Se crea un cliente de MongoDB para conectarse al servidor local (por defecto) de MongoDB
        MongoClient mongoClient = MongoClients.create();
        // Se obtiene la base de datos "vinos" del cliente MongoDB
        MongoDatabase database = mongoClient.getDatabase("vinos");

        // Se crea un documento BSON que representa el vino1
        Document vino1 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a120"))
                .append("nombre", "Rioja Reserva 2001")
                .append("bodega", new Document("nombre", "Bodega Rioja")
                        .append("direccion", "Calle Rioja, 1, 28001 Madrid"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 10)
                                .append("comentario", "Tremendo vino."),
                        new Document("puntuacion", 9)
                                .append("comentario", "Buen equilibrio de sabores.")
                ));
        Document vino2 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a121"))
                .append("nombre", "Malbec Reserva 2010")
                .append("bodega", new Document("nombre", "Bodega Norton")
                        .append("direccion", "Ruta 15 km 23,5, Luján de Cuyo, Mendoza"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 8)
                                .append("comentario", "Un buen vino, pero un poco ácido para mi gusto."),
                        new Document("puntuacion", 7)
                                .append("comentario", "Le falta un poco de cuerpo.")
                ));

        Document vino3 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a122"))
                .append("nombre", "Chardonnay 2015")
                .append("bodega", new Document("nombre", "Bodega Catena Zapata")
                        .append("direccion", "Cobos s/n, Luján de Cuyo, Mendoza"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 9)
                                .append("comentario", "Excelente vino, gran sabor.")
                ));

        Document vino4 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a123"))
                .append("nombre", "Cabernet Franc 2018")
                .append("bodega", new Document("nombre", "Bodega Bressia")
                        .append("direccion", "Montecaseros 2635, Agrelo, Mendoza"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 9)
                                .append("comentario", "Perfecto para una cena especial.")
                ));

        Document vino5 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a124"))
                .append("nombre", "Pinot Noir 2016")
                .append("bodega", new Document("nombre", "Bodega Chandon")
                        .append("direccion", "Ruta Provincial 15, km 29, Agrelo, Mendoza"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 8)
                                .append("comentario", "Buen vino, pero un poco suave para mi gusto.")
                ));

        Document vino6 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a125"))
                .append("nombre", "Syrah Reserva 2015")
                .append("bodega", new Document("nombre", "Bodega Norton")
                        .append("direccion", "Ruta 15 km 23,5, Luján de Cuyo, Mendoza"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 8)
                                .append("comentario", "Un poco caro, pero vale la pena.")
                ));

        Document vino7 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a126"))
                .append("nombre", "Sauvignon Blanc 2019")
                .append("bodega", new Document("nombre", "Bodega Salentein")
                        .append("direccion", "Ruta Provincial 89, s/n, Tupungato, Mendoza"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 8)
                                .append("comentario", "Refrescante y fácil de beber.")
                ));

        Document vino8 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a127"))
                .append("nombre", "Malbec Reserva 2012")
                .append("bodega", new Document("nombre", "Bodega Luigi Bosca")
                        .append("direccion", "San Martín 2044, Mayor Drummond, Luján de Cuyo, Mendoza"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 9)
                                .append("comentario", "Excelente vino, con un gran sabor y cuerpo.")

                ));
        Document vino9 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a128"))
                .append("nombre", "Champagne Brut Nature")
                .append("bodega", new Document("nombre", "Champagne Bollinger")
                        .append("direccion", "16 Rue Jules Lobet, 51160 Aÿ-Champagne, Francia"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 8)
                                .append("comentario", "Un poco más seco de lo que esperaba, pero sigue siendo un buen champagne.")
                ));

        Document vino10 = new Document("_id", new ObjectId("640b0a98f369c3cda9a3a129"))
                .append("nombre", "Riesling Kabinett 2019")
                .append("bodega", new Document("nombre", "Weingut Max Ferd. Richter")
                        .append("direccion", "Hauptstraße 37, 54492 Mulheim, Alemania"))
                .append("calificaciones", Arrays.asList(
                        new Document("puntuacion", 7)
                                .append("comentario", "Un poco demasiado dulce para mi gusto, pero sigue siendo un buen Riesling.")
                ));

        // Inserta cada documento de vino en la colección "vino" de la base de datos
        database.getCollection("vino").insertOne(vino1);
        database.getCollection("vino").insertOne(vino2);
        database.getCollection("vino").insertOne(vino3);
        database.getCollection("vino").insertOne(vino4);
        database.getCollection("vino").insertOne(vino5);
        database.getCollection("vino").insertOne(vino6);
        database.getCollection("vino").insertOne(vino7);
        database.getCollection("vino").insertOne(vino8);
        database.getCollection("vino").insertOne(vino9);
        database.getCollection("vino").insertOne(vino10);

        // Cierra la conexión con la base de datos
        mongoClient.close();

    }
}

