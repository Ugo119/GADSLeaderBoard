package com.ugo.android.gadsleaderboard.model.learningleaders;

import java.util.ArrayList;
import java.util.List;

public class LearningLeadersResponseModel {
    private List<LearningLeaders> learningLeaders = null;

    public List<LearningLeaders> getLearningLeaders() {
        return learningLeaders;
    }

    public void setLearningLeaders(ArrayList<LearningLeaders> learningLeaders) {
        this.learningLeaders = learningLeaders;
    }
}
