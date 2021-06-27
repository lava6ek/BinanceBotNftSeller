package utils.jsonUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *для успешного преобразования нужно Pojo - геттеры, сеттеры и конструктор по умолячанию
 *
 * Зависимости:
 *          <dependency>
 *             <groupId>org.json</groupId>
 *             <artifactId>json</artifactId>
 *             <version>20190722</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>com.fasterxml.jackson.core</groupId>
 *             <artifactId>jackson-core</artifactId>
 *             <version>2.10.0</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>com.fasterxml.jackson.core</groupId>
 *             <artifactId>jackson-databind</artifactId>
 *             <version>2.10.0</version>
 *         </dependency>
 */
public class JsonUtils {

    public static String objectToJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Object jsonToObject(String json, Class myClass){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object o = objectMapper.readValue(json,myClass);
            return o;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
