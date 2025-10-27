package Battle_System.GameAPI;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * this class is for Game API, the methods inside of this class will generate the information for Monster class.
 */
public class SrdMonsterDetail implements MonsterDetail {
    /**
     * this method will get the url for races and spells from the api
     * @return a HashMap, the keys are "spells" and "races", the values are the corresponding urls
     * @throws MonsterNotFoundException throws the exception if nothing is founded
     */
    @Override
    public HashMap<String,String> getAllResourcesURL() throws MonsterNotFoundException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url("https://www.dnd5eapi.co/api/2014")
                .addHeader("Accept", "application/json")
                .build();
        HashMap<String,String> map = new HashMap<>();
        try{
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            for (String str: responseBody.keySet()) {
               map.put(str,responseBody.getString(str));
            }
        }catch (Exception e){
            throw new MonsterNotFoundException();
        }
        return map;
    }

    /**
     * this method will get the HashMap for spells, where the keys are name of the spells and the values are the dmg
     * @return a HashMap, the keys are "spells" and "races", the values are the corresponding urls
     * @throws MonsterNotFoundException throws the exception if nothing is founded
     */
    @Override
    public HashMap<String,Integer> generateSpells() throws MonsterNotFoundException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url(String.format("https://www.dnd5eapi.co%s",getAllResourcesURL().get("spells")))
                .addHeader("Accept", "application/json")
                .build();
        HashMap<String, Integer> map = new HashMap<>();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray results = responseBody.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject spell = results.getJSONObject(i);
                String name = spell.getString("name");
                int dmg = spell.getInt("level");
                map.put(name, dmg);
            }
        } catch (Exception e) {
            throw new MonsterNotFoundException();
        }
        return map;
    }

    /**
     * this method will get an Array for races
     * @throws MonsterNotFoundException throws the exception if nothing is founded
     */
    @Override
    public String[] generateRaces() throws MonsterNotFoundException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        Request request = new Request.Builder()
                .url(String.format("https://www.dnd5eapi.co%s",getAllResourcesURL().get("races")))
                .addHeader("Accept", "application/json")
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray results = responseBody.getJSONArray("results");
            String[] list = new String[results.length()];
            for (int i = 0; i < results.length(); i++) {
                JSONObject races = results.getJSONObject(i);
                String name = races.getString("name");
                list[i] =  name;
            }
            return list;
        } catch (Exception e) {
            throw new MonsterNotFoundException();
        }
    }

}
