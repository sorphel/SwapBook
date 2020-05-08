package com.smallgroup.swapbook.presentation.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.presentation.contracts.AuthContract;
import com.smallgroup.swapbook.presentation.contracts.BaseContract;
import com.smallgroup.swapbook.presentation.presenters.AuthPresenter;

public class SignInActivity extends AppCompatActivity implements BaseContract.View, AuthContract.View {

    AuthContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mPresenter = new AuthPresenter(this);
    }

    @Override
    public void updateView() {

    }
}
