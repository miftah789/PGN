package com.miftah.asyst.pgn.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataModel implements Parcelable {
    @SerializedName("customer_name")
    String customerName;
    @SerializedName("task_id")
    String taskID;
    @SerializedName("customer_address")
    String customerAddress;
    @SerializedName("hardware_serialNumber")
    String serialNumber;
    @SerializedName("startDate")
    String startDate;
    @SerializedName("finishDate")
    String finishDate;

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public DataModel(String customerName, String taskID, String customerAddress, String serialNumber, String startDate, String finishDate) {
        this.customerName = customerName;
        this.taskID = taskID;
        this.customerAddress = customerAddress;
        this.serialNumber = serialNumber;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    protected DataModel(Parcel in) {
        customerName = in.readString();
        taskID = in.readString();
        customerAddress = in.readString();
        serialNumber = in.readString();
        startDate = in.readString();
        finishDate = in.readString();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerName);
        dest.writeString(taskID);
        dest.writeString(customerAddress);
        dest.writeString(serialNumber);
        dest.writeString(startDate);
        dest.writeString(finishDate);
    }
}
