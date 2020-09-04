package com.ugo.android.gadsleaderboard.model.skilliq;

import com.google.gson.annotations.SerializedName;

public class SkillIQLeaders {
    @SerializedName("badgeUrl")
    private String badgeUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private String score;

    @SerializedName("country")
    private String country;

    public SkillIQLeaders(String badgeUrl, String learnerName, String learnerActivity, String learnerCountry) {
        this.badgeUrl = badgeUrl;
        this.name = learnerName;
        this.score = learnerActivity;
        this.country = learnerCountry;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
