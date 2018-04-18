
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
public class CheckPoint$$Parcelable
    implements Parcelable, ParcelWrapper<artofliving.org.ashramsecurity.models.CheckPoint>
{

    private artofliving.org.ashramsecurity.models.CheckPoint checkPoint$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<CheckPoint$$Parcelable>CREATOR = new Creator<CheckPoint$$Parcelable>() {


        @Override
        public CheckPoint$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new CheckPoint$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public CheckPoint$$Parcelable[] newArray(int size) {
            return new CheckPoint$$Parcelable[size] ;
        }

    }
    ;

    public CheckPoint$$Parcelable(artofliving.org.ashramsecurity.models.CheckPoint checkPoint$$2) {
        checkPoint$$0 = checkPoint$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(checkPoint$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(artofliving.org.ashramsecurity.models.CheckPoint checkPoint$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(checkPoint$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(checkPoint$$1));
            parcel$$1 .writeString(checkPoint$$1 .name);
            parcel$$1 .writeString(checkPoint$$1 .active);
            parcel$$1 .writeString(checkPoint$$1 .ashramId);
            parcel$$1 .writeString(checkPoint$$1 .id);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public artofliving.org.ashramsecurity.models.CheckPoint getParcel() {
        return checkPoint$$0;
    }

    public static artofliving.org.ashramsecurity.models.CheckPoint read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            artofliving.org.ashramsecurity.models.CheckPoint checkPoint$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            checkPoint$$4 = new artofliving.org.ashramsecurity.models.CheckPoint();
            identityMap$$1 .put(reservation$$0, checkPoint$$4);
            checkPoint$$4 .name = parcel$$3 .readString();
            checkPoint$$4 .active = parcel$$3 .readString();
            checkPoint$$4 .ashramId = parcel$$3 .readString();
            checkPoint$$4 .id = parcel$$3 .readString();
            artofliving.org.ashramsecurity.models.CheckPoint checkPoint$$3 = checkPoint$$4;
            identityMap$$1 .put(identity$$1, checkPoint$$3);
            return checkPoint$$3;
        }
    }

}
