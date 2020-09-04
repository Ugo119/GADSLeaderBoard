package com.ugo.android.gadsleaderboard.activity;

import androidx.fragment.app.Fragment;

import com.ugo.android.gadsleaderboard.controller.LearningLeadersFragment;
import com.ugo.android.gadsleaderboard.controller.SkillIQLeadersFragment;

public class SkillIQLeadersActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {return new SkillIQLeadersFragment();}
}
