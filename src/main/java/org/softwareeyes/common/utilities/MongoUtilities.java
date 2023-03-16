package org.softwareeyes.common.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;

import java.util.Map;

public class MongoUtilities {
    public static Document convertObjectToDocument(Object objectToConvert){
        ObjectMapper objectMapper = new ObjectMapper();
        Map objectMap = objectMapper.convertValue(objectToConvert, Map.class);
        return new Document(objectMap);
    }

}
