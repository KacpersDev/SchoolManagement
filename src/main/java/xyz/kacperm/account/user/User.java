package xyz.kacperm.account.user;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import xyz.kacperm.Main;
import xyz.kacperm.account.Account;

public class User implements Account {

    @Override
    public boolean validate(String username, String password) {
        MongoCollection<Document> collection = Main.mongoHandler.getCollection();
        Document document = collection.find(Filters.eq("user", username)).first();
        return document != null;
    }

    @Override
    public void register(String username, String password) {
        Document document = new Document();
        document.put("user", username);
        document.put("password", password);
        Main.mongoHandler.getCollection().replaceOne(Filters.eq("user", username), document, new UpdateOptions().upsert(true));
    }
}
