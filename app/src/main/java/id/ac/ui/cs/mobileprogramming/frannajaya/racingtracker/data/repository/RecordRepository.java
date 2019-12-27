package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.repository;

import android.content.Context;

import androidx.room.Room;

import id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db.RaceTrackerDatabase;

public class RecordRepository {
    private RaceTrackerDatabase RTDatabase;

    // Constructor to initialize MatchRepository
    public RecordRepository(Context context) {
        RTDatabase = RaceTrackerDatabase.getTrackerDatabase(context);
    }

//    NoteRepository noteRepository = new NoteRepository(getApplicationContext());
//    String title = "This is the title of the third task";
//    String description = "This is the description of the third task";
//   noteRepository.insertTask(title, description);

//    NoteRepository noteRepository = new NoteRepository(getApplicationContext());
//
//noteRepository.getTasks().observe(appContext, new Observer<List<Note>>() {
//        @Override
//        public void onChanged(@Nullable List<Note> notes) {
//            for(Note note : notes) {
//                System.out.println("-----------------------");
//                System.out.println(note.getId());
//                System.out.println(note.getTitle());
//                System.out.println(note.getDescription());
//                System.out.println(note.getCreatedAt());
//                System.out.println(note.getModifiedAt());
//                System.out.println(note.getPassword());
//                System.out.println(note.isEncrypt());
//            }
//        }
//    });

//    NoteRepository noteRepository = new NoteRepository(getApplicationContext());
//    Note note = noteRepository.getTask(2);
}
