package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Racedb")
public class RaceEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;

    public RaceEntry(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
