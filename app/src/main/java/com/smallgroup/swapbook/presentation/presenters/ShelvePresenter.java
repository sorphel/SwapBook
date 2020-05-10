package com.smallgroup.swapbook.presentation.presenters;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.ShelveContract;
import com.smallgroup.swapbook.presentation.repositories.ShelveRepository;

import java.util.List;

public class ShelvePresenter implements ShelveContract.Presenter {

    ShelveContract.View mView;
    ShelveContract.Repository mRepository;

    public ShelvePresenter(ShelveContract.View mView) {
        this.mView = mView;
        this.mRepository = new ShelveRepository(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onUpdateView(List<Book> books) {
        mView.updateView(books);
    }

    @Override
    public void onLoadUsersBook() {
        mRepository.loadUsersBooks();
    }
}
