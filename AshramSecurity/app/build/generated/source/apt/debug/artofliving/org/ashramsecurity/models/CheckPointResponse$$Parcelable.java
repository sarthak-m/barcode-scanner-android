
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
public class CheckPointResponse$$Parcelable
    implements Parcelable, ParcelWrapper<artofliving.org.ashramsecurity.models.CheckPointResponse>
{

    private artofliving.org.ashramsecurity.models.CheckPointResponse checkPointResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<CheckPointResponse$$Parcelable>CREATOR = new Creator<CheckPointResponse$$Parcelable>() {


        @Override
        public CheckPointResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new CheckPointResponse$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public CheckPointResponse$$Parcelable[] newArray(int size) {
            return new CheckPointResponse$$Parcelable[size] ;
        }

    }
    ;

    public CheckPointResponse$$Parcelable(artofliving.org.ashramsecurity.models.CheckPointResponse checkPointResponse$$2) {
        checkPointResponse$$0 = checkPointResponse$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(checkPointResponse$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(artofliving.org.ashramsecurity.models.CheckPointResponse checkPointResponse$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(checkPointResponse$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(checkPointResponse$$1));
            if (checkPointResponse$$1 .ashrams == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(checkPointResponse$$1 .ashrams.size());
                for (artofliving.org.ashramsecurity.models.Ashram ashram$$0 : checkPointResponse$$1 .ashrams) {
                    artofliving.org.ashramsecurity.models.Ashram$$Parcelable.write(ashram$$0, parcel$$1, flags$$0, identityMap$$0);
                }
            }
            if (checkPointResponse$$1 .checkpoints == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(checkPointResponse$$1 .checkpoints.size());
                for (artofliving.org.ashramsecurity.models.CheckPoint checkPoint$$0 : checkPointResponse$$1 .checkpoints) {
                    artofliving.org.ashramsecurity.models.CheckPoint$$Parcelable.write(checkPoint$$0, parcel$$1, flags$$0, identityMap$$0);
                }
            }
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public artofliving.org.ashramsecurity.models.CheckPointResponse getParcel() {
        return checkPointResponse$$0;
    }

    public static artofliving.org.ashramsecurity.models.CheckPointResponse read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            artofliving.org.ashramsecurity.models.CheckPointResponse checkPointResponse$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            checkPointResponse$$4 = new artofliving.org.ashramsecurity.models.CheckPointResponse();
            identityMap$$1 .put(reservation$$0, checkPointResponse$$4);
            int int$$0 = parcel$$3 .readInt();
            java.util.ArrayList<artofliving.org.ashramsecurity.models.Ashram> list$$0;
            if (int$$0 < 0) {
                list$$0 = null;
            } else {
                list$$0 = new java.util.ArrayList<artofliving.org.ashramsecurity.models.Ashram>(int$$0);
                for (int int$$1 = 0; (int$$1 <int$$0); int$$1 ++) {
                    artofliving.org.ashramsecurity.models.Ashram ashram$$1 = artofliving.org.ashramsecurity.models.Ashram$$Parcelable.read(parcel$$3, identityMap$$1);
                    list$$0 .add(ashram$$1);
                }
            }
            checkPointResponse$$4 .ashrams = list$$0;
            int int$$2 = parcel$$3 .readInt();
            java.util.ArrayList<artofliving.org.ashramsecurity.models.CheckPoint> list$$1;
            if (int$$2 < 0) {
                list$$1 = null;
            } else {
                list$$1 = new java.util.ArrayList<artofliving.org.ashramsecurity.models.CheckPoint>(int$$2);
                for (int int$$3 = 0; (int$$3 <int$$2); int$$3 ++) {
                    artofliving.org.ashramsecurity.models.CheckPoint checkPoint$$1 = artofliving.org.ashramsecurity.models.CheckPoint$$Parcelable.read(parcel$$3, identityMap$$1);
                    list$$1 .add(checkPoint$$1);
                }
            }
            checkPointResponse$$4 .checkpoints = list$$1;
            artofliving.org.ashramsecurity.models.CheckPointResponse checkPointResponse$$3 = checkPointResponse$$4;
            identityMap$$1 .put(identity$$1, checkPointResponse$$3);
            return checkPointResponse$$3;
        }
    }

}
