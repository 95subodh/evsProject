package project.is.IrVerde;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityListAdapter extends RecyclerView.Adapter<MainActivityListAdapter.ViewHolder> {

    private Context context;
    private String Titles[];
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        Context mContext;
        public TextView mTitle;
        public ViewHolder(View view,Context c) {
            super(view);
            mContext = c;
            mTitle = (TextView) view.findViewById(R.id.title);
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getClass(),"Item Clicked is:" + MainActivity.na[getPosition()-1],Toast.LENGTH_SHORT).show();
            int id=getPosition();


        }
    }

    public MainActivityListAdapter(Context context, ArrayList<MainActivityListItem> items) {
//        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
        this.mDataSet = items;
    }



    // Create new views (invoked by the layout manager)
    @Override
    public MainActivityListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view

        //RecyclerView.Adapter
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        //TextView mTitleTextView = (TextView) v.findViewById(R.id.title);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTitle.setText(mDataSet.get(position).getTitle());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
