package Generar; // Importa el paquete Generar

import com.mongodb.client.MongoClients; // Importa la clase MongoClient del paquete com.mongodb.client
import com.mongodb.client.MongoClient; // Importa la clase MongoClient del paquete com.mongodb.client
import com.mongodb.client.MongoDatabase; // Importa la clase MongoDatabase del paquete com.mongodb.client
import org.bson.Document; // Importa la clase Document del paquete org.bson
import org.bson.types.ObjectId; // Importa la clase ObjectId del paquete org.bson.types
import java.util.Arrays; // Importa la clase Arrays del paquete java.util

public class GenerarUsuarios { // Declara la clase GenerarUsuarios

    public static void main(String[] args) { // Declara el método principal main que toma un arreglo de cadenas como argumento

        MongoClient mongoClient = MongoClients.create(); // Crea una instancia de MongoClient
        MongoDatabase database = mongoClient.getDatabase("vinos"); // Obtiene una referencia a la base de datos "vinos"

        // Crea el primer documento de usuario
        Document usuario1 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a121"))
                .append("idUsuario", 1)
                .append("email", "usuario1@gmail.com")
                .append("nombre", "Usuario1")
                .append("password", "mypassword1")
                .append("fechaNacimiento", "1985-05-15")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b030"))
                                .append("valoracion", 10)
                                .append("comentario", "Tremendo vino.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a120"))
                                        .append("nombre", "Rioja Reserva 2001")
                                        .append("bodega", "Bodeja Rioja"))
                ));

        //Crea más documentos de usuario, con la misma estructura que el anterior
        Document usuario2 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a122"))
                .append("idUsuario", 2)
                .append("email", "usuario2@gmail.com")
                .append("nombre", "Usuario2")
                .append("password", "mypassword2")
                .append("fechaNacimiento", "1975-15-15")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b031"))
                                .append("valoracion", 9)
                                .append("comentario", "Buen equilibrio de sabores.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a120"))
                                        .append("nombre", "Rioja Reserva 2001")
                                        .append("bodega", "Bodeja Rioja"))
                ));

        Document usuario3 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a123"))
                .append("idUsuario", 3)
                .append("email", "usuario3@gmail.com")
                .append("nombre", "Usuario3")
                .append("password", "mypassword3")
                .append("fechaNacimiento", "1964-02-05")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b032"))
                                .append("valoracion", 8)
                                .append("comentario", "Un buen vino, pero un poco ácido para mi gusto.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a121"))
                                        .append("nombre", "Malbec Reserva 2010")
                                        .append("bodega", "Bodega Norton"))
                ));

        Document usuario4 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a124"))
                .append("idUsuario", 4)
                .append("email", "usuario4@gmail.com")
                .append("nombre", "Usuario4")
                .append("password", "mypassword4")
                .append("fechaNacimiento", "1885-08-15")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b033"))
                                .append("valoracion", 7)
                                .append("comentario", "Le falta un poco de cuerpo.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a121"))
                                        .append("nombre", "Malbec Reserva 2010")
                                        .append("bodega", "Bodega Norton"))
                ));

        Document usuario5 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a125"))
                .append("idUsuario", 5)
                .append("email", "usuario5@gmail.com")
                .append("nombre", "Usuario5")
                .append("password", "mypassword5")
                .append("fechaNacimiento", "1995-05-09")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b033"))
                                .append("valoracion", 7)
                                .append("comentario", "Le falta un poco de cuerpo.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a121"))
                                        .append("nombre", "Malbec Reserva 2010")
                                        .append("bodega", "Bodega Norton"))
                ));

        Document usuario6 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a126"))
                .append("idUsuario", 6)
                .append("email", "usuario6@gmail.com")
                .append("nombre", "Usuario6")
                .append("password", "mypassword6")
                .append("fechaNacimiento", "1986-03-11")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b035"))
                                .append("valoracion", 9)
                                .append("comentario", "Perfecto para una cena especial.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a123"))
                                        .append("nombre", "Cabernet Franc 2018")
                                        .append("bodega", "Bodega Bressia"))
                ));

        Document usuario7 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a127"))
                .append("idUsuario", 7)
                .append("email", "usuario7@gmail.com")
                .append("nombre", "Usuario7")
                .append("password", "mypassword7")
                .append("fechaNacimiento", "1982-02-12")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b036"))
                                .append("valoracion", 8)
                                .append("comentario", "Buen vino, pero un poco suave para mi gusto.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a124"))
                                        .append("nombre", "Pinot Noir 2016")
                                        .append("bodega", "Bodega Chandon"))
                ));

        Document usuario8 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a128"))
                .append("idUsuario", 8)
                .append("email", "usuario8@gmail.com")
                .append("nombre", "Usuario8")
                .append("password", "mypassword8")
                .append("fechaNacimiento", "1980-01-11")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b037"))
                                .append("valoracion", 8)
                                .append("comentario", "Un poco caro, pero vale la pena.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a125"))
                                        .append("nombre", "Syrah Reserva 2015")
                                        .append("bodega", "Bodega Norton")),
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b038"))
                                .append("valoracion", 8)
                                .append("comentario", "Refrescante y fácil de beber.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a126"))
                                        .append("nombre", "Sauvignon Blanc 2019")
                                        .append("bodega", "Bodega Salentein"))
                ));

        Document usuario9 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a129"))
                .append("idUsuario", 9)
                .append("email", "usuario9@gmail.com")
                .append("nombre", "Usuario9")
                .append("password", "mypassword9")
                .append("fechaNacimiento", "1967-09-01")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b039"))
                                .append("valoracion", 9)
                                .append("comentario", "Excelente vino, con un gran sabor y cuerpo.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a127"))
                                        .append("nombre", "Malbec Reserva 2012")
                                        .append("bodega", "Bodega Luigi Bosca"))
                ));

        Document usuario10 = new Document("_id", new ObjectId("640b16a1f369c3cda9a3a130"))
                .append("idUsuario", 10)
                .append("email", "usuario10@gmail.com")
                .append("nombre", "Usuario10")
                .append("password", "mypassword10")
                .append("fechaNacimiento", "2000-07-12")
                .append("calificacion", Arrays.asList(
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b010"))
                                .append("valoracion", 8)
                                .append("comentario", "Un poco más seco de lo que esperaba, pero sigue siendo un buen champagne.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a128"))
                                        .append("nombre", "Champagne Brut Nature")
                                        .append("bodega", "Champagne Bollinger")),
                        new Document("_id", new ObjectId("5c82b53e94f5ba5b9829b011"))
                                .append("valoracion", 7)
                                .append("comentario", "Un poco demasiado dulce para mi gusto, pero sigue siendo un buen Riesling.")
                                .append("vino", new Document("idVino", new ObjectId("640b0a98f369c3cda9a3a129"))
                                        .append("nombre", "Riesling Kabinett 2019")
                                        .append("bodega", "Weingut Max Ferd. Richter"))
                ));

        // Inserta cada documento de usuario en la colección "usuario" de la base de datos
        database.getCollection("usuario").insertOne(usuario1);
        database.getCollection("usuario").insertOne(usuario2);
        database.getCollection("usuario").insertOne(usuario3);
        database.getCollection("usuario").insertOne(usuario4);
        database.getCollection("usuario").insertOne(usuario5);
        database.getCollection("usuario").insertOne(usuario6);
        database.getCollection("usuario").insertOne(usuario7);
        database.getCollection("usuario").insertOne(usuario8);
        database.getCollection("usuario").insertOne(usuario9);
        database.getCollection("usuario").insertOne(usuario10);

        // Cierra la conexión con la base de datos
        mongoClient.close();

    }
}