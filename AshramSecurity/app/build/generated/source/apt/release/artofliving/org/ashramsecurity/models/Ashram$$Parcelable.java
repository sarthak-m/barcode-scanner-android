
package artofliving.org.ashramsecurity.models;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class Ashram$$Parcelable
    implements Parcelable, ParcelWrapper<artofliving.org.ashramsecurity.models.Ashram>
{

    private artofliving.org.ashramsecurity.models.Ashram ashram$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Ashram$$Parcelable>CREATOR = new Creator<Ashram$$Parcelable>() {


        @Override
        public Ashram$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Ashram$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Ashram$$Parcelable[] newArray(int size) {
            return new Ashram$$Parcelable[size] ;
        }

    }
    ;

    public Ashram$$Parcelable(artofliving.org.ashramsecurity.models.Ashram ashram$$2) {
        ashram$$0 = ashram$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(ashram$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(artofliving.org.ashramsecurity.models.Ashram ashram$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(ashram$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(ashram$$1));
            parcel$$1 .writeString(ashram$$1 .organisation_id);
            parcel$$1 .writeString(ashram$$1 .name);
            parcel$$1 .writeString(ashram$$1 .active);
            parcel$$1 .writeString(ashram$$1 .id);
            parcel$$1 .writeString(ashram$$1 .country_state_location);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public artofliving.org.ashramsecurity.models.Ashram getParcel() {
        return ashram$$0;
    }

    public static artofliving.org.ashramsecurity.models.Ashram read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            artofliving.org.ashramsecurity.models.Ashram ashram$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            ashram$$4 = new artofliving.org.ashramsecurity.models.Ashram();
            identityMap$$1 .put(reservation$$0, ashram$$4);
            ashram$$4 .organisation_id = parcel$$3 .readString();
            ashram$$4 .name = parcel$$3 .readString();
            ashram$$4 .active = parcel$$3 .readString();
            ashram$$4 .id = parcel$$3 .readString();
            ashram$$4 .country_state_location = parcel$$3 .readString();
            artofliving.org.ashramsecurity.models.Ashram ashram$$3 = ashram$$4;
            identityMap$$1 .put(identity$$1, ashram$$3);
            return ashram$$3;
        }
    }

}
