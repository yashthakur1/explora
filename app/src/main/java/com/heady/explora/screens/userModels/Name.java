package com.heady.explora.screens.userModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by billeasymacbookpro2 on 29/08/18.
 */

public class Name implements Parcelable {

    private String title;
    private String first;
    private String last;

    public Name() {
    }

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    protected Name(Parcel in) {
        title = in.readString();
        first = in.readString();
        last = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(first);
        dest.writeString(last);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Name> CREATOR = new Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
