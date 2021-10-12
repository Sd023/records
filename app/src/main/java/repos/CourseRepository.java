package repos;


import android.app.Application;
import android.util.Patterns;

import androidx.lifecycle.LiveData;

import com.example.records.R;
import com.example.records.data.UserDao;
import com.example.records.data.UserDatabase;

import java.util.List;

import model.Courses;
import model.User;

public class CourseRepository {

    private UserDao RepoUserDao;
    private LiveData<List<Courses>> RepoCourses;

    public CourseRepository(Application application){
        UserDatabase db = UserDatabase.getDatabase(application);
        RepoUserDao = db.userDao();
        RepoCourses = RepoUserDao.getAllCourses();

    }
    public LiveData<List<Courses>> getRepoCourses(){return RepoCourses;}

    public void insert(Courses courses){
        UserDatabase.databaseWriterExecutor.execute(() -> RepoUserDao.insertCourses(courses));
    }
    public void delete(Courses courses){
        UserDatabase.databaseWriterExecutor.execute(() -> RepoUserDao.delete(courses));
    }

    public void deleteAll(){
        UserDatabase.databaseWriterExecutor.execute(() -> RepoUserDao.deleteAll());
    }


}
