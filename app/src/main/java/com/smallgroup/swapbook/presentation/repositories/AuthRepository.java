package com.smallgroup.swapbook.presentation.repositories;

import com.smallgroup.swapbook.presentation.contracts.AuthContract;
import com.smallgroup.swapbook.presentation.contracts.BaseContract;
import com.smallgroup.swapbook.presentation.presenters.AuthPresenter;

public class AuthRepository implements BaseContract.Repository, AuthContract.Repository {

    private AuthPresenter mPresenter;

    public AuthRepository(AuthPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void auth() {

    }
}
