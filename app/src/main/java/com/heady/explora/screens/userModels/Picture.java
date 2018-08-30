package com.heady.explora.screens.userModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by billeasymacbookpro2 on 29/08/18.
 */

public class Picture implements Parcelable {
    public String large;

    public Picture(String large) {
        this.large = large;
    }

    public Picture() {
    }

    protected Picture(Parcel in) {
        large = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(large);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
