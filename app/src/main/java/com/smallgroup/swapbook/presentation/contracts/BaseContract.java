package com.smallgroup.swapbook.presentation.contracts;

import com.smallgroup.swapbook.presentation.presenters.BasePresenter;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.view.BaseView;

public interface BaseContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter {

    }

    interface Repository extends BaseRepository{

    }
}
