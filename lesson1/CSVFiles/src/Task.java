import java.io.*;
import java.util.Arrays;

public class Task {
    public static void main(String[] ar) {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris.data");
    }

    public Database readCSV(String filename) {
        String contents = "";
        try (InputStream in = new FileInputStream(filename)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String eachline;
            while ((eachline = br.readLine()) != null) {
                contents = contents + eachline + "\n";
            }
//            System.out.println(contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Database(contents);
    }
}