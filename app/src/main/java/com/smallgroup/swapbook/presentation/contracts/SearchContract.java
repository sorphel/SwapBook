package com.smallgroup.swapbook.presentation.contracts;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.presenters.BasePresenter;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.view.BaseView;

import java.util.List;

public interface SearchContract {

    interface View extends BaseView {
        void loadCard();
    }

    interface Presenter extends BasePresenter {
        List<Book> onLoadBooks();
    }

    interface Repository extends BaseRepository {
        List<Book> loadBooks();
    }

}
