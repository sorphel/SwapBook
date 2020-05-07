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
public class NotificationsFragment extends Fragment implements BaseView {

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        updateView();
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void updateView() {

    }
}
