package xyz.kacperm.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Mongo {

    private final String uri;
    private MongoDatabase database;

    public Mongo(String uri) {
        this.uri = uri;
    }

    public void connect() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
        database = mongoClient.getDatabase("school_database");
        if (getCollection() == null) {
            database.createCollection("school");
        }
    }

    public MongoCollection<Document> getCollection(){
        return this.database.getCollection("school");
    }
}
