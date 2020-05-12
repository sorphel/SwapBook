package com.smallgroup.swapbook.presentation.repositories;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smallgroup.swapbook.presentation.contracts.ProfileContract;

public class ProfileRepository implements ProfileContract.Repository {

    private ProfileContract.Presenter mPresenter;

    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public ProfileRepository(ProfileContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }


    @Override
    public void loadData() {
        Uri uri = user.getPhotoUrl();
        String email = user.getEmail();
        String name = user.getDisplayName();

        mPresenter.onSetData(name, email, uri);
    }


    @Override
    public void signOut() {
        FirebaseAuth.getInstance().signOut();
    }
}
