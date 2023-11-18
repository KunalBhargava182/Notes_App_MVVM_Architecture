package com.kunal.notesappmvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kunal.notesappmvvm.Model.Notes;
import com.kunal.notesappmvvm.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    public NotesRepository repository;
    public LiveData<List<Notes>> getAllNotes;


    public NotesViewModel(Application application) {
        super(application);


        repository = new NotesRepository(application);
        getAllNotes = repository.getallNotes;

    }

    public void insertNote(Notes notes) {
        repository.insertsNotes(notes);
    }

    public void deleteNote(int id) {
        repository.deleteNotes(id);
    }

    public void updateNote(Notes notes) {
        repository.updateNotes(notes);
    }

}
