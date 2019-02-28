package org.pursuit.unit_04_assessment.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.model.Echinoderm;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Echinoderm> echinodermList;

    public MyAdapter(List<Echinoderm> echinodermList) {
        this.echinodermList = echinodermList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_viewholder, viewGroup, false);
        return new MyViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.onBind(echinodermList.get(i));
    }

    @Override
    public int getItemCount() {
        return echinodermList.size();
    }
}
