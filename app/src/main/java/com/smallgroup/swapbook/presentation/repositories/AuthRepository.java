package com.smallgroup.swapbook.presentation.repositories;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.smallgroup.swapbook.presentation.contracts.AuthContract;
import com.smallgroup.swapbook.presentation.presenters.AuthPresenter;

import java.util.concurrent.Executor;

public class AuthRepository implements AuthContract.Repository {

    private AuthPresenter mPresenter;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();;
    private GoogleSignInClient mGoogleSignInClient;


    public AuthRepository(AuthPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            mPresenter.onUpdateView(user);
                        } else {
                            mPresenter.onUpdateView(null);
                        }
                    }
                });
    }

}
