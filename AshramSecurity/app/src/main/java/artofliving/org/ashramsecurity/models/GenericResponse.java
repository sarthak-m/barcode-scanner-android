package artofliving.org.ashramsecurity.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by sarthak-m on 12/03/18.
 */

@Parcel
public class GenericResponse {

    @SerializedName("stat")
    String stat;

    @SerializedName("msg")
    public String message;

    @SerializedName("uid")
    public String uid;

    @SerializedName("name")
    public String name;

    @SerializedName("photo")
    public String photoUrl;

    @SerializedName("card")
    public String card;

    public boolean isSuccessful() {
        return !stat.equalsIgnoreCase("error");
    }
}
