import org.json.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;


public class SpringApi {

    String apiUrl = "http://localhost:8080";
    RestTemplate restTemplate = new RestTemplate();
    public void getViewable() {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl + "/", String.class);
        System.out.println(response);
        System.out.println(response.getBody());

        //JSONArray objectArray = new JSONArray(Objects.requireNonNull(response.getBody()));


        JSONArray JA = new JSONArray(Objects.requireNonNull(response.getBody()));
//        String[] array = (String[]) response.getBody().lines().toArray();


//        for(int i = 0; i < 5; i++){
//            JA.put(Array.get(response.getBody(), i));
//        }


        System.out.println(JA.get(3));

        //JSONObject jso = (JSONObject) parse.parse(response.getBody());

        //JSONArray array = new JSONArray(Objects.requireNonNull(response.getBody()));



        //System.out.println(array.getJSONObject(1).getString("description"));

//        Post post = restTemplate.getForObject(apiUrl + "/", Post.class);
//
//        assert post != null;
//        String description = post.getDescription();


    }
}
