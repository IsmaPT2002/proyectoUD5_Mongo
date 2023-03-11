package Generar;

import com.mongodb.client.MongoClients; // importa la clase MongoClients del paquete com.mongodb.client
import com.mongodb.client.MongoClient; // importa la interfaz MongoClient del paquete com.mongodb.client
import com.mongodb.client.MongoDatabase; // importa la clase MongoDatabase del paquete com.mongodb.client
import org.bson.Document; // importa la clase Document del paquete org.bson
import org.bson.types.ObjectId; // importa la clase ObjectId del paquete org.bson.types
import java.util.Arrays; // importa la clase Arrays del paquete java.util

public class GenerarBodegas {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create(); // crea una instancia de MongoClient
        MongoDatabase database = mongoClient.getDatabase("vinos"); // obtiene la base de datos "vinos" de MongoDB

        // crea un objeto Document que representa una bodega de vino con sus respectivos vinos y calificaciones
        Document bodega1 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a12b"))
                .append("nombre", "Bodega Rioja")
                .append("direccion", "Calle Rioja, 1, 28001 Madrid")
                .append("anhoFundacion", "1970-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Cabernet Sauvignon")
                        .append("bodega", new Document("nombre", "Rioja Reserva 2001")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 10)
                                                .append("comentario", "Tremendo vino."),
                                        new Document("puntuacion", 9)
                                                .append("comentario", "Buen equilibrio de sabores.")
                                ))
                        ));

        // crea más objetos Document que representan bodegas de vino con sus respectivos vinos y calificaciones
        Document bodega2 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a12c"))
                .append("nombre", "Bodega Norton")
                .append("direccion", "Ruta 15 km 23,5, Luján de Cuyo, Mendoza")
                .append("anhoFundacion", "1980-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Malbec Reserva 2010")
                        .append("bodega", new Document("nombre", "Bodega Norton")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 8)
                                                .append("comentario", "Un buen vino, pero un poco ácido para mi gusto."),
                                        new Document("puntuacion", 7)
                                                .append("comentario", "Le falta un poco de cuerpo.")
                                ))
                        ));

        Document bodega3 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a12d"))
                .append("nombre", "Bodega Catena Zapata")
                .append("direccion", "Cobos s/n, Luján de Cuyo, Mendoza")
                .append("anhoFundacion", "1990-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Chardonnay 2015")
                        .append("bodega", new Document("nombre", "Bodega Catena Zapata")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 9)
                                                .append("comentario", "Excelente vino, gran sabor.")
                                ))
                        ));

        Document bodega4 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a12e"))
                .append("nombre", "Bodega Bressia")
                .append("direccion", "Montecaseros 2635, Agrelo, Mendoza")
                .append("anhoFundacion", "2000-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Cabernet Franc 2018")
                        .append("bodega", new Document("nombre", "Bodega Bressia")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 9)
                                                .append("comentario", "Perfecto para una cena especial.")
                                ))));

        Document bodega5 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a12f"))
                .append("nombre", "Bodega Chandon")
                .append("direccion", "Ruta Provincial 15, km 29, Agrelo, Mendoza")
                .append("anhoFundacion", "2010-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Pinot Noir 2016")
                        .append("bodega", new Document("nombre", "Bodega Chandon")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 8)
                                                .append("comentario", "Buen vino, pero un poco suave para mi gusto.")
                                ))));

        Document bodega6 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a129"))
                .append("nombre", "Bodega Norton")
                .append("direccion", "Ruta 15 km 23,5, Luján de Cuyo, Mendoza")
                .append("anhoFundacion", "1980-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Syrah Reserva 2015")
                        .append("bodega", new Document("nombre", "Bodega Norton")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 8)
                                                .append("comentario", "Un poco caro, pero vale la pena.")
                                ))));

        Document bodega7 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a128"))
                .append("nombre", "Bodega Salentein")
                .append("direccion", "Ruta Provincial 89, s/n, Tupungato, Mendoza")
                .append("anhoFundacion", "1965-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Sauvignon Blanc 2019")
                        .append("bodega", new Document("nombre", "Bodega Salentein")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 8)
                                                .append("comentario", "Refrescante y fácil de beber.")
                                ))));

        Document bodega8 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a127"))
                .append("nombre", "Bodega Luigi Bosca")
                .append("direccion", "San Martín 2044, Mayor Drummond, Luján de Cuyo, Mendoza")
                .append("anhoFundacion", "1975-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Malbec Reserva 2012")
                        .append("bodega", new Document("nombre", "Bodega Luigi Bosca")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 9)
                                                .append("comentario", "Excelente vino, con un gran sabor y cuerpo.")

                                ))));

        Document bodega9 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a126"))
                .append("nombre", "Champagne Bollinger")
                .append("direccion", "16 Rue Jules Lobet, 51160 Aÿ-Champagne, Francia")
                .append("anhoFundacion", "1987-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Champagne Brut Nature")
                        .append("bodega", new Document("nombre", "Champagne Bollinger")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 8)
                                                .append("comentario", "Un poco más seco de lo que esperaba, pero sigue siendo un buen champagne.")
                                ))));

        Document bodega10 = new Document("_id", new ObjectId("640b18f5f369c3cda9a3a125"))
                .append("nombre", "Weingut Max Ferd. Richter")
                .append("direccion", "Hauptstraße 37, 54492 Mulheim, Alemania")
                .append("anhoFundacion", "1989-04-01T00:00:00.000Z")
                .append("vino", new Document("nombre", "Riesling Kabinett 2019")
                        .append("bodega", new Document("nombre", "Weingut Max Ferd. Richter")
                                .append("calificaciones", Arrays.asList(
                                        new Document("puntuacion", 7)
                                                .append("comentario", "Un poco demasiado dulce para mi gusto, pero sigue siendo un buen Riesling.")
                                ))));

        // Inserta cada documento de bodega en la colección "bodega" de la base de datos
        database.getCollection("bodega").insertOne(bodega1);
        database.getCollection("bodega").insertOne(bodega2);
        database.getCollection("bodega").insertOne(bodega3);
        database.getCollection("bodega").insertOne(bodega4);
        database.getCollection("bodega").insertOne(bodega5);
        database.getCollection("bodega").insertOne(bodega6);
        database.getCollection("bodega").insertOne(bodega7);
        database.getCollection("bodega").insertOne(bodega8);
        database.getCollection("bodega").insertOne(bodega9);
        database.getCollection("bodega").insertOne(bodega10);

        // Cierra la conexión con la base de datos
        mongoClient.close();

    }
}
