package VoIP.Database;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MongoDB {
    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        String connectionString = "";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Make connection to the databse
            MongoDatabase testDB = mongoClient.getDatabase("Test_DB");

            // Get the required "collection"
            MongoCollection<Document> myCollection = testDB.getCollection("Test_Collection");

            // Save the required query in a "Document" object
            Document user = myCollection.find(new Document("username", "Willem")).first();

            // Print the user
            System.out.println("Queried user: " + user.toJson());
        }
    }
}
