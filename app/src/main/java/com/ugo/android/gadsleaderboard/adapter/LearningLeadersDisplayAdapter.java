package com.ugo.android.gadsleaderboard.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.model.learningleaders.LearningLeaders;

import java.util.ArrayList;
import java.util.List;

public class LearningLeadersDisplayAdapter extends RecyclerView.Adapter<LearningLeadersDisplayAdapter.LearningViewHolder> {


    private List<LearningLeaders> learningLeadersList;

    public LearningLeadersDisplayAdapter(Activity context, List<LearningLeaders> learningLeadersList) {
        this.learningLeadersList = learningLeadersList;
        //super(context, 0, learningLeaders);
    }

    public static class LearningViewHolder extends RecyclerView.ViewHolder {

        public ImageView badge;
        public TextView name;
        public TextView activity;
        public TextView country;

        public LearningViewHolder(@NonNull View itemView) {
            super(itemView);

            badge = itemView.findViewById(R.id.badge);
            name = itemView.findViewById(R.id.tv_name);
            activity = itemView.findViewById(R.id.tv_activity);
            country = itemView.findViewById(R.id.tv_country);
        }
    }

    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        final View view = inflater.inflate(R.layout.learning_leader_layout,parent, false);


        return new LearningViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewHolder holder, int position) {
        LearningLeaders learningLeaders = learningLeadersList.get(position);
        Picasso.get()
                .load(learningLeaders.getBadgeUrl())
                .centerCrop()
                .resize(63,58)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.badge);

        holder.name.setText(learningLeaders.getName());
        holder.activity.setText(learningLeaders.getHours());
        holder.country.setText(learningLeaders.getCountry());

    }

    @Override
    public int getItemCount() {
        return learningLeadersList.size();
    }

}
