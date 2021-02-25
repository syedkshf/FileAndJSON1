import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

public class Task {
  public static void main(String[] args){
      Task t = new Task();
      JsonObject doc = t.readJson("./resources/restaurant-data.json");


     Database db = new Database(doc);
//     System.out.println(db.getRestaurant("Hometown BBQ"));
     System.out.println(db.getAvgReviews("Casa Enrique"));
  }


  public JsonObject readJson(String filename) {
      Task t1 = new Task();
      String d = t1.readFile("./resources/restaurant-data.json");
      JsonObject document = Jsoner.deserialize(d,new JsonObject());

      return document;
  }

  public String readFile(String filename){
      String content = "";
      try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
          String eachline;
          while ((eachline = reader.readLine()) != null) {
              content = content + eachline + "\n";
          }

      } catch(IOException e) {
          e.printStackTrace();
          System.exit(-1);
      }
      return content;
  }
}