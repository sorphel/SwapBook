package com.smallgroup.swapbook.presentation.contracts;

import android.net.Uri;

import com.smallgroup.swapbook.presentation.presenters.BasePresenter;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.view.BaseView;

public interface AddContract {

    interface View extends BaseView {
        void add();
        void close();
        void progressShow();
        void progressClose();
        void showError();
    }

    interface Presenter extends BasePresenter {
        void onAdd(String title, String author, Uri uri);
        void onComplete(boolean isComplete);
        void onCompleteLoadImage(boolean isLoadImage);
    }

    interface Repository extends BaseRepository {
        void uploadToDatabase(String title, String author);
        void uploadImageToStorage(Uri uri);
    }

}
