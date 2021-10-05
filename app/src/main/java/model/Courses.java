package model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses_table")
public class Courses {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name ="table_column_name")
    private String courseName;

    public Courses(@NonNull String courseName) {
        this.courseName = courseName;
    }

    @NonNull
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(@NonNull String courseName) {
        this.courseName = courseName;
    }
}
