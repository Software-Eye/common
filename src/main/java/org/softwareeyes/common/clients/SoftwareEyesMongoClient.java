package org.softwareeyes.common.clients;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Map;

public class SoftwareEyesMongoClient implements AutoCloseable {
    private MongoClient mongoClient;
    private String databaseName;
    private String collectionName ;

    public SoftwareEyesMongoClient(String connectionString, String databaseName, String collectionName){
        MongoClientURI uri = new MongoClientURI(connectionString);
        this.databaseName = databaseName;
        this.collectionName = collectionName;
        this.mongoClient = new MongoClient(uri);
    }

    public MongoCollection<Document> getQuerier(){
        return mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public static Document convertObjectToDocument(Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.convertValue(obj, Map.class);
        return new Document(map);
    }
    @Override
    public void close() throws Exception {
        mongoClient.close();
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}