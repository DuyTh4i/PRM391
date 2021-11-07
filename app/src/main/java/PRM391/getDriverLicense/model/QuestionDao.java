package PRM391.getDriverLicense.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert
    void insert(Question question);

    @Insert
    void insertAll(Question... questions);

    @Delete
    void delete(Question question);

    @Query("SELECT * FROM questions")
    List<Question> getAll();

    @Query("SELECT * FROM questions WHERE id = :questionId LIMIT 1")
    Question findQuestionById(int questionId);

    @Query("DELETE FROM questions")
    void clearQuestionsTable();

}
