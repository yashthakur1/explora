package com.user.test.screens.userModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by billeasymacbookpro2 on 29/08/18.
 */

public class ID implements Parcelable {
    public String value;

    public ID() {
    }

    public ID(String value) {
        this.value = value;
    }

    protected ID(Parcel in) {
        value = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ID> CREATOR = new Creator<ID>() {
        @Override
        public ID createFromParcel(Parcel in) {
            return new ID(in);
        }

        @Override
        public ID[] newArray(int size) {
            return new ID[size];
        }
    };

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
