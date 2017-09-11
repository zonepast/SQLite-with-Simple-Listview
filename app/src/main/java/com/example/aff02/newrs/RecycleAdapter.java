package com.example.aff02.newrs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AFF02 on 23-Aug-17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    List<DataModel> dataModelList;

    public RecycleAdapter(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtname,txtdesc,txtrupees;
        public ViewHolder(View itemView) {
            super(itemView);

            txtname = (TextView)itemView.findViewById(R.id.txtName);
            txtdesc = (TextView)itemView.findViewById(R.id.txtdesc);
            txtrupees = (TextView)itemView.findViewById(R.id.txtRupees);
        }
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {

        DataModel model = dataModelList.get(position);
        holder.txtname.setText(model.getName());
        holder.txtdesc.setText(model.getDesc());
        holder.txtrupees.setText(Integer.toString(model.getRupees()));
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }
}
