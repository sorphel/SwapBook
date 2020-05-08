package com.smallgroup.swapbook.presentation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.SearchContract;
import com.smallgroup.swapbook.presentation.presenters.SearchPresenter;
import com.smallgroup.swapbook.presentation.view.BaseView;
import com.smallgroup.swapbook.presentation.view.MyCardBookAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SearchContract.View, CardStackListener {

    CardStackView cardStackView;
    MyCardBookAdapter cardAdapter;
    CardStackLayoutManager layoutManager;
    List<Book> books = new ArrayList();

    SearchContract.Presenter mPresenter;

    public SearchFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        mPresenter = new SearchPresenter(this);

        cardStackView = view.findViewById(R.id.card_stack_view);

        layoutManager = new CardStackLayoutManager(this.getContext(), this);
        layoutManager.setMaxDegree(0);
        layoutManager.setCanScrollVertical(false);

        cardAdapter = new MyCardBookAdapter(books);
        loadCard();
        cardStackView.setAdapter(cardAdapter);
        cardStackView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void loadCard() {
        books = mPresenter.onLoadBooks();
    }

    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {

    }

    @Override
    public void onCardRewound() {

    }

    @Override
    public void onCardCanceled() {

    }

    @Override
    public void onCardAppeared(View view, int position) {

    }

    @Override
    public void onCardDisappeared(View view, int position) {

    }

}