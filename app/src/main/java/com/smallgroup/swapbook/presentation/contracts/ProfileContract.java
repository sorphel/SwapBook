package com.smallgroup.swapbook.presentation.contracts;

import android.net.Uri;

import com.smallgroup.swapbook.presentation.presenters.BasePresenter;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.view.BaseView;

public interface ProfileContract {

    interface View extends BaseView {
        void signOutClick();
        void uploadImage(Uri uri);
        void setEmail(String email);
        void setName(String name);
    }

    interface Presenter extends BasePresenter {
        void onSignOut();
        void onLoadData();
        void onSetData(String name, String email, Uri uri);
    }

    interface Repository extends BaseRepository {
        void loadData();
        void signOut();
    }

}
