/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package location;

import com.google.gson.annotations.SerializedName;
import coordinate.Coordinates;
import latest.Latest;


public class Location {
    @SerializedName("coordinates")
    private Coordinates coordinates;

    @SerializedName("id")
    private int id;

    @SerializedName("country")
    private String country;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("latest")
    private Latest latest;

    @SerializedName("province")
    private String province;

    @SerializedName("state")
    private String state;

    @SerializedName("county")
    private String county;

    // TODO support timelines.

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Latest getLatest() {
        return latest;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getProvince() {
        return province;
    }
}