package com.smallgroup.swapbook.presentation.contracts;

import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.presenters.BasePresenter;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.view.BaseView;

import java.util.List;

public interface NotificationsContract {

    interface View extends BaseView {
        void updateView(List<Book> books);
    }

    interface Presenter extends BasePresenter {
        void onUpdateView(List<Book> books);
        void onLoadUsersBook();
    }

    interface Repository extends BaseRepository {
        void loadUsersBooks();
    }

}
