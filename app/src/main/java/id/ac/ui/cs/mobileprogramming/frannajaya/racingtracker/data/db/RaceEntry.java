package id.ac.ui.cs.mobileprogramming.frannajaya.racingtracker.data.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "race_db")
public class RaceEntry implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;

    public RaceEntry(String title, String description) {
        this.title = title;
        this.description = description;
    }

    protected RaceEntry(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public static final Creator<RaceEntry> CREATOR = new Creator<RaceEntry>() {
        @Override
        public RaceEntry createFromParcel(Parcel in) { return new RaceEntry(in); }

        @Override
        public RaceEntry[] newArray(int size) { return new RaceEntry[size]; }
    };

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


    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
    }
}
