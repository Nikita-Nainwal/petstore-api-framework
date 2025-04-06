package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
    public static void printPayload(Object obj){
        ObjectMapper mapper = new ObjectMapper();
         try{
            String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
             System.out.println("Payload : "  + payload);

         }
         catch(Exception e){
             e.printStackTrace();
         }
    }

}
