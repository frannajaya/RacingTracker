package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Record",
        foreignKeys = @ForeignKey(
            entity = MatchEntry.class,
            parentColumns = "id",
            childColumns = "match_id",
            onDelete = ForeignKey.CASCADE
        )
)
public class RecordEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "person_name") private String personName;
    @ColumnInfo(name = "time_recorded") private long timeRecorded;
    @ColumnInfo(name = "match_id") private int matchId;

    public RecordEntry(String personName, long timeRecorded) {
        this.personName = personName;
        this.timeRecorded = timeRecorded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public long getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(long timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
}
