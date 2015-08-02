package org.srm.mongo.connection;

import org.srm.mongo.constants.MongoConstants;

import com.mongodb.MongoClient;

/**
 * @author ANBU
 * 
 */
public class MongoConnection {

	private static MongoClient mongoClient;

	public static MongoClient getMongoConnnection() {
		if (mongoClient == null) {
			synchronized (MongoConnection.class) {
				mongoClient = new MongoClient(MongoConstants.HOST, MongoConstants.PORT);
			}
		}
		return mongoClient;
	}
}
