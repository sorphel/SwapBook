package com.smallgroup.swapbook.presentation.repositories;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.ShelveContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShelveRepository implements ShelveContract.Repository {

    private static final String USERS = "users";
    private static final String SHELVE = "shelve";

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private ShelveContract.Presenter mPresenter;
    private List<Book> bookList = new ArrayList();
    private String uid = FirebaseAuth.getInstance().getCurrentUser().getEmail();

    public ShelveRepository(ShelveContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void loadUsersBooks() {
        //TODO add user documents
        db.collection(USERS)
                .document(uid)
                .collection(SHELVE)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                            Book book = new Book((HashMap<String, Object>) document.getData());
                            bookList.add(book);
                        }
                        mPresenter.onUpdateView(bookList);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
}
