package com.smallgroup.swapbook.data;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.repositories.BaseRepository;
import com.smallgroup.swapbook.presentation.repositories.SearchRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseManager {

    private static final String BOOKS = "books";
    private static final String USERS = "users";
    private static final String SHELVE = "shelve";


    FirebaseStorage storage;
    StorageReference storageReference;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private Map<String, Object> data;
    private List<Book> bookList= new ArrayList();


    public DataBaseManager() {
    }

    public void loadBooks(){

        db.collection(BOOKS)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                                Book book = new Book((HashMap<String, Object>) document.getData());
                                bookList.add(book);
                            }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }

    public void loadUserBooks(){

    }

    public void addBook(Book book){
        data = book.convertToMap();
        String userId = book.getIdUser();

        db.collection(USERS)
                .document(userId)
                .collection(SHELVE)
                .add(data)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {

                    }
                });

        db.collection(BOOKS)
                .add(data)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {

                    }
                });
    }

    public List<Book> getAllBooks(){
        return bookList;
    }

    public void getAllUsersBooks(){

    }

}
