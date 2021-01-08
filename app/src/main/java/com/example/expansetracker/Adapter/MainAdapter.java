package com.example.expansetracker.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expansetracker.R;

import java.util.List;

import static android.view.View.GONE;
import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    FragmentActivity activity;
    List<String> country;
    int row_index;

    public MainAdapter(FragmentActivity activity, List<String> country) {
        this.activity = activity;
        this.country = country;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.mainview,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.name.setText(country.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
            }
        });

        if (row_index == position){
            holder.main_layout.setBackgroundResource(R.drawable.selected_bg);
            holder.morevert.setVisibility(GONE);
            holder.calculator.setVisibility(View.VISIBLE);
            holder.label3.setVisibility(GONE);
        }else{
            holder.main_layout.setBackgroundResource(R.drawable.unselected_bg);
            holder.morevert.setVisibility(View.VISIBLE);
            holder.calculator.setVisibility(GONE);
            holder.label3.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return country.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView label1;
        TextView label2;
        TextView label3;
        ImageView morevert;
        ImageView calculator;
        LinearLayout main_layout;
        LinearLayout last_layout;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            label1 = itemView.findViewById(R.id.label1);
            label2 = itemView.findViewById(R.id.label2);
            label3 = itemView.findViewById(R.id.label3);
            morevert = itemView.findViewById(R.id.morevert);
            calculator = itemView.findViewById(R.id.calculator);
            main_layout = itemView.findViewById(R.id.main_layout);
            last_layout = itemView.findViewById(R.id.last_layout);
        }
    }
}
