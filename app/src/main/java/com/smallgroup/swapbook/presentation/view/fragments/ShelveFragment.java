package com.smallgroup.swapbook.presentation.view.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.ShelveContract;
import com.smallgroup.swapbook.presentation.presenters.ShelvePresenter;
import com.smallgroup.swapbook.presentation.view.BaseView;
import com.smallgroup.swapbook.presentation.view.MyCardBookAdapter;
import com.smallgroup.swapbook.presentation.view.activities.AddBookActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelveFragment extends Fragment implements ShelveContract.View {

    ShelveContract.Presenter mPresenter;

    MyCardBookAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton addButton;

    final int resourceId = R.layout.item_book_shelve;

    private final int ADD_REQUEST = 77;

    public ShelveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelve, container, false);

        mPresenter = new ShelvePresenter(this);
        recyclerView = view.findViewById(R.id.book_list_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        addButton = view.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddBook();
            }
        });

        mPresenter.onLoadUsersBook();

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_REQUEST && resultCode == getActivity().RESULT_OK){
            mPresenter.onLoadUsersBook();
        }
    }

    @Override
    public void updateView(List<Book> books) {
        if (books != null) {
            adapter = new MyCardBookAdapter(this.getContext(), books, resourceId);
            recyclerView.setAdapter(adapter);
            //Toast.makeText(getContext(), books.get(0).getUrl(), Toast.LENGTH_LONG).show();
        }
    }

    public void onAddBook(){
        Intent intent = new Intent(this.getActivity(), AddBookActivity.class);
        this.getActivity().startActivityForResult(intent, ADD_REQUEST);
    }
}
