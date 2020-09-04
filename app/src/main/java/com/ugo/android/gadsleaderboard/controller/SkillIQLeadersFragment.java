package com.ugo.android.gadsleaderboard.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.adapter.LearningLeadersDisplayAdapter;
import com.ugo.android.gadsleaderboard.adapter.SkillIQLeadersDisplayAdapter;
import com.ugo.android.gadsleaderboard.model.learningleaders.LearningLeaders;
import com.ugo.android.gadsleaderboard.model.learningleaders.LearningLeadersResponseModel;
import com.ugo.android.gadsleaderboard.model.skilliq.SkillIQLeaders;
import com.ugo.android.gadsleaderboard.model.skilliq.SkillIQLeadersResponseModel;
import com.ugo.android.gadsleaderboard.network.LeaderboardApiService;
import com.ugo.android.gadsleaderboard.network.RetrofitFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SkillIQLeadersFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SkillIQLeadersDisplayAdapter skillIQLeadersDisplayAdapter;
    private static Retrofit retrofit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaders, container, false);
        recyclerView = view.findViewById(R.id.news_recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
//        ArrayList<SkillIQLeaders> skillIQLeadersList = new ArrayList<>();
//        skillIQLeadersList.add(new SkillIQLeaders(R.drawable.learningleader, "Peter Obi", "22 hours read", "Nigeria"));
//        skillIQLeadersList.add(new SkillIQLeaders(R.drawable.learningleader, "John Ngige", "22 hours read", "Nigeria"));
//        skillIQLeadersList.add(new SkillIQLeaders(R.drawable.learningleader, "Ahmadu Ali", "22 hours read", "Nigeria"));
//        skillIQLeadersList.add(new SkillIQLeaders(R.drawable.learningleader, "Ade Bisi", "22 hours read", "Nigeria"));
//        skillIQLeadersList.add(new SkillIQLeaders(R.drawable.learningleader, "Sean John", "22 hours read", "UK"));
//        skillIQLeadersList.add(new SkillIQLeaders(R.drawable.learningleader, "Stella Ngozi", "22 hours read", "China"));
//        skillIQLeadersDisplayAdapter = new SkillIQLeadersDisplayAdapter(getActivity(), skillIQLeadersList);
//
//        recyclerView.setAdapter(skillIQLeadersDisplayAdapter);

        connectAndGetApiData();

        return view;
    }

    public void connectAndGetApiData() {
        retrofit = RetrofitFactory.getRetrofit();

        LeaderboardApiService leaderboardApiService = retrofit.create(LeaderboardApiService.class);
        //Call<MovieResponse> call = movieApiService.getTopRatedMovies(API_KEY);

        Call<List<SkillIQLeaders>> call = leaderboardApiService.getSkillIqLeaders();

        call.enqueue(new Callback<List<SkillIQLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeaders>> call, Response<List<SkillIQLeaders>> response) {
                final List<SkillIQLeaders> skillIQLeaders = response.body();
                if (skillIQLeaders.size() > 0) {
                    final SkillIQLeadersDisplayAdapter adapter = new SkillIQLeadersDisplayAdapter(getActivity(), skillIQLeaders);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }



            }

            @Override
            public void onFailure(Call<List<SkillIQLeaders>> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(getContext(), "this is an actual network failure " +
                            ":( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                } else {
                    Toast.makeText(getContext(), "conversion issue! big problems :(",
                            Toast.LENGTH_SHORT).show();
                }

            }


        });


    }
}
