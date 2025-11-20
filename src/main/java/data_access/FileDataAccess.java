package data_access;

import adventure_game.entity.AdventureGame;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataAccess {
    private static final String FILE_PATH = "userdata.json";

    public FileDataAccess() {
    }

    // Save ANY object to JSON (more flexible)
    public <T> void save(T data) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            if (data instanceof AdventureGame) {
                ((AdventureGame) data).toJSON().write(writer, 4, 0);
            } else {
                // Fallback for other objects
                new JSONObject(data).write(writer, 4, 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data of specified type
    @SuppressWarnings("unchecked")
    public <T> T load(Class<T> clazz) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject json = new JSONObject(tokener);

            if (clazz.equals(AdventureGame.class)) {
                return (T) AdventureGame.fromJSON(json);
            }

            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}