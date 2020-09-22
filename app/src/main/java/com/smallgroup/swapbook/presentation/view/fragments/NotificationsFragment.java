package com.smallgroup.swapbook.presentation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.NotificationsContract;
import com.smallgroup.swapbook.presentation.presenters.NotificationsPresenter;
import com.smallgroup.swapbook.presentation.view.BaseView;
import com.smallgroup.swapbook.presentation.view.LikedBooksAdapter;

import java.util.List;


public class NotificationsFragment extends Fragment implements NotificationsContract.View {

    NotificationsContract.Presenter mPresenter;

    final int resourceId = R.layout.item_book_notif;

    private LikedBooksAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        mPresenter = new NotificationsPresenter(this);

        recyclerView = view.findViewById(R.id.liked_book_list_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mPresenter.onLoadUsersBook();

        return view;
    }

    @Override
    public void updateView(List<Book> books) {
        if (books != null){
            adapter = new LikedBooksAdapter(books, this.getContext(), resourceId);
            recyclerView.setAdapter(adapter);
        }
    }
}
