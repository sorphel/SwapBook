package com.smallgroup.swapbook.presentation.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.smallgroup.swapbook.R;
import com.smallgroup.swapbook.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class MyCardBookAdapter extends RecyclerView.Adapter<MyCardBookAdapter.MyViewHolder> {

    private List<Book> books = new ArrayList();

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;

        public TextView title;
        public TextView author;
        public ImageView image;

        public MyViewHolder(CardView card) {
            super(card);
            cardView = card;
            title = cardView.findViewById(R.id.card_book_title);
            author = cardView.findViewById(R.id.card_book_author);
            image = cardView.findViewById(R.id.card_image);
        }
    }

    public MyCardBookAdapter(List<Book> books) {
        this.books = books;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book_card, parent, false);

        MyViewHolder holder = new MyViewHolder(cardView);
        return holder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.title.setText(books.get(position).getTitle());
        holder.author.setText(books.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
