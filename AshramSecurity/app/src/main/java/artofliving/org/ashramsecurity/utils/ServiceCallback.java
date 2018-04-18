package artofliving.org.ashramsecurity.utils;

/**
 * Created by sarthak-m on 12/03/18.
 */

public abstract class ServiceCallback<T> {

    public abstract void run(T data);

    /*
        Currently not making this method to mandatorily overided.
     */
    public void onNoNetworkConnection(boolean listenToConnectionChangedEvent){

    }
}
