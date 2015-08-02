package org.srm.mongo.dao;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author ANBU
 * 
 */

public interface MongoDAO {

	public void insertOne(Document document, MongoCollection<Document> mongoCollection);

	public void insertMany(List<Document> documents, MongoCollection<Document> mongoCollection);

	public MongoDatabase getMongoDataBase(String database);

	public void createMongoCollection(String collection, MongoDatabase mongoDatabase);

	public MongoCollection<Document> getMongoCollection(String database, String collection);

	public void updateOne(MongoCollection<Document> mongoCollection, Document filter, Document newData);

	public void deleteOne(MongoCollection<Document> mongoCollection, Document condition);

}
