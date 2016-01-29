package com.andela.cakeoderingapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.cakeoderingapp.R;
import com.andela.cakeoderingapp.models.Cake;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.CakeViewHolder> {

    private List<Cake> cakes;
    private Context context;

    public CakeAdapter(List<Cake> cakes, Context context) {
        this.cakes = cakes;
        this.context = context;
    }

    @Override
    public CakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cake_item_view, parent, false);
        CakeViewHolder cakeViewHolder = new CakeViewHolder(view);
        return cakeViewHolder;
    }

    @Override
    public void onBindViewHolder(CakeViewHolder holder, int position) {
        Cake cake = cakes.get(position);
        holder.cakeName.setText(cake.getName());
        holder.cakePrice.setText(cake.getPrice());
        Picasso.with(context)
                .load(cake.getSnapshot())
                .into(holder.cakeImage);


    }

    @Override
    public int getItemCount() {
        return cakes.size();
    }


    public class CakeViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView cakeImage;
        TextView cakeName;
        TextView cakePrice;


        public CakeViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cakeImage = (ImageView) itemView.findViewById(R.id.cake_image);
            cakeName = (TextView) itemView.findViewById(R.id.cake_name);
            cakePrice = (TextView) itemView.findViewById(R.id.cake_price);
        }
    }
}
