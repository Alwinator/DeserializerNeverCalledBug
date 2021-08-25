package at.alwinschuster;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArrayTrimDeserializer extends StdDeserializer<String[]> {

    protected ArrayTrimDeserializer() {
        super(String[].class);
    }

    @Override
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        System.out.println("FILTER USED!");

        JsonNode array = deserializationContext.readTree(jsonParser);
        List<String> filtered = new ArrayList<>();

        for(JsonNode node : array){
            String str = node.textValue();
            if(!str.isBlank()){
                filtered.add(str);
            }
        }

        return filtered.toArray(new String[0]);
    }
}

