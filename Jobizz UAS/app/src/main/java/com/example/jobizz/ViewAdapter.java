package com.example.jobizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ItemImageHolder> {

    List<String> listData;
    LayoutInflater inflater;

    public ViewAdapter(Context context, List<String> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_image, parent, false);
        return new ItemImageHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemImageHolder holder, int position) {
        holder.txtData.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ItemImageHolder extends RecyclerView.ViewHolder {

        TextView txtData;

        public ItemImageHolder(@NonNull View itemView) {
            super(itemView);

            txtData = itemView.findViewById(R.id.tv_rv);

        }
    }
}


//public class ItemViewHolder extends RecyclerView.ViewHolder {
//
//    ImageView imageView;
//
//    public ItemViewHolder(@NonNull View itemView) {
//        super(itemView);
//
//        imageView = itemView.findViewById(R.id.iv_itemimage);
//
//
//    }
//}