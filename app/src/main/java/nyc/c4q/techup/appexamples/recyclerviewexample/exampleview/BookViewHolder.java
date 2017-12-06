package nyc.c4q.techup.appexamples.recyclerviewexample.exampleview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.recyclerviewexample.ExampleDescriptionActivity;
import nyc.c4q.techup.appexamples.recyclerviewexample.examplemodel.Book;

/**
 * Created by amirahoxendine on 12/6/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener{
    private ImageView bookCover;
    private TextView bookTitle;
    private TextView bookAuthor;
    private TextView publishingYear;
    private Button moreButton;
    private final Context context;
    private Bundle bookDescription;
    private RatingBar test;
    private LinearLayout frontLayout;
    private LinearLayout backLayout;
    private boolean layoutFront = true;
    private boolean clicked = false;



    public BookViewHolder(View itemView) {
        super(itemView);
        bookCover = (ImageView) itemView.findViewById(R.id.bookcover_imageview);
        bookTitle = (TextView) itemView.findViewById(R.id.book_title_textview);
        bookAuthor = (TextView) itemView.findViewById(R.id.book_author_textview);
        publishingYear = (TextView) itemView.findViewById(R.id.publishing_year_textview);
        moreButton = (Button) itemView.findViewById(R.id.more_button);
        frontLayout = (LinearLayout) itemView.findViewById(R.id.front_layout);
        backLayout = (LinearLayout) itemView.findViewById(R.id.back_layout);
        test = (RatingBar) itemView.findViewById(R.id.ratingBar);

        context = itemView.getContext();


    }

    public void onBind(Book book) {
        bookCover.setImageResource(book.getBookCover());
        bookTitle.setText(book.getBookTitle());
        bookAuthor.setText(book.getBookAuthor());
        publishingYear.setText(book.getPublishingYear());
        test.setRating(4);
        bookDescription = new Bundle();
        bookDescription.putString("description", book.getDescription());
        bookDescription.putString("bookTitle", book.getBookTitle());
        bookDescription.putString("bookAuthor", book.getBookAuthor());
        bookDescription.putString("publishingYear", book.getPublishingYear());
        bookDescription.putInt("bookCover", book.getBookCover());
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreatePopupMenu(v);
            }
        });


    }
    public void onCreatePopupMenu(View v) {
        PopupMenu popup = new PopupMenu(context, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(this);
        inflater.inflate(R.menu.example_book_pop_up, popup.getMenu());
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()){
            case R.id.description_item:
                Intent descriptionIntent = new Intent(context, ExampleDescriptionActivity.class);
                descriptionIntent.putExtras(bookDescription);
                context.startActivity(descriptionIntent);
                break;
            case R.id.addtolist_item:
                Toast.makeText(context, "book added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.review_item:

                break;

        }
        return false;
    }

    public void toggleLayout() {
        if (layoutFront){
            frontLayout.setVisibility(View.GONE);
            backLayout.setVisibility(View.VISIBLE);
            layoutFront = false;

        }else {
            frontLayout.setVisibility(View.VISIBLE);
            backLayout.setVisibility(View.GONE);
            layoutFront = true;

        }
    }

    public boolean isLayoutFront() {
        return layoutFront;
    }

    public boolean isClicked() {
        return clicked;
    }
}