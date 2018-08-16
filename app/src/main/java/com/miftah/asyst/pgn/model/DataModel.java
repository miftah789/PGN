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
}
