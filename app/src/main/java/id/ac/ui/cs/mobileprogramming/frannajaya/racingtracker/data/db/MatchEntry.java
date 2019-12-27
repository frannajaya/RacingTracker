package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "match_db",
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
public class MatchEntry implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;

    @ColumnInfo(name = "race_id")
    private int raceId;

    public MatchEntry(int raceId, String title, String description) {
        this.raceId = raceId;
        this.title = title;
        this.description = description;
    }

    protected MatchEntry(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        raceId = in.readInt();
    }

    public static final Creator<MatchEntry> CREATOR = new Creator<MatchEntry>() {
        @Override
        public MatchEntry createFromParcel(Parcel in) { return new MatchEntry(in); }

        @Override
        public MatchEntry[] newArray(int size) { return new MatchEntry[size]; }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(raceId);
    }
}
