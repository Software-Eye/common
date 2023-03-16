package org.softwareeyes.common.clients;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.softwareeyes.common.exporterConfiguration.implementation.mongodb.MongoDbExporterConfigurationParameter;
import org.softwareeyes.common.models.exporterConfiguration.ExporterConfiguration;
import org.softwareeyes.common.models.exporterConfiguration.ExporterMetadata;
import org.softwareeyes.common.models.exporterConfiguration.exporterTopology.ExporterTopology;
import org.softwareeyes.common.models.exporterConfiguration.exporterTopology.TopologyData;
import org.softwareeyes.common.models.exporterConfiguration.exporterTopology.TopologyPosition;

import javax.print.Doc;

import java.util.UUID;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class SoftwareEyesMongoClient implements AutoCloseable {
    private final MongoClient mongoClient;
    private final String databaseName;
    private String collectionName ;

    public SoftwareEyesMongoClient(String connectionString, String databaseName, String collectionName){
        MongoClientOptions.Builder clientOptions = MongoClientOptions.builder().codecRegistry(buildPojoCodecRegistry());
        MongoClientURI uri = new MongoClientURI(connectionString, clientOptions);
        this.databaseName = databaseName;
        this.collectionName = collectionName;
        this.mongoClient = new MongoClient(uri);
    }

    private CodecRegistry buildPojoCodecRegistry(){
        return fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().register("org.softwareeyes.common").automatic(true).build()));
    }

    public <TDocument> MongoCollection<TDocument> getQuerier(Class<TDocument> documentClass){
        return mongoClient.getDatabase(databaseName).getCollection(collectionName, documentClass);
    }

    public MongoCollection<Document> getQuerier(){
        return mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public static Document convertObjectToDocument(Object objectToConvert){
        ObjectMapper objectMapper = new ObjectMapper();
        Map objectMap = objectMapper.convertValue(objectToConvert, Map.class);
        return new Document(objectMap);
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