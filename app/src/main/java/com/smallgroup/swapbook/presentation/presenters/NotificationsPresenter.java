package com.smallgroup.swapbook.presentation.presenters;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.NotificationsContract;
import com.smallgroup.swapbook.presentation.repositories.NotificationsRepository;

import java.util.List;

public class NotificationsPresenter implements NotificationsContract.Presenter {

    NotificationsContract.View mView;
    NotificationsContract.Repository mRepository;

    public NotificationsPresenter(NotificationsContract.View mView) {
        this.mView = mView;
        this.mRepository = new NotificationsRepository(this);
    }

    @Override
    public void onUpdateView(List<Book> books) {
        mView.updateView(books);
    }

    @Override
    public void onLoadUsersBook() {
        mRepository.loadUsersBooks();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}
