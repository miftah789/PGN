package com.miftah.asyst.pgn.model;

import com.google.gson.annotations.SerializedName;

public class DataModel {
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
}
