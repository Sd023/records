package Adapter;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import model.Courses;
import repos.CourseRepository;

public class CourseViewModel extends AndroidViewModel {
    private CourseRepository courseRepository;
    private final LiveData<List<Courses>> data;

    public CourseViewModel (Application application) {
        super(application);
        courseRepository = new CourseRepository(application);
        data = courseRepository.getRepoCourses();
    }

   public LiveData<List<Courses>> getData(){
        return data; }

        public void insert (Courses courses){
        courseRepository.insert(courses);
        }

        public void delete(Courses courses){courseRepository.delete(courses);}

        public void deleteAll(){courseRepository.deleteAll();}

}
