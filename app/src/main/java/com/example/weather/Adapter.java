package com.example.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.TestRecyclerHolder> {
    List<String> myCity;
    EditText edt;
    public Adapter(List<String> myCity,EditText edt) {
        this.myCity = myCity;
        this.edt=edt;
    }

    @NonNull
    @Override
    public TestRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_recycler_item, parent, false);
        TestRecyclerHolder holder = new TestRecyclerHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TestRecyclerHolder holder, int position) {
        String name = myCity.get(position);
        holder.txtCity.setText(name);
        holder.txtCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.setText(holder.txtCity.getText());
            }
        });

    }
    @Override
    public int getItemCount() {
        return myCity.size();
    }

    class TestRecyclerHolder extends RecyclerView.ViewHolder {
        TextView txtCity;
        EditText edtSearch;

        public TestRecyclerHolder(@NonNull View itemView) {
            super(itemView);
            txtCity = itemView.findViewById(R.id.txtCity);
            edtSearch = itemView.findViewById(R.id.edtSearch);
        }
    }
}
