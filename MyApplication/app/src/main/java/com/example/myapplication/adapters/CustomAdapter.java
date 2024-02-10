package com.example.myapplication.adapters;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activities.MainActivity3;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;
    private int[] intlocalDataSet;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public CustomAdapter(Context context, String[] dataSet, int[] intDataSet) {
        localDataSet = dataSet;
        this.context = context;
        intlocalDataSet = intDataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.music_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
        viewHolder.getTextView().setTag(position);
        viewHolder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("text", localDataSet[viewHolder.getAdapterPosition()]
                );
                intent.putExtra("id", intlocalDataSet[viewHolder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
