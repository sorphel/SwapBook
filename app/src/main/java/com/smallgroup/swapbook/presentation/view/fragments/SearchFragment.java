package com.smallgroup.swapbook.presentation.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.presentation.view.BaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements BaseView {

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        updateView();
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void updateView() {

    }
}
