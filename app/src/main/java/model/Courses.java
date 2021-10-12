package model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses_table")
public class Courses {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "table_column_name")
    private String courseName;

    public Courses(@NonNull String courseName, @NonNull String staffName) {
        this.courseName = courseName;
        this.staffName = staffName;
    }

    @NonNull
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(@NonNull String courseName) {
        this.courseName = courseName;
    }

    @NonNull
    @ColumnInfo(name = "StaffName")
    private String staffName;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
