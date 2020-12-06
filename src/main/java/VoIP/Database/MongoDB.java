package VoIP.Database;

// MongoDB imports
import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;
import java.util.logging.Logger;
import java.util.logging.Level;
// PrintOut class import
import VoIP.Misc.PrintOut;

public class MongoDB {
    // NOTE: Never Commit with a visible uri!!!!
        private static final String CONNECT_URI =
    "";

    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        if (CONNECT_URI.equals("")) {
            PrintOut.printError("Empty URI string!");
        } else {
            try (MongoClient mongoClient = MongoClients.create(CONNECT_URI)) {
                PrintOut.printInfo("Database connection success!");
            } catch (Exception e){
                PrintOut.printError("Database connection failed!");
            }
        }
    }

    public static boolean checkLoginCred(String givenUser, String givenPass) {
        boolean correctPass = false;
        boolean correctUser = false;
        if (CONNECT_URI.equals("")) {
            PrintOut.printError("Empty URI string!");
        } else {
            Document queryUser = getUser(givenUser);
            if (queryUser != null) {
                if (queryUser.get("username").equals(givenUser)) {
                    correctUser = true;
                }
                if (queryUser.get("password").equals(givenPass)) {
                    correctPass = true;
                }
            }
        }
        return (correctUser && correctPass);
    }
    private static Document getUser(String username) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        try (MongoClient mongoClient = MongoClients.create(CONNECT_URI)) {
            // Make connection to the databse
            MongoDatabase testDB = mongoClient.getDatabase("Test_DB");

            // Get the required "collection"
            MongoCollection<Document> myCollection = testDB.getCollection("Test_Collection");

            // Save the required query in a "Document" object
            Document user = myCollection.find(new Document("username", username)).first();
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
