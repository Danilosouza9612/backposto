package com.meuposto.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuposto.model.NoSQLQuery7;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ConexaoNoSQL {
	private MongoCollection<Document> collection;
	
	public ConexaoNoSQL(String collection) {
		MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase db = client.getDatabase("posto");
		this.collection = db.getCollection(collection);
	}
	public void insertList(List<?> list) {
		list.forEach(item->{
			this.insert(item);
		});
	}
	public void insert(Object item) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			collection.insertOne(Document.parse(mapper.writeValueAsString(item)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	public List<NoSQLQuery7> toFind(Bson query) {
		List<NoSQLQuery7> list = new ArrayList<NoSQLQuery7>();
		MongoCursor<Document> documents =  collection.find(query).iterator();
		ObjectMapper mapper = new ObjectMapper();
		documents.forEachRemaining(document->{
			try {
				list.add(mapper.readValue(document.toJson(), NoSQLQuery7.class));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		return list;
		
	}
	public void update(Bson query, Bson update) {
		this.collection.updateMany(query, update);
	}
	public long getCount() {
		return collection.count();
	}
}
