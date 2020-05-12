package com.smallgroup.swapbook.presentation.presenters;

import android.net.Uri;

import com.smallgroup.swapbook.presentation.contracts.ProfileContract;
import com.smallgroup.swapbook.presentation.repositories.ProfileRepository;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileContract.View mView;
    private ProfileContract.Repository mRepository;

    public ProfilePresenter(ProfileContract.View mView) {
        this.mView = mView;
        mRepository = new ProfileRepository(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSignOut() {
        mRepository.signOut();
    }

    @Override
    public void onLoadData() {
        mRepository.loadData();
    }

    @Override
    public void onSetData(String name, String email, Uri uri) {
        mView.uploadImage(uri);
        mView.setName(name);
        mView.setEmail(email);
    }


}
