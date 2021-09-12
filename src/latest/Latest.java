/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latest;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Click
 */
public class Latest {
    @SerializedName("confirmed")
    private int confirmed;

    @SerializedName("deaths")
    private int deaths;

    @SerializedName("recovered")
    private int recovered;

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getRecovered() {
        return recovered;
    }
}