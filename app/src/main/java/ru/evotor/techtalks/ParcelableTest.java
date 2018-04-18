package ru.evotor.techtalks;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class ParcelableTest implements Parcelable {
    private int src;
    private String result;

    public ParcelableTest(int src, String result) {
        this.src = src;
        this.result = result;
    }

    public ParcelableTest(Parcel in) {
        Log.e("TAG", Hex.toHexString(in.marshall()));

        this.src = in.readInt();
        this.result = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(new int[]{
                0x05,
                0x650048,
                0x6C006C,
                0x6F
        });
    }

    public static final Parcelable.Creator<ParcelableTest> CREATOR
            = new Parcelable.Creator<ParcelableTest>() {
        public ParcelableTest createFromParcel(Parcel in) {
            return new ParcelableTest(in);
        }

        public ParcelableTest[] newArray(int size) {
            return new ParcelableTest[size];
        }
    };

    public int getSrc() {
        return src;
    }

    public String getResult() {
        return result;
    }
}
