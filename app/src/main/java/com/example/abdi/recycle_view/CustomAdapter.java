package com.example.abdi.recycle_view;

import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Integer> numbers;

    public CustomAdapter(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_textview, parent, false);
        TextView tv = v.findViewById(R.id.test_tv);
        ViewHolder vh = new ViewHolder(v, tv);
        return vh;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.ViewHolder holder, int position) {
        final String message = String.format("Setting textview for position: %s", position);
        Log.i("Holder", message);
        holder.textView.setText(numbers.get(position).toString());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(holder.getAdapterPosition(), v);
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.i("Holder", String.format("Getting item count: %s", numbers.size()));
        return numbers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public View frameLayout;

        public ViewHolder(View frameLayout, TextView v) {
            super(frameLayout);
            textView = v;
        }
    }

    public void deleteItem(final int position, View v) {
        String message = String.format("Removing item at position: %s with value: %s", position, numbers.get(position));
        Log.i("Holder", message);
        final int number = numbers.get(position);
        Snackbar snack = Snackbar.make(v, message, LENGTH_LONG);
        snack.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.add(position, number);
                notifyDataSetChanged();
            }
        });
        snack.show();
        numbers.remove(position);
        notifyDataSetChanged();
    }

}
