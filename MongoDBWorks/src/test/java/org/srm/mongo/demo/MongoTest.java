package org.srm.mongo.demo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bson.Document;
import org.junit.Test;
import org.srm.mongo.utils.MongoDBervice;

/**
 * @author ANBU
 * 
 */
public class MongoTest {

	private MongoDBervice mongoDBervice = new MongoDBervice();

	@Test
	public void insertSingleDocument() {

		Map employee = new TreeMap();
		employee.put("name", "Kalaiarasan");
		employee.put("dob", new Date());

		Document document = new Document(employee);

		mongoDBervice.insertOne("EmployeeDB", "Employee", document);
	}

	@Test
	public void insertMultipleDocuments() {

		Map employee1 = new TreeMap();
		employee1.put("name", "Kalaiarasan1");
		employee1.put("dob", new Date());

		Map employee2 = new TreeMap();
		employee2.put("name", "Kalaiarasan2");
		employee2.put("dob", new Date());

		Map employee3 = new TreeMap();
		employee3.put("name", "Kalaiarasan3");
		employee3.put("dob", new Date());

		Document document1 = new Document(employee1);
		Document document2 = new Document(employee2);
		Document document3 = new Document(employee3);

		List<Document> documents = new LinkedList<Document>();
		documents.add(document1);
		documents.add(document2);
		documents.add(document3);

		mongoDBervice.insertMany("EmployeeDB", "Employee", documents);
	}

	@Test
	public void updateOneDocument() {
		mongoDBervice.updateOne("EmployeeDB", "Employee", new Document("name", "Kalaiarasan"),
				new Document("$set", new Document("name", "Anbarasan")));
	}

	@Test
	public void deleteOne() {
		mongoDBervice.deleteOne("EmployeeDB", "Employee", new Document("name", "Kalaiarasan3"));

	}

}
