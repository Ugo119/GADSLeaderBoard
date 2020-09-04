package com.ugo.android.gadsleaderboard.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.controller.LearningLeadersFragment;
import com.ugo.android.gadsleaderboard.controller.SkillIQLeadersFragment;

public class LeadersAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    public LeadersAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public LeadersAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LearningLeadersFragment();
        } else {return new SkillIQLeadersFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.learning_leaders_title);
        } else {return mContext.getString(R.string.skill_iq_leaders_title);}
    }
}
