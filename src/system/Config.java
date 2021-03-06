package system;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
    public static JSONObject siteSelectorsJSON;
    public static String home_path = System.getProperty("user.home");
    public static String home_folder = "Novel-Grabber";
    public static String JSON_Link = "https://raw.githubusercontent.com/Flameish/Novel-Grabber/master/src/files/siteSelector.json";
    public static String config_file_path = home_path+ File.separator + home_folder + File.separator + "config.json";
    public static JSONObject data = new JSONObject();

    public static void readConfig() throws ParseException {
        try(BufferedReader reader = new BufferedReader(new FileReader(Config.config_file_path))) {
            data = (JSONObject) new JSONParser().parse(reader);
        } catch(IOException e) {
            System.out.println("[INFO]No config file found at: "+Config.config_file_path);
        }
    }

    public static void saveConfig() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(Config.config_file_path))) {
            writer.write(data.toJSONString());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkConfigFolder() throws IOException {
        Path path = Paths.get(home_path);
        if (Files.isDirectory(path) && Files.exists(path)) {
            Path myFolder = path.resolve(home_folder);
            if (Files.notExists(myFolder)) {
                Files.createDirectory(myFolder);
            }
        }
    }

    public static void fetchSelectors() {
        try {
            System.out.println("[INFO]Fetching latest selector JSON...");
            Document doc = Jsoup.connect(JSON_Link).timeout(30 * 1000).get();
            String JSONString = doc.select("body").first().text();
            Object obj = new JSONParser().parse(JSONString);
            siteSelectorsJSON = (JSONObject) obj;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
