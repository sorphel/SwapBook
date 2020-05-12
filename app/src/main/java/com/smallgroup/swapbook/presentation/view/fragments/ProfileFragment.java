package com.smallgroup.swapbook.presentation.view.fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.presentation.contracts.ProfileContract;
import com.smallgroup.swapbook.presentation.presenters.ProfilePresenter;
import com.smallgroup.swapbook.presentation.view.BaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileContract.View {

    private Button mSignOut;
    private TextView mEmail, mName;
    private ImageView mImageView;

    private ProfileContract.Presenter mPresenter;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mPresenter = new ProfilePresenter(this);

        mImageView = view.findViewById(R.id.user_image);
        mEmail = view.findViewById(R.id.user_email);
        mName = view.findViewById(R.id.user_name);
        mSignOut = view.findViewById(R.id.sign_out_button);
        mSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOutClick();
            }
        });

        mPresenter.onLoadData();

        return view;
    }

    @Override
    public void signOutClick() {
        mPresenter.onSignOut();
        getActivity().finish();
    }

    @Override
    public void uploadImage(Uri uri) {
        Glide.with(getContext())
                .load(uri)
                .circleCrop()
                .into(mImageView);
    }

    @Override
    public void setEmail(String email) {
        mEmail.setText(email);
    }

    @Override
    public void setName(String name) {
        mName.setText(name);
    }
}
