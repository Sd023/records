package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.records.R;

public class CourseViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;
    private final TextView staffText;

    private CourseViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.course_name);
        staffText = itemView.findViewById(R.id.staff_name);

    }

    public void bind(String text, String text2) {
        textView.setText(text);
        staffText.setText(text2);
    }

    static CourseViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new CourseViewHolder(view);
    }
}


