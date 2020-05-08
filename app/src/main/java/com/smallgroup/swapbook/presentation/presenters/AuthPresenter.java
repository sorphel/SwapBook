package com.smallgroup.swapbook.presentation.presenters;

import com.google.firebase.auth.FirebaseUser;
import com.smallgroup.swapbook.presentation.contracts.AuthContract;
import com.smallgroup.swapbook.presentation.repositories.AuthRepository;

public class AuthPresenter implements AuthContract.Presenter {

    private AuthContract.View mView;
    private AuthContract.Repository mRepository;

    //other variables



    public AuthPresenter(AuthContract.View mView) {
        this.mView = mView;
        this.mRepository = new AuthRepository(this);
    }


    @Override
    public void onAuth(String token) {
        mRepository.firebaseAuthWithGoogle(token);
    }


    @Override
    public void onUpdateView(FirebaseUser user) {
        if (user != null) {
            mView.updateView(user);
        }
        else{
            mView.showError();
        }
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
