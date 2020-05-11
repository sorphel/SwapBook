package com.smallgroup.swapbook.presentation.repositories;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.smallgroup.swapbook.domain.Book;
import com.smallgroup.swapbook.presentation.contracts.AddContract;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddRepository implements AddContract.Repository {

    private static final String BOOKS = "books";
    private static final String USERS = "users";
    private static final String SHELVE = "shelve";
    private static final String IMG = "img/";
    private static final String LINK = "gs://swapbook-654f4.appspot.com/img/";
    private String uid;

    private Map<String,Object> data = new HashMap();

    private AddContract.Presenter mPresenter;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public AddRepository(AddContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void uploadToDatabase(String title, String author) {
        String img_link = LINK + uid;
        String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        Book book = new Book(title, author, img_link, user);
        data = book.convertToMap();

        db.collection(BOOKS)
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                });

        db.collection(USERS)
                .document(user)
                .collection(SHELVE)
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        mPresenter.onComplete(true);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        mPresenter.onComplete(false);
                    }
                });
    }

    @Override
    public void uploadImageToStorage(Uri uri) {
        uid = UUID.randomUUID().toString();
        StorageReference reference = FirebaseStorage.getInstance().getReference().child(IMG+uid);

        reference.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        mPresenter.onCompleteLoadImage(true);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        mPresenter.onCompleteLoadImage(false);
                    }
                });
    }
}
