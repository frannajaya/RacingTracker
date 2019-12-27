package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "record_db",
        foreignKeys = @ForeignKey(
            entity = MatchEntry.class,
            parentColumns = "id",
            childColumns = "match_id",
            onDelete = ForeignKey.CASCADE
        ),
        indices = {
                @Index(name = "matchId_index", value = {"match_id"})
        }
)
public class RecordEntry implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "person_name")
    private String personName;
    @ColumnInfo(name = "time_recorded")
    private long timeRecorded;

    @ColumnInfo(name = "match_id")
    private int matchId;

    public RecordEntry(String personName, long timeRecorded) {
        this.personName = personName;
        this.timeRecorded = timeRecorded;
    }

    protected RecordEntry(Parcel in) {
        id = in.readInt();
        personName = in.readString();
        timeRecorded = in.readLong();
        matchId = in.readInt();
    }

    public static final Creator<RecordEntry> CREATOR = new Creator<RecordEntry>() {
        @Override
        public RecordEntry createFromParcel(Parcel in) { return new RecordEntry(in); }

        @Override
        public RecordEntry[] newArray(int size) { return new RecordEntry[size]; }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(personName);
        dest.writeLong(timeRecorded);
        dest.writeInt(matchId);
    }
}
