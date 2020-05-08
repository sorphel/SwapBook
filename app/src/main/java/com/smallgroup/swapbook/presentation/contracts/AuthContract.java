package com.smallgroup.swapbook.presentation.contracts;

public interface AuthContract extends BaseContract {

    interface View {

    }

    interface Presenter {
        void onAuth();
    }

    interface Repository {
        void auth();
    }

}
