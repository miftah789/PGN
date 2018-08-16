package com.miftah.asyst.pgn.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginModel implements Parcelable {

    String username;
    String password;

    public static final Creator<LoginModel> CREATOR = new Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel in) {
            return new LoginModel(in);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected LoginModel(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static Creator<LoginModel> getCREATOR() {
        return CREATOR;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }
}
