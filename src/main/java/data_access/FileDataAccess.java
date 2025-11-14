package data_access;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataAccess {
    private static final String FILE_PATH = "userdata.json";
    private final Gson gson;

    public FileDataAccess() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Save ANY object to JSON (more flexible)
    public <T> void save(T data) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data of specified type
    public <T> T load(Class<T> clazz) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}