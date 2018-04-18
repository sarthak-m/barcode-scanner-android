package artofliving.org.ashramsecurity.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by sarthak-m on 12/03/18.
 */

@Parcel
class Ashram {

    @SerializedName("organisation_id")
    public String organisation_id;

    @SerializedName("name")
    public String name;

    @SerializedName("id")
    public String id;

    @SerializedName("country_state_location")
    public String country_state_location;

    @SerializedName("active")
    public String active;
}
