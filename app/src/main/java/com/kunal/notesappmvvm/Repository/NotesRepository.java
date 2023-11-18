package com.kunal.notesappmvvm.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.kunal.notesappmvvm.Dao.NotesDao;
import com.kunal.notesappmvvm.Database.NotesDatabase;
import com.kunal.notesappmvvm.Model.Notes;

import java.util.List;

public class NotesRepository {

    public NotesDao notesDao;
    public LiveData<List<Notes>> getallNotes;

    public NotesRepository(Application application) {
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getallNotes = notesDao.getallNotes();
    }

    public void insertsNotes(Notes notes) {
        notesDao.insertNotes(notes);
    }

    public void deleteNotes(int id) {
        notesDao.deleteNotes(id);
    }

    public void updateNotes(Notes notes) {
        notesDao.updateNotes(notes);
    }

}
