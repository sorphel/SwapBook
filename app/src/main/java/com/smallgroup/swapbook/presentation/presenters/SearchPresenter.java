package com.smallgroup.swapbook.presentation.presenters;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.SearchContract;
import com.smallgroup.swapbook.presentation.repositories.SearchRepository;

import java.util.List;

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View mView;
    private SearchContract.Repository mRepository;

    public SearchPresenter(SearchContract.View mView) {
        this.mView = mView;
        this.mRepository = new SearchRepository(this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onLoadBooks() {
        mRepository.loadBooks();
    }

    @Override
    public void onUpdateView(List<Book> books) {
        mView.updateView(books);
    }


}
