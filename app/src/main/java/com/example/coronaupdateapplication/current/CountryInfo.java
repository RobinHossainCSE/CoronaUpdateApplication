
package com.example.coronaupdateapplication.current;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CountryInfo {

    @SerializedName("_id")
    @Expose
    private long id;
    @SerializedName("iso2")
    @Expose
    private String iso2;
    @SerializedName("iso3")
    @Expose
    private String iso3;
    @SerializedName("lat")
    @Expose
    private long lat;
    @SerializedName("long")
    @Expose
    private long _long;
    @SerializedName("flag")
    @Expose
    private String flag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLong() {
        return _long;
    }

    public void setLong(long _long) {
        this._long = _long;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
