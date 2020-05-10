package com.smallgroup.swapbook.presentation.contracts;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.presenters.BasePresenter;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.view.BaseView;

import java.util.List;

public interface SearchContract {

    interface View extends BaseView {
        void loadCard();
        void updateView(List<Book> books);
    }

    interface Presenter extends BasePresenter {
        void onLoadBooks();
        void onUpdateView(List<Book> books);
    }

    interface Repository extends BaseRepository {
        void loadBooks();
    }

}
