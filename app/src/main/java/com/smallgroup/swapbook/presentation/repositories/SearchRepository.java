package com.smallgroup.swapbook.presentation.repositories;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.SearchContract;

import java.util.ArrayList;
import java.util.List;

public class SearchRepository implements SearchContract.Repository {

    private SearchContract.Presenter mPresenter;
    private List<Book> books = new ArrayList();

    public SearchRepository(SearchContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public List<Book> loadBooks() {
        return null;
    }
}