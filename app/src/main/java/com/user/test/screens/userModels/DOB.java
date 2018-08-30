package com.user.test.screens.userModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by billeasymacbookpro2 on 29/08/18.
 */

public class DOB implements Parcelable {
    public int age;

    public DOB() {
    }

    public DOB(int age) {
        this.age = age;
    }

    protected DOB(Parcel in) {
        age = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DOB> CREATOR = new Creator<DOB>() {
        @Override
        public DOB createFromParcel(Parcel in) {
            return new DOB(in);
        }

        @Override
        public DOB[] newArray(int size) {
            return new DOB[size];
        }
    };

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
