package pl.kamil.lopuszynski;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import pl.kamil.lopuszynski.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private Button button;
    private List<Integer> numbers = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter;
    private final int limit = 30;
    private final int max = 20;
    private final int min = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this, numbers);
        recyclerViewAdapter.setClickListener(this);
        addNumbers();


    }

    public void addNumbers() {
        for (int i = 0; i < limit; i++) {
            // numbers.add((int)(Math.random()*((max-min)+1))+min); // sposób 1
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(max) + 1; // sposób 2
            numbers.add(randomInt);
        }
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void random(View view) {
        numbers.clear();
        addNumbers();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Selected number : " + recyclerViewAdapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
