package com.smallgroup.swapbook.presentation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.SearchContract;
import com.smallgroup.swapbook.presentation.presenters.SearchPresenter;
import com.smallgroup.swapbook.presentation.view.MyCardBookAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements SearchContract.View, CardStackListener {

    private ProgressBar progressBar;
    private Button mLike;
    private Button mDislike;

    CardStackView cardStackView;
    MyCardBookAdapter cardAdapter;
    CardStackLayoutManager layoutManager;

    SearchContract.Presenter mPresenter;

    final int resource = R.layout.item_book_card;

    public SearchFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        mPresenter = new SearchPresenter(this);

        mLike = (Button) view.findViewById(R.id.like_button);
        mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeAnimationSetting swipeLike = new SwipeAnimationSetting.Builder().setDirection(Direction.Right)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                layoutManager.setSwipeAnimationSetting(swipeLike);
                cardStackView.swipe();
            }
        });

        mDislike = (Button) view.findViewById(R.id.dislike_button);
        mDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwipeAnimationSetting swipeLike = new SwipeAnimationSetting.Builder().setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                layoutManager.setSwipeAnimationSetting(swipeLike);
                cardStackView.swipe();
            }
        });

        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        cardStackView = view.findViewById(R.id.card_stack_view);

        layoutManager = new CardStackLayoutManager(this.getContext(), this);
        layoutManager.setMaxDegree(0);
        layoutManager.setCanScrollVertical(false);

        loadCard();

        cardStackView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void updateView(List<Book> books) {
        progressBar.setVisibility(View.INVISIBLE);
        cardAdapter = new MyCardBookAdapter(this.getActivity().getApplicationContext(), books, resource);
        cardStackView.setAdapter(cardAdapter);
    }

    @Override
    public void loadCard() {
        mPresenter.onLoadBooks();
    }


    @Override
    public void onCardDragging(Direction direction, float ratio) {

    }

    @Override
    public void onCardSwiped(Direction direction) {
        if (direction == Direction.Right){
            Toast.makeText(getContext(), "Liked", Toast.LENGTH_SHORT).show();
        }
        else if (direction == Direction.Left){
            Toast.makeText(getContext(), "Disliked", Toast.LENGTH_SHORT).show();
        }
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
