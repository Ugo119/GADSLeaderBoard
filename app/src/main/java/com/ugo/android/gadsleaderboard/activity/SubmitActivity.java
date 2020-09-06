package com.ugo.android.gadsleaderboard.activity;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.gson.JsonObject;
import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.model.SubmissionResponseModel;
import com.ugo.android.gadsleaderboard.model.learningleaders.LearningLeaders;
import com.ugo.android.gadsleaderboard.network.LeaderboardApiService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {
    EditText etFirstName;
    EditText etSurname;
    EditText etEmail;
    EditText etGithubUrl;
    Button submit;
    String firstName = "";
    String lastName = "";
    String email = "";
    String submitUrl = "";
    private String submissionUrl = "https://docs.google.com/forms/d/e/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_submit);
        etFirstName = findViewById(R.id.et_firstname);
        etSurname = findViewById(R.id.et_surname);
        etEmail = findViewById(R.id.et_email);
        etGithubUrl = findViewById(R.id.et_submit_link);
        submit = findViewById(R.id.btn_submit);

        firstName = etFirstName.getText().toString();
        lastName = etSurname.getText().toString();
        email = etEmail.getText().toString();
        submitUrl = etGithubUrl.getText().toString();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchConfirmSubmitPopup(SubmitActivity.this);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void launchConfirmSubmitPopup(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        dialog.setCanceledOnTouchOutside(Boolean.TRUE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.popup_screen_for_confirm_submit);
        TextView tvNumberOfPositiveResponse = dialog.findViewById(R.id.tv_title);
        Button btnYes = dialog.findViewById(R.id.btn_yes);

        btnYes.setOnClickListener(v -> {
            submitAssignment();
            dialog.cancel();
        });
        dialog.show();
    }

    public void launchSubmissionSuccessfulPopup(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        dialog.setCanceledOnTouchOutside(Boolean.TRUE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.popup_screen_for_success);
        dialog.show();
    }

    public void launchSubmissionFailurePopup(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        dialog.setCanceledOnTouchOutside(Boolean.TRUE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.popup_screen_for_failure);
        dialog.show();
    }

    public void submitAssignment() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(submissionUrl)
                .addConverterFactory(GsonConverterFactory.create())

                .client(client);
        Retrofit retrofit = builder.build();
        LeaderboardApiService leaderboardApiService = retrofit.create(LeaderboardApiService.class);


        Call<SubmissionResponseModel> call = leaderboardApiService.submitProject(email,firstName, lastName, submitUrl);
        call.enqueue(new Callback<SubmissionResponseModel>() {
            @Override
            public void onResponse(Call<SubmissionResponseModel> call, Response<SubmissionResponseModel> response) {
                launchSubmissionSuccessfulPopup(SubmitActivity.this);
            }

            @Override
            public void onFailure(Call<SubmissionResponseModel> call, Throwable t) {
                launchSubmissionFailurePopup(SubmitActivity.this);

            }
        });
    }
}
