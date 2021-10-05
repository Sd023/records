package repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.records.data.UserDao;
import com.example.records.data.UserDatabase;

import java.util.List;

import model.Courses;

public class CourseRepository {

    private UserDao RepoUserDao;
    private LiveData<List<Courses>> RepoCourses;

    public CourseRepository(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        RepoUserDao = db.userDao();
        RepoCourses = RepoUserDao.getAllCourses();
    }

   public LiveData<List<Courses>> getRepoCourses(){
        return RepoCourses;
    }

    public void insert(Courses courses) {
        UserDatabase.databaseWriteExecutor.execute(() -> {
            RepoUserDao.insertCourses(courses);
        });
    }

    public void delete(Courses courses){
        UserDatabase.databaseWriteExecutor.execute(() -> {
            RepoUserDao.delete(courses);
        });
    }

    public  void deleteAll(){
        UserDatabase.databaseWriteExecutor.execute(() -> RepoUserDao.deleteAll());
    }


}
