package com.heady.explora.screens.userModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by billeasymacbookpro2 on 30/08/18.
 */

public class DataResponse implements Parcelable {
    private ArrayList<ResponseResult> results = new ArrayList<>();

    public DataResponse() {
    }

    public DataResponse(ArrayList<ResponseResult> results) {
        this.results = results;
    }

    protected DataResponse(Parcel in) {
        results = in.createTypedArrayList(ResponseResult.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(results);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataResponse> CREATOR = new Creator<DataResponse>() {
        @Override
        public DataResponse createFromParcel(Parcel in) {
            return new DataResponse(in);
        }

        @Override
        public DataResponse[] newArray(int size) {
            return new DataResponse[size];
        }
    };

    public ArrayList<ResponseResult> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResponseResult> results) {
        this.results = results;
    }
}
