package org.srm.mongo.utils;

import java.util.List;

import org.bson.Document;
import org.srm.mongo.dao.MongoDAO;
import org.srm.mongo.dao.MongoDAOImpl;

import com.mongodb.client.MongoCollection;

/**
 * @author ANBU
 * 
 */

public class MongoDBervice {

	private MongoDAO mongoDAO;

	public MongoDBervice() {
		this.mongoDAO = new MongoDAOImpl();
	}

	/**
	 * @param databaseName
	 * @param collectionName
	 * @param document
	 */

	public void insertOne(String databaseName, String collectionName, Document document) {
		MongoCollection<Document> mongoCollection = mongoDAO.getMongoCollection(databaseName, collectionName);
		if (mongoCollection != null) {
			mongoDAO.insertOne(document, mongoCollection);
		}
	}

	/**
	 * @param databaseName
	 * @param collectionName
	 * @param documents
	 */

	public void insertMany(String databaseName, String collectionName, List<Document> documents) {
		MongoCollection<Document> mongoCollection = mongoDAO.getMongoCollection(databaseName, collectionName);
		if (mongoCollection != null) {
			mongoDAO.insertMany(documents, mongoCollection);
		}
	}

	/**
	 * @param databaseName
	 * @param collectionName
	 * @param filter
	 * @param newData
	 */
	public void updateOne(String databaseName, String collectionName, Document filter, Document newData) {
		MongoCollection<Document> mongoCollection = mongoDAO.getMongoCollection(databaseName, collectionName);
		if (mongoCollection != null) {
			mongoDAO.updateOne(mongoCollection, filter, newData);
		}
	}

	/**
	 * @param databaseName
	 * @param collectionName
	 * @param condition
	 */
	public void deleteOne(String databaseName, String collectionName, Document condition) {
		MongoCollection<Document> mongoCollection = mongoDAO.getMongoCollection(databaseName, collectionName);
		if (mongoCollection != null) {
			mongoDAO.deleteOne(mongoCollection, condition);
		}
	}
}
