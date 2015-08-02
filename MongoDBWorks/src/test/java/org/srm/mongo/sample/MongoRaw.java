package org.srm.mongo.sample;

import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoRaw {
	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase mongoDatabase = mongoClient.getDatabase("EmployeeDB");

		MongoCollection<Document> employee = mongoDatabase.getCollection("Employee");

		// MongoCursor<Document> cursor = employee.find(new Document("name",
		// "Kalaiarasan2")).iterator();
		// while (cursor.hasNext()) {
		// Document object = (Document) cursor.next();
		// if (object.containsValue("Kalaiarasan2"))
		// System.out.println(object);
		// }
		// employee.deleteOne(new Document("name", "Kalaiarasan2"));

		employee.updateOne(new Document("name", "Kalaiarasan"), new Document("$set", new Document("dob", new Date())));
	}
}
