package com.example.abdi.recycle_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * Views, adapters and managers used
     */
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Random random;

    ArrayList<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        numbers = generateNumbers(200);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);


        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomAdapter(numbers);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Integer> generateNumbers(int amount){
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            tmp.add(random.nextInt(10000));
        }
        return tmp;
    }

}
