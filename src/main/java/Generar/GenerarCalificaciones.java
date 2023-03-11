// Importamos las clases necesarias para conectarnos y trabajar con MongoDB
package Generar;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class GenerarCalificaciones {
    public static void main(String[] args) {
        // Creamos una instancia de MongoClient para conectarnos a MongoDB
        MongoClient mongoClient = MongoClients.create();
        // Obtenemos la base de datos "vinos" en la conexión establecida
        MongoDatabase database = mongoClient.getDatabase("vinos");

        // Creamos un documento que representa una calificación de vino, con sus datos y los de su usuario y vino relacionados
        Document calificacion1 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b030"))
                .append("puntuacion", 10)
                .append("comentario", "Tremendo vino.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a120"))
                        .append("nombre", "Rioja Reserva 2001")
                        .append("bodega", "Bodeja Rioja"))
                .append("usuario", new Document("idUsuario", 1)
                        .append("nombre", "Usuario1")
                        .append("email", "usuario1@gmail.com"));

        // Creamos más documentos con datos de calificaciones adicionales, todas con la misma estructura que la primera
        Document calificacion2 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b031"))
                .append("puntuacion", 9)
                .append("comentario", "Buen equilibrio de sabores.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a120"))
                        .append("nombre", "Rioja Reserva 2001")
                        .append("bodega", "Bodeja Rioja"))
                .append("usuario", new Document("idUsuario", 2)
                        .append("nombre", "Usuario2")
                        .append("email", "usuario2@gmail.com"));

        Document calificacion3 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b032"))
                .append("puntuacion", 8)
                .append("comentario", "Un buen vino, pero un poco ácido para mi gusto.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a121"))
                        .append("nombre", "Malbec Reserva 2010")
                        .append("bodega", "Bodega Norton"))
                .append("usuario", new Document("idUsuario", 3)
                        .append("nombre", "Usuario3")
                        .append("email", "usuario3@gmail.com"));

        Document calificacion4 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b033"))
                .append("puntuacion", 7)
                .append("comentario", "Le falta un poco de cuerpo.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a121"))
                        .append("nombre", "Malbec Reserva 2010")
                        .append("bodega", "Bodega Norton"))
                .append("usuario", new Document("idUsuario", 4)
                        .append("nombre", "Usuario4")
                        .append("email", "usuario4@gmail.com"));

        Document calificacion5 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b034"))
                .append("puntuacion", 9)
                .append("comentario", "Excelente vino, gran sabor.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a122"))
                        .append("nombre", "Chardonnay 2015")
                        .append("bodega", "Bodega Catena Zapata"))
                .append("usuario", new Document("idUsuario", 5)
                        .append("nombre", "Usuario5")
                        .append("email", "usuario5@gmail.com"));

        Document calificacion6 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b035"))
                .append("puntuacion", 9)
                .append("comentario", "Perfecto para una cena especial.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a123"))
                        .append("nombre", "Cabernet Franc 2018")
                        .append("bodega", "Bodega Bressia"))
                .append("usuario", new Document("idUsuario", 6)
                        .append("nombre", "Usuario6")
                        .append("email", "usuario6@gmail.com"));

        Document calificacion7 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b036"))
                .append("puntuacion", 8)
                .append("comentario", "Buen vino, pero un poco suave para mi gusto.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a124"))
                        .append("nombre", "Pinot Noir 2016")
                        .append("bodega", "Bodega Chandon"))
                .append("usuario", new Document("idUsuario", 7)
                        .append("nombre", "Usuario7")
                        .append("email", "usuario7@gmail.com"));

        Document calificacion8 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b037"))
                .append("puntuacion", 8)
                .append("comentario", "Un poco caro, pero vale la pena.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a125"))
                        .append("nombre", "Syrah Reserva 2015")
                        .append("bodega", "Bodega Norton"))
                .append("usuario", new Document("idUsuario", 8)
                        .append("nombre", "Usuario8")
                        .append("email", "usuario8@gmail.com"));

        Document calificacion9 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b038"))
                .append("puntuacion", 8)
                .append("comentario", "Refrescante y fácil de beber.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a126"))
                        .append("nombre", "Sauvignon Blanc 2019")
                        .append("bodega", "Bodega Salentein"))
                .append("usuario", new Document("idUsuario", 8)
                        .append("nombre", "Usuario8")
                        .append("email", "usuario8@gmail.com"));

        Document calificacion10 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b039"))
                .append("puntuacion", 9)
                .append("comentario", "Excelente vino, con un gran sabor y cuerpo.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a127"))
                        .append("nombre", "Malbec Reserva 2012")
                        .append("bodega", "Bodega Luigi Bosca"))
                .append("usuario", new Document("idUsuario", 9)
                        .append("nombre", "Usuario9")
                        .append("email", "usuario9@gmail.com"));

        Document calificacion11 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b010"))
                .append("puntuacion", 8)
                .append("comentario", "Un poco más seco de lo que esperaba, pero sigue siendo un buen champagne.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a128"))
                        .append("nombre", "Champagne Brut Nature")
                        .append("bodega", "Champagne Bollinger"))
                .append("usuario", new Document("idUsuario", 10)
                        .append("nombre", "Usuario10")
                        .append("email", "usuario10@gmail.com"));

        Document calificacion12 = new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b011"))
                .append("puntuacion", 7)
                .append("comentario", "Un poco demasiado dulce para mi gusto, pero sigue siendo un buen Riesling.")
                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a129"))
                        .append("nombre", "Riesling Kabinett 2019")
                        .append("bodega", "Weingut Max Ferd. Richter"))
                .append("usuario", new Document("idUsuario", 10)
                        .append("nombre", "Usuario10")
                        .append("email", "usuario10@gmail.com"));

        // Se llama a la función "generarVinos" con la base de datos y las primeras 6 calificaciones como argumentos.
        generarVinos(database, calificacion1, calificacion2, calificacion3, calificacion4, calificacion5, calificacion6);
        // Se llama a la función "generarVinos" con la base de datos y las siguientes 6 calificaciones como argumentos.
        generarVinos(database, calificacion7, calificacion8, calificacion9, calificacion10, calificacion11, calificacion12);

    }

    // Función que inserta las calificaciones en la colección "calificacion".
    private static void generarVinos(MongoDatabase database, Document calificacion1, Document calificacion2, Document calificacion3, Document calificacion4, Document calificacion5, Document calificacion6) {
        database.getCollection("calificacion").insertOne(calificacion1);
        database.getCollection("calificacion").insertOne(calificacion2);
        database.getCollection("calificacion").insertOne(calificacion3);
        database.getCollection("calificacion").insertOne(calificacion4);
        database.getCollection("calificacion").insertOne(calificacion5);
        database.getCollection("calificacion").insertOne(calificacion6);
    }
}


