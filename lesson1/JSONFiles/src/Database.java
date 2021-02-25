import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import java.sql.SQLOutput;

public class Database {
    public JsonObject data;

    /* TODO
Declare a member variable that can
be EASILY set from the constructor. */

    public Database(JsonObject data){
        this.data=data;
    }

    public JsonObject getRestaurant(String name){
        JsonArray rest = (JsonArray) data.get("restaurants");
        JsonObject result = new JsonObject();
      for(int i =0 ; i < rest.size(); i++)      {
          JsonObject first = (JsonObject) rest.get(i);
          String title = (String) first.get("name");
          if(title.equals(name)){
//              System.out.println(title);
               result = (JsonObject) rest.get(i);
//              System.out.println(result);
          }


      }

   return result; }

    public double getAvgReviews(String name){
         JsonObject recv = getRestaurant(name);
       // System.out.println(recv);
        JsonArray rest1 = (JsonArray) recv.get("reviews");
        //JsonObject rest1 = recv.get("reviews");
        //System.out.println(rest1);
        int rat = 0;
        for(int i =0 ; i < rest1.size(); i++)      {
            JsonObject key = (JsonObject) rest1.get(i);
            System.out.println(key);

            String s = (String) key.get("rating");

           // System.out.print(key.get("rating").getClass());
            // int rating = (int)  key.getInteger(key.get("rating"));
            //System.out.println(rating);
//            if(title.equals(name)){
////              System.out.println(title);
//                result = (JsonObject) rest1.get(i);
////              System.out.println(result);
//            }
//

//        System.out.println();




}
        return 0.0;}}
