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

import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.model.skilliq.SkillIQLeaders;

import java.util.ArrayList;
import java.util.List;

public class SkillIQLeadersDisplayAdapter extends RecyclerView.Adapter<SkillIQLeadersDisplayAdapter.SkillIQViewHolder> {
    public String achievementBadge;
    public String learnerName;
    public String learnerActivity;
    public String learnerCountry;
    SkillIQLeaders skillIQLeaders = new SkillIQLeaders(achievementBadge, learnerName, learnerActivity, learnerCountry);
    private List<SkillIQLeaders> skillIQLeadersList;

    public SkillIQLeadersDisplayAdapter(Activity context, List<SkillIQLeaders> skillIQLeadersList) {
        this.skillIQLeadersList = skillIQLeadersList;
        //super(context, 0, learningLeaders);
    }
    public static class SkillIQViewHolder extends RecyclerView.ViewHolder {
        public String achievementBadge;
        public String learnerName;
        public String learnerActivity;
        public String learnerCountry;
        SkillIQLeaders skillIQLeaders = new SkillIQLeaders(achievementBadge, learnerName, learnerActivity, learnerCountry);

        public ImageView badge;
        public TextView name;
        public TextView activity;
        public TextView country;

        public SkillIQViewHolder(@NonNull View itemView) {
            super(itemView);

            badge = itemView.findViewById(R.id.badge);
            name = itemView.findViewById(R.id.tv_name);
            activity = itemView.findViewById(R.id.tv_activity);
            country = itemView.findViewById(R.id.tv_country);
        }
    }

    @NonNull
    @Override
    public SkillIQLeadersDisplayAdapter.SkillIQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        final View view = inflater.inflate(R.layout.skill_leader_layout,parent, false);


        return new SkillIQLeadersDisplayAdapter.SkillIQViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQLeadersDisplayAdapter.SkillIQViewHolder holder, int position) {
        SkillIQLeaders skillIQLeaders = skillIQLeadersList.get(position);
        holder.badge.setImageResource(R.drawable.skill);
        holder.name.setText(skillIQLeaders.getName());
        holder.activity.setText(skillIQLeaders.getScore());
        holder.country.setText(skillIQLeaders.getCountry());

    }

    @Override
    public int getItemCount() {
        return skillIQLeadersList.size();
    }
}
