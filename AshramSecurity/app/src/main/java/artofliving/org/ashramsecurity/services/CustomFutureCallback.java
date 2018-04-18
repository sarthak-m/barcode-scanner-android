package artofliving.org.ashramsecurity.services;

import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;

import java.lang.reflect.Type;

import artofliving.org.ashramsecurity.AshramSecurityApplication;
import artofliving.org.ashramsecurity.utils.ToastMessageUtil;
import artofliving.org.ashramsecurity.utils.UIConstants;

/**
 * Created by sarthak-m on 12/03/18.
 */

public abstract class CustomFutureCallback<T> implements FutureCallback<T> {

    boolean supportOffline = false;
    String cacheKey;
    private Type resultType;
    private T defaultValue;


    public CustomFutureCallback() {
        supportOffline = false;
    }

    public CustomFutureCallback(String cacheKey, Type resultType, T defaultValue) {
        this.resultType = resultType;
        this.defaultValue = defaultValue;
        this.supportOffline = true;
        this.cacheKey = cacheKey;
    }

    @Override
    public void onCompleted(Exception e, T result) {

        onCompleted(result);
//        boolean listenToConnectionChangedEvent = false;
//        if (e != null) {
//            if (!AshramSecurityApplication.getAshramSecurityApplicationContext().getInternetConnectionEvent().checkNetworkConnection()) {
//                listenToConnectionChangedEvent = true;
//                ToastMessageUtil.showErrorToastMessage(UIConstants.NO_INTERNET_MSG, AshramSecurityApplication.getCurrentActivity(), true);
//            } else {
//                Log.e("CustomError", "custom error for cache key = " + String.valueOf(cacheKey), e);
//                ToastMessageUtil.showErrorToastMessage(UIConstants.NO_INTERNET_MSG, AshramSecurityApplication.getCurrentActivity(), true);
//            }
//            onNoNetworkConnection(listenToConnectionChangedEvent);
//
//        } else {
//            onCompleted(result);
//        }
    }

    public abstract void onCompleted(T result);

    public abstract void onNoNetworkConnection(boolean listenToConnectionChangedEvent);
}
