
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
public class GenericResponse$$Parcelable
    implements Parcelable, ParcelWrapper<artofliving.org.ashramsecurity.models.GenericResponse>
{

    private artofliving.org.ashramsecurity.models.GenericResponse genericResponse$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<GenericResponse$$Parcelable>CREATOR = new Creator<GenericResponse$$Parcelable>() {


        @Override
        public GenericResponse$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new GenericResponse$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public GenericResponse$$Parcelable[] newArray(int size) {
            return new GenericResponse$$Parcelable[size] ;
        }

    }
    ;

    public GenericResponse$$Parcelable(artofliving.org.ashramsecurity.models.GenericResponse genericResponse$$2) {
        genericResponse$$0 = genericResponse$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(genericResponse$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(artofliving.org.ashramsecurity.models.GenericResponse genericResponse$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(genericResponse$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(genericResponse$$1));
            parcel$$1 .writeString(genericResponse$$1 .uid);
            parcel$$1 .writeString(genericResponse$$1 .photoUrl);
            parcel$$1 .writeString(genericResponse$$1 .stat);
            parcel$$1 .writeString(genericResponse$$1 .name);
            parcel$$1 .writeString(genericResponse$$1 .message);
            parcel$$1 .writeString(genericResponse$$1 .card);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public artofliving.org.ashramsecurity.models.GenericResponse getParcel() {
        return genericResponse$$0;
    }

    public static artofliving.org.ashramsecurity.models.GenericResponse read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            artofliving.org.ashramsecurity.models.GenericResponse genericResponse$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            genericResponse$$4 = new artofliving.org.ashramsecurity.models.GenericResponse();
            identityMap$$1 .put(reservation$$0, genericResponse$$4);
            genericResponse$$4 .uid = parcel$$3 .readString();
            genericResponse$$4 .photoUrl = parcel$$3 .readString();
            genericResponse$$4 .stat = parcel$$3 .readString();
            genericResponse$$4 .name = parcel$$3 .readString();
            genericResponse$$4 .message = parcel$$3 .readString();
            genericResponse$$4 .card = parcel$$3 .readString();
            artofliving.org.ashramsecurity.models.GenericResponse genericResponse$$3 = genericResponse$$4;
            identityMap$$1 .put(identity$$1, genericResponse$$3);
            return genericResponse$$3;
        }
    }

}
