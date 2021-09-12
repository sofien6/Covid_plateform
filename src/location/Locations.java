/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package location;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import latest.Latest;

/**
 *
 * @author Click
 */
public class Locations {
    @SerializedName("latest")
    private Latest latest;

    @SerializedName("locations")
    private ArrayList<Location> locations;

    public Latest getLatest() {
        return latest;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
}