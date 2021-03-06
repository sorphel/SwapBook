package com.smallgroup.swapbook.presentation.repositories;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smallgroup.swapbook.data.DataBaseManager;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.SearchContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRepository implements SearchContract.Repository {

    private static final String BOOKS = "books";
    private static final String USERS = "users";
    private static final String LIKED = "liked";

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private SearchContract.Presenter mPresenter;
    private Map<String,Object> data = new HashMap();
    private List<Book> bookList = new ArrayList();
    private String currentUser = FirebaseAuth.getInstance().getCurrentUser().getEmail();

    public SearchRepository(SearchContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void loadBooks() {
        db.collection(BOOKS)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                            Book book = new Book((HashMap<String, Object>) document.getData());
                            if (!book.getIdUser().equals(currentUser)) {
                                bookList.add(book);
                            }
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

    @Override
    public void addLiked(Book likedBook) {
        data = likedBook.convertToMap();

        db.collection(USERS)
                .document(currentUser)
                .collection(LIKED)
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }
}
