package com.smallgroup.swapbook.presentation.presenters;

import com.smallgroup.swapbook.presentation.contracts.BaseContract;

public interface BasePresenter extends BaseContract.Presenter {

    void onCreate();
    void onDestroy();

}
