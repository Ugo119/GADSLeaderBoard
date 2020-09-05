package com.ugo.android.gadsleaderboard.network;

import com.ugo.android.gadsleaderboard.model.SubmissionResponseModel;
import com.ugo.android.gadsleaderboard.model.learningleaders.LearningLeaders;
import com.ugo.android.gadsleaderboard.model.skilliq.SkillIQLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LeaderboardApiService {
    @GET("/api/hours")
    Call<List<LearningLeaders>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillIQLeaders>> getSkillIqLeaders();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<SubmissionResponseModel> submitProject(@Field("entry.1824927963") String emailAddress,
                                                @Field("entry.1877115667") String firstName,
                                                @Field("entry.2006916086") String lastName,
                                                @Field("entry.284483984") String projectUrl);
}
