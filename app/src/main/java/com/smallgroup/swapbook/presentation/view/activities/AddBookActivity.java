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
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.smallgroup.swapbook.R;

import java.io.IOException;

public class AddBookActivity extends AppCompatActivity {

    private static final int IMAGE_REQUEST = 71;

    private Uri filePath;

    private ImageButton image;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        image = findViewById(R.id.add_image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage(v);
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Загрузка...");
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

    public void add(){
        //TODO mPresenter.uploadBook()
        setResult(RESULT_OK);
        finish();
    }

    public void close(){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void dialogShow(){
        progressDialog.show();
    }

    public void dialogDismiss(){
        progressDialog.dismiss();
    }

    public void chooseImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), IMAGE_REQUEST);
    }
}
