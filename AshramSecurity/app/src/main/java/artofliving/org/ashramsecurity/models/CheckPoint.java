package artofliving.org.ashramsecurity.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by sarthak-m on 12/03/18.
 */

@Parcel
public class CheckPoint {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("active")
    public String active;

    @SerializedName("ashram")
    public String ashramId;
}
