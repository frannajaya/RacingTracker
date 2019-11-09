package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Matchdb",
        foreignKeys = @ForeignKey(
            entity= RaceEntry.class,
            parentColumns = "id",
            childColumns = "race_id",
            onDelete = ForeignKey.CASCADE
        ),
        indices = {
                @Index(name = "raceId_index", value = {"race_id"})
        }
)
public class MatchEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "race_id") private int raceId;
    private String title;
    private String description;

    public MatchEntry(int raceId, String title, String description) {
        this.raceId = raceId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
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
