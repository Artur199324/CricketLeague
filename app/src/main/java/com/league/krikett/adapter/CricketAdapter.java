package com.league.krikett.adapter;

;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.league.krikett.R;
import com.league.krikett.model.Cricket;

import java.util.ArrayList;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.CricketViewHolder> {

    Context context;
    ArrayList<Cricket> arrayListCricket;
    private CricketAdapter.OnItemClickListener listener;
    public static int position;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = (CricketAdapter.OnItemClickListener) listener;
    }
    public CricketAdapter(Context context, ArrayList<Cricket> arrayListCricket) {
        this.context = context;
        this.arrayListCricket = arrayListCricket;
    }

    @NonNull
    @Override
    public CricketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cricket_item, parent, false);

        return new CricketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketViewHolder holder, int position) {

        Cricket cricket = arrayListCricket.get(position);
        String results = cricket.getResults();
        String home = cricket.getHome();
        String away = cricket.getAway();
        String stadium = cricket.getStadium();
        String date = cricket.getDate();
        holder.textViewresults.setText(results);
        holder.textViewHome.setText(home);
        holder.textViewAway.setText(away);
        holder.textViewstadium.setText(stadium);
        holder.textViewdate.setText(date);

    }

    @Override
    public int getItemCount() {
        return arrayListCricket.size();
    }

    public class CricketViewHolder extends RecyclerView.ViewHolder {

        TextView textViewHome,textViewAway,textViewresults,textViewstadium,textViewdate;

        public CricketViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHome = itemView.findViewById(R.id.textViewHome);
            textViewAway = itemView.findViewById(R.id.textViewAway);
            textViewresults = itemView.findViewById(R.id.textViewresults);
            textViewstadium = itemView.findViewById(R.id.textViewstadium);
            textViewdate = itemView.findViewById(R.id.textViewdate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
