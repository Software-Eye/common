package org.softwareeyes.common.clients;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class SoftwareEyesMongoClient implements AutoCloseable {
    private final MongoClient mongoClient;
    private final String databaseName;

    public SoftwareEyesMongoClient(String connectionString, String databaseName){
        MongoClientOptions.Builder clientOptions = MongoClientOptions.builder().codecRegistry(buildPojoCodecRegistry());
        MongoClientURI uri = new MongoClientURI(connectionString, clientOptions);
        this.databaseName = databaseName;
        this.mongoClient = new MongoClient(uri);
    }

    public <TDocument> MongoCollection<TDocument> getQuerier(Class<TDocument> documentClass, String collectionName){
        return mongoClient.getDatabase(databaseName).getCollection(collectionName, documentClass);
    }

    public MongoCollection<Document> getQuerier(String collectionName){
        return mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    @Override
    public void close() throws Exception {
        mongoClient.close();
    }


    private CodecRegistry buildPojoCodecRegistry(){
        return fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().register("org.softwareeyes.common").automatic(true).build()));
    }

}