package com.miftah.asyst.pgn.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.miftah.asyst.pgn.R;
import com.miftah.asyst.pgn.model.DataModel;
import com.miftah.asyst.pgn.utility.DateUtils;

import java.util.ArrayList;

public class AdapterPGN extends RecyclerView.Adapter<AdapterPGN.MyViewHolderPGN> {

    Context mContext;
    ArrayList<DataModel> mListData;
    OnItemClickListener mlistener;

    public AdapterPGN(Context context, ArrayList<DataModel> listData, OnItemClickListener listener) {
        this.mContext = context;
        this.mListData = listData;
        this.mlistener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPGN holder, int position) {
        final DataModel dataModel = mListData.get(position);
        holder.tvName.setText(dataModel.getCustomerName());
        holder.tvAddress.setText(dataModel.getCustomerAddress());
        if (!dataModel.getFinishDate().isEmpty()) {
            holder.tvStartDate.setText(DateUtils.formatDate("yyyy-MM-dd", "dd MMMM yyyy", dataModel.getStartDate()));
        }
        if (!dataModel.getFinishDate().isEmpty()) {
            holder.tvFinishDate.setText(DateUtils.formatDate("yyyy-MM-dd", "dd MMMM yyyy", dataModel.getFinishDate()));
        } else {
            holder.tvFinishDate.setText("");
        }
        holder.tvTaskID.setText(dataModel.getTaskID());
        holder.tvSerialNumber.setText(dataModel.getSerialNumber());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onItemClick(dataModel);
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolderPGN onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new AdapterPGN.MyViewHolderPGN(itemView);
    }

    @Override
    public int getItemCount() {

        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(DataModel data);
    }


    public class MyViewHolderPGN extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvAddress;
        TextView tvStartDate;
        TextView tvFinishDate;
        TextView tvTaskID;
        TextView tvSerialNumber;
        CardView cardView;

        public MyViewHolderPGN(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvStartDate = itemView.findViewById(R.id.tv_start_date);
            tvFinishDate = itemView.findViewById(R.id.tv_finish_date);
            tvSerialNumber = itemView.findViewById(R.id.tv_serialNumber);
            tvTaskID = itemView.findViewById(R.id.tv_task_id);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }

}
