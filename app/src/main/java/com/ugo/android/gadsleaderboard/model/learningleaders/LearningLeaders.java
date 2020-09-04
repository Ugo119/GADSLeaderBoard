package com.ugo.android.gadsleaderboard.model.learningleaders;

import com.google.gson.annotations.SerializedName;

public class LearningLeaders {
    @SerializedName("badgeUrl")
    private String badgeUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("hours")
    private String hours;

    @SerializedName("country")
    private String country;

    public LearningLeaders(String badgeUrl, String learnerName, String learnerActivity, String learnerCountry) {
        this.badgeUrl = badgeUrl;
        this.name = learnerName;
        this.hours = learnerActivity;
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

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
