package com.smallgroup.swapbook.presentation.presenters;

import com.smallgroup.swapbook.presentation.contracts.AuthContract;
import com.smallgroup.swapbook.presentation.contracts.BaseContract;
import com.smallgroup.swapbook.presentation.repositories.AuthRepository;

public class AuthPresenter implements BaseContract.Presenter, AuthContract.Presenter {

    private AuthContract.View mView;
    private AuthContract.Repository mRepository;

    //other variables


    public AuthPresenter(AuthContract.View mView) {
        this.mView = mView;
        this.mRepository = new AuthRepository(this);
    }

    @Override
    public void onAuth() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
