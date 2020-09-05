package com.ugo.android.gadsleaderboard.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.controller.LearningLeadersFragment;

public class LearningLeadersActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {return new LearningLeadersFragment();}
}