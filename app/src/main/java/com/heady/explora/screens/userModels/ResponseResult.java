package com.heady.explora.screens.userModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by billeasymacbookpro2 on 29/08/18.
 */

public class ResponseResult implements Parcelable {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private DOB dob;
    private String phone;
    private String cell;
    private ID id;
    private Picture picture;

    public ResponseResult() {
    }

    public ResponseResult(String gender, Name name, Location location, String email, DOB dob, String phone, String cell, ID id, Picture picture) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.cell = cell;
        this.id = id;
        this.picture = picture;
    }

    protected ResponseResult(Parcel in) {
        gender = in.readString();
        name = in.readParcelable(Name.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        email = in.readString();
        dob = in.readParcelable(DOB.class.getClassLoader());
        phone = in.readString();
        cell = in.readString();
        id = in.readParcelable(ID.class.getClassLoader());
        picture = in.readParcelable(Picture.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gender);
        dest.writeParcelable(name, flags);
        dest.writeParcelable(location, flags);
        dest.writeString(email);
        dest.writeParcelable(dob, flags);
        dest.writeString(phone);
        dest.writeString(cell);
        dest.writeParcelable(id, flags);
        dest.writeParcelable(picture, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseResult> CREATOR = new Creator<ResponseResult>() {
        @Override
        public ResponseResult createFromParcel(Parcel in) {
            return new ResponseResult(in);
        }

        @Override
        public ResponseResult[] newArray(int size) {
            return new ResponseResult[size];
        }
    };

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DOB getDob() {
        return dob;
    }

    public void setDob(DOB dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
