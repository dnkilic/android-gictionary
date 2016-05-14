package com.dnkilic.gictionary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    ArrayList<Word> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvWord;
        public TextView tvMeaningList;

        public ViewHolder(View v) {
            super(v);
            tvWord = (TextView) v.findViewById(R.id.tvWord);
            tvMeaningList = (TextView) v.findViewById(R.id.tvMeaningList);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public WordAdapter(ArrayList<Word> result) {
        mDataset = result;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translation_result, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvWord.setText(mDataset.get(position).getWord());

        StringBuilder result = new StringBuilder();

        for(String meaning : mDataset.get(position).getMeaningList())
        {
            result.append(meaning);
            result.append("\n");
        }

        holder.tvMeaningList.setText(result.toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}