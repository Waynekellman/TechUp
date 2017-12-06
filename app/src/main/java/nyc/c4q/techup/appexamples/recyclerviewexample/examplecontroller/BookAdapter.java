package nyc.c4q.techup.appexamples.recyclerviewexample.examplecontroller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.recyclerviewexample.examplemodel.Book;
import nyc.c4q.techup.appexamples.recyclerviewexample.exampleview.BookViewHolder;

/**
 * Created by amirahoxendine on 12/6/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {
    private List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_view, parent, false);

        return new BookViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.onBind(book);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.toggleLayout();
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
