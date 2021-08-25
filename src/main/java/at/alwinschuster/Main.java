package at.alwinschuster;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(String[].class, new ArrayTrimDeserializer());
        mapper.registerModule(module);

        System.out.println("------------------ TESTS START --------------------");
        test1(mapper);
        test2(mapper);
        System.out.println("------------------- TESTS END ---------------------");
    }

    private static void test1(ObjectMapper mapper) throws JsonProcessingException {
        System.out.println("---------------------- Test1 ----------------------");
        // {"something": "Hello", "myArray": ["Hello", "Test", "", "Hi", ""]}
        String json = "{\"something\": \"Hello\", \"myArray\": [\"Hello\", \"Test\", \"\", \"Hi\", \"\"]}";

        MyObject obj = mapper.readValue(json, MyObject.class);
        System.out.println(obj);
        System.out.println("SUCCEEDS - It works with String[]");
    }

    private static void test2(ObjectMapper mapper) throws JsonProcessingException {
        System.out.println("---------------------- Test2 ----------------------");
        // {"something": "Hello", "myList": ["Hello", "Test", "", "Hi", ""]}
        String json = "{\"something\": \"Hello\", \"myList\": [\"Hello\", \"Test\", \"\", \"Hi\", \"\"]}";

        MyObject2 obj = mapper.readValue(json, MyObject2.class);
        System.out.println(obj);
        System.out.println("FAILED - still blank strings in List");
    }
}
