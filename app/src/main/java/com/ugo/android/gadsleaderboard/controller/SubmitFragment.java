package com.ugo.android.gadsleaderboard.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.JsonObject;
import com.ugo.android.gadsleaderboard.R;

public class SubmitFragment extends Fragment {
    EditText etFirstName;
    EditText etSurname;
    EditText etEmail;
    EditText etGithubUrl;
    String firstName = "";
    String lastName = "";
    String email = "";
    String submitUrl = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit, container, false);
        etFirstName = view.findViewById(R.id.et_firstname);
        etSurname = view.findViewById(R.id.et_surname);
        etEmail = view.findViewById(R.id.et_email);
        etGithubUrl = view.findViewById(R.id.et_submit_link);

        firstName = etFirstName.getText().toString();
        lastName = etSurname.getText().toString();
        email = etEmail.getText().toString();
        submitUrl = etGithubUrl.getText().toString();

        return view;
    }

    private void getSubmissionDetails() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("firstName", firstName);
        jsonObject.addProperty("surname", lastName);
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("submitUrl", submitUrl);
    }
}
