package artofliving.org.ashramsecurity.services;

import android.app.Activity;
import android.util.Pair;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.Ion;

import artofliving.org.ashramsecurity.models.CheckPointResponse;
import artofliving.org.ashramsecurity.models.GenericResponse;
import artofliving.org.ashramsecurity.utils.RestUrlUtil;
import artofliving.org.ashramsecurity.utils.ServiceCallback;
import artofliving.org.ashramsecurity.utils.UIConstants;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class AshramService {

    public static void getCheckpoints(Activity activity, String ashramId, final ServiceCallback<CheckPointResponse> serviceCallback) {

        Ion.with(activity)
                .load("GET", RestUrlUtil.getCheckPointsUrl())
                .as(new TypeToken<CheckPointResponse>() {
                })
                .setCallback(new CustomFutureCallback<CheckPointResponse>() {
                    @Override
                    public void onCompleted(CheckPointResponse result) {
                        serviceCallback.run(result);
                    }

                    @Override
                    public void onNoNetworkConnection(boolean listenToConnectionChangedEvent) {
                        serviceCallback.onNoNetworkConnection(listenToConnectionChangedEvent);
                    }

                });

    }
}
