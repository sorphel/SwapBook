package com.smallgroup.swapbook.presentation.contracts;

import com.google.firebase.auth.FirebaseUser;
import com.smallgroup.swapbook.presentation.presenters.BasePresenter;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.view.BaseView;

public interface AuthContract {

    interface View extends BaseView {
        void updateView(FirebaseUser user);
        void showError();
    }

    interface Presenter extends BasePresenter {

        void onAuth(String token);
        void onUpdateView(FirebaseUser user);
    }

    interface Repository extends BaseRepository {

        void firebaseAuthWithGoogle(String idToken);
    }

}
