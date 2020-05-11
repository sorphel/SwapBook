package com.smallgroup.swapbook.presentation.presenters;

import android.net.Uri;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.AddContract;
import com.smallgroup.swapbook.presentation.repositories.AddRepository;

public class AddPresenter implements AddContract.Presenter {

    private AddContract.View mView;
    private AddContract.Repository mRepository;

    private String mTitle, mAuthor;

    public AddPresenter(AddContract.View mView) {
        this.mView = mView;
        mRepository = new AddRepository(this);
    }

    @Override
    public void onAdd(String title, String author, Uri uri) {
        mTitle = title;
        mAuthor = author;
        mView.progressShow();
        mRepository.uploadImageToStorage(uri);
    }

    @Override
    public void onComplete(boolean isComplete) {
        if (isComplete){
            mView.progressClose();
        }
        else{
            mView.showError();
            mView.progressClose();
        }
    }

    @Override
    public void onCompleteLoadImage(boolean isLoadImage) {
        if (isLoadImage) {
            mRepository.uploadToDatabase(mTitle, mAuthor);
        }
        else {
            mView.showError();
            mView.progressClose();
        }
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
