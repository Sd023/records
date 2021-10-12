package Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;


import model.Courses;
public class CourseListAdapter extends ListAdapter<Courses, CourseViewHolder> {

    public CourseListAdapter(@NonNull DiffUtil.ItemCallback<Courses> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CourseViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Courses current = getItem(position);
        holder.bind(current.getCourseName(),current.getStaffName());
    }
    public Courses getPos(int position ){
        return getItem(position);
    }


    public static class CourseD extends DiffUtil.ItemCallback<Courses> {

        @Override
        public boolean areItemsTheSame(@NonNull Courses oldItem, @NonNull Courses newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Courses oldItem, @NonNull Courses newItem) {
            return oldItem.getCourseName().equals(newItem.getCourseName());
        }
    }
}