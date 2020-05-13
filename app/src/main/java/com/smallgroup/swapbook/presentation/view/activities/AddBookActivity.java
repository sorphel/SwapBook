package com.smallgroup.swapbook.presentation.view.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.presentation.contracts.AddContract;
import com.smallgroup.swapbook.presentation.presenters.AddPresenter;

import java.io.IOException;

public class AddBookActivity extends AppCompatActivity implements AddContract.View {

    private static final int IMAGE_REQUEST = 71;

    private Uri filePath;

    private AddContract.Presenter mPresenter;

    private ImageButton image;
    private ProgressBar progressBar;
    private EditText mTitle, mAuthor;
    private Button mUploadButton, mCloseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        getSupportActionBar().hide();

        mPresenter = new AddPresenter(this);

        progressBar = findViewById(R.id.progress_bar);
        mTitle = findViewById(R.id.book_title);
        mAuthor = findViewById(R.id.book_author);
        mUploadButton = findViewById(R.id.upload);
        mCloseButton = findViewById(R.id.close);

        mUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });

        image = findViewById(R.id.add_image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage(v);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();

            Glide.with(getApplicationContext())
                    .load(filePath)
                    .into(image);
        }
    }

    @Override
    public void add(){
        //TODO mPresenter.uploadBook()
        String title = mTitle.getText().toString();
        String author = mAuthor.getText().toString();
        if (!title.equals("") && !author.equals("") && filePath != null){
            mPresenter.onAdd(title, author, filePath);
        }
        else {
            Toast.makeText(this,"Заполните все поля", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void close(){
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void progressShow() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void progressClose() {
        progressBar.setVisibility(View.INVISIBLE);

        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void showError() {
        Toast.makeText(this,"Ошибка загрузки", Toast.LENGTH_LONG).show();
    }


    public void chooseImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), IMAGE_REQUEST);
    }
}
