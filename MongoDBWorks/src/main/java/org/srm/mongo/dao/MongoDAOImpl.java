package org.srm.mongo.dao;

import java.util.List;

import org.bson.Document;
import org.srm.mongo.connection.MongoConnection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author ANBU
 * 
 */

public class MongoDAOImpl implements MongoDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.srm.mongo.dao.MongoDAO#insertOne(org.bson.Document,
	 * com.mongodb.client.MongoCollection)
	 */
	@Override
	public void insertOne(Document document, MongoCollection<Document> mongoCollection) {
		mongoCollection.insertOne(document);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.srm.mongo.dao.MongoDAO#insertMany(java.util.List,
	 * com.mongodb.client.MongoCollection)
	 */
	@Override
	public void insertMany(List<Document> documents, MongoCollection<Document> mongoCollection) {
		mongoCollection.insertMany(documents);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.srm.mongo.dao.MongoDAO#getMongoDataBase(java.lang.String)
	 */
	@Override
	public MongoDatabase getMongoDataBase(String database) {
		return MongoConnection.getMongoConnnection().getDatabase(database);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.srm.mongo.dao.MongoDAO#createMongoCollection(java.lang.String,
	 * com.mongodb.client.MongoDatabase)
	 */
	@Override
	public void createMongoCollection(String collection, MongoDatabase mongoDatabase) {
		mongoDatabase.createCollection(collection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.srm.mongo.dao.MongoDAO#getMongoCollection(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public MongoCollection<Document> getMongoCollection(String database, String collection) {
		return getMongoDataBase(database).getCollection(collection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.srm.mongo.dao.MongoDAO#update(com.mongodb.client.MongoCollection,
	 * org.bson.Document, org.bson.Document)
	 */
	@Override
	public void updateOne(MongoCollection<Document> mongoCollection, Document filter, Document newData) {
		mongoCollection.updateOne(filter, newData);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.srm.mongo.dao.MongoDAO#delete(com.mongodb.client.MongoCollection,
	 * org.bson.Document)
	 */
	@Override
	public void deleteOne(MongoCollection<Document> mongoCollection, Document condition) {
		mongoCollection.deleteOne(condition);
	}

}
