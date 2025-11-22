package opening_game.data_access;

import com.google.gson.Gson;
import opening_game.entity.GameState;
import opening_game.use_case.openGame.OpenGameDataAccessInterface;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OpenGameFileDataAccess implements OpenGameDataAccessInterface {

    // private static final String SAVE_FILE_PATH = "game_save.json";
    private final Gson gson = new Gson();
    private final String saveFilePath;

    public OpenGameFileDataAccess(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

    @Override
    public GameState loadGame() {
        try {
            File file = new File(saveFilePath);
            if (!file.exists()) {
                return null;
            }

            FileReader reader = new FileReader(file);
            GameState state = gson.fromJson(reader, GameState.class);
            reader.close();
            return state;

        } catch (IOException e) {
            e.printStackTrace();
            return null;  // return null on error
        }
    }

    @Override
    public void saveGame(GameState state) {
        try {
            FileWriter writer = new FileWriter(saveFilePath);
            gson.toJson(state, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveFileExists() {
        File file = new File(saveFilePath);
        return file.exists();
    }

    @Override
    public void deleteSaveFile() {
        File file = new File(saveFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
