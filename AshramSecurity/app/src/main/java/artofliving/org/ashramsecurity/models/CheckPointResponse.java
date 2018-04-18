package artofliving.org.ashramsecurity.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by sarthak-m on 12/03/18.
 */

@Parcel
public class CheckPointResponse {

    @SerializedName("ashrams")
    public ArrayList<Ashram> ashrams;

    @SerializedName("checkpoints")
    public ArrayList<CheckPoint> checkpoints;

}
