package com.ugo.android.gadsleaderboard.model.skilliq;

import com.ugo.android.gadsleaderboard.model.learningleaders.LearningLeaders;

import java.util.ArrayList;
import java.util.List;

public class SkillIQLeadersResponseModel {
    private List<SkillIQLeaders> skillIQLeaders = null;

    public List<SkillIQLeaders> getSkillIQLeaders() {
        return skillIQLeaders;
    }

    public void setSkillIQLeaders(List<SkillIQLeaders> skillIQLeaders) {
        this.skillIQLeaders = skillIQLeaders;
    }
}
