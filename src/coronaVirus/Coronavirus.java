/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaVirus;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import latest.Latest;
import location.Location;
import location.Locations;

public class Coronavirus {
    private static final String BASE_URL = "https://coronavirus-tracker-api.herokuapp.com/v2/";
    private static final Gson gson = new Gson();

    /**
     * @return Object containing just the key real-time Coronavirus data.
     * @throws IOException error connecting to API.
     */
    public Latest getLatest() throws IOException {
        return gson.fromJson(getCoronaJson("latest"), Latest.class);
    }

    
    public Latest getLatest(String source) throws IOException {
        return gson.fromJson(getCoronaJson("latest?source=" + source), Latest.class);
    }

    /**
     * @return ArrayList of real-time Coronavirus data for all locations.
     * @throws IOException error connecting to the API.
     */
    public ArrayList<Location> getLocations() throws IOException {
        return getLocationsList("locations");
    }

    
    public ArrayList<Location> getLocations(String source) throws IOException {
        return getLocationsList("locations");
    }

    
    public Locations getLocationsByCountry(String country) throws IOException {
        return gson.fromJson(getCoronaJson("locations?country=" + country), Locations.class);
    }

    
    public Locations getLocationsByCountryCode(String countryCode) throws IOException {
        return gson.fromJson(getCoronaJson("locations?country_code=" + countryCode.toUpperCase()), Locations.class);
    }

    public Locations getLocationsByProvince(String province) throws IOException {
        return gson.fromJson(getCoronaJson("locations?province=" + province), Locations.class);
    }

    public Location getLocationById(int id) throws IOException {
        return gson.fromJson(getCoronaJson("locations/" + id), Location.class);
    }

    private static ArrayList<Location> getLocationsList(String endpoint) throws IOException {
        JsonArray jsonArray = getCoronaJson(endpoint).getAsJsonArray("locations");
        ArrayList<Location> locations = new ArrayList<>();
        jsonArray.forEach(jsonElement -> locations.add(gson.fromJson(jsonElement, Location.class)));
        return locations;
    }

    private static JsonObject getCoronaJson(String endpoint) throws IOException {
        String url = BASE_URL + endpoint;
        return readJsonUrl(url).getAsJsonObject();
    }

    private static JsonElement readJsonUrl(String url) throws IOException {
        return new JsonParser().parse(getPage(url));
    }

    private static String getPage(String url) throws IOException {
        URL url1 = new URL(url);
        URLConnection connection = url1.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
        connection.connect();
        BufferedReader serverResponse = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = serverResponse.readLine();
        serverResponse.close();
        return response;
    }
}