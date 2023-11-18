package com.kunal.notesappmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kunal.notesappmvvm.Activity.InsertNotesActivity;
import com.kunal.notesappmvvm.Adapter.NotesAdapter;
import com.kunal.notesappmvvm.ViewModel.NotesViewModel;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton newNotesBtn;
    NotesViewModel notesViewModel;
    RecyclerView notesRecycler;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn = findViewById(R.id.NewNotesBtn);
        notesRecycler = findViewById(R.id.notesRecycler);


        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        newNotesBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, InsertNotesActivity.class));
        });

        notesViewModel.getAllNotes.observe(this, notes -> {
            notesRecycler.setLayoutManager(new GridLayoutManager(this, 2));
            adapter = new NotesAdapter(MainActivity.this, notes);
            notesRecycler.setAdapter(adapter);
        });
    }
}