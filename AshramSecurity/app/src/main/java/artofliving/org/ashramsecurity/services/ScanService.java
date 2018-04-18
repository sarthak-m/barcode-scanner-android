package artofliving.org.ashramsecurity.services;

import android.content.Context;
import android.util.Pair;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.Ion;

import artofliving.org.ashramsecurity.models.GenericResponse;
import artofliving.org.ashramsecurity.utils.RestUrlUtil;
import artofliving.org.ashramsecurity.utils.ServiceCallback;
import artofliving.org.ashramsecurity.utils.UIConstants;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class ScanService {

    public static void checkSecurity(Context context, String rbid, final ServiceCallback<GenericResponse> serviceCallback) {

        Pair<String, String> user = DatabaseService.getUser();
        String email = user.first;
        String password = user.second;
        String key = UIConstants.API_KEY;
        String ashram = DatabaseService.getAshram();
        String checkpoint_id = DatabaseService.getCheckPointId();

        Ion.with(context)
                .load("POST", RestUrlUtil.getSecurityCheckUrl())
                .setBodyParameter("email", email)
                .setBodyParameter("password", password)
                .setBodyParameter("key", key)
                .setBodyParameter("ashram", ashram)
                .setBodyParameter("rbid", rbid)
                .setBodyParameter("checkpoint_id", checkpoint_id)
                .as(new TypeToken<GenericResponse>() {
                })
                .setCallback(new CustomFutureCallback<GenericResponse>() {
                    @Override
                    public void onCompleted(GenericResponse result) {
                        serviceCallback.run(result);
                    }

                    @Override
                    public void onNoNetworkConnection(boolean listenToConnectionChangedEvent) {
                        serviceCallback.onNoNetworkConnection(listenToConnectionChangedEvent);
                    }

                });
    }
}
