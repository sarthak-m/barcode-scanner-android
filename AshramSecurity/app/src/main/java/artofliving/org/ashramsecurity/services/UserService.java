package artofliving.org.ashramsecurity.services;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.Ion;

import artofliving.org.ashramsecurity.AshramSecurityApplication;
import artofliving.org.ashramsecurity.R;
import artofliving.org.ashramsecurity.models.GenericResponse;
import artofliving.org.ashramsecurity.utils.RestUrlUtil;
import artofliving.org.ashramsecurity.utils.ServiceCallback;
import artofliving.org.ashramsecurity.utils.UIConstants;

/**
 * Created by sarthak-m on 12/03/18.
 */

public class UserService {

    public static void login(Context context, String email, String password, final ServiceCallback<GenericResponse> serviceCallback) {
        Ion.with(context)
                .load("POST", RestUrlUtil.getLoginUrl())
                .setBodyParameter("email", email)
                .setBodyParameter("password", password)
                .setBodyParameter("key", UIConstants.API_KEY)
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
