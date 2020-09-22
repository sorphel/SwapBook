package com.smallgroup.swapbook.presentation.repositories;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.NotificationsContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotificationsRepository implements NotificationsContract.Repository {

    private NotificationsContract.Presenter mPresenter;

    private static final String USERS = "users";
    private static final String LIKED = "liked";

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private List<Book> bookList = new ArrayList();
    private String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();

    public NotificationsRepository(NotificationsContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void loadUsersBooks() {
        db.collection(USERS)
                .document(user)
                .collection(LIKED)
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
