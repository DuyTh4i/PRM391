package PRM391.getDriverLicense.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Question.class}, version = 1)
@TypeConverters({QuestionConverters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract QuestionDao questionDao();
}
