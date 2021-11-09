package PRM391.getDriverLicense.model;

import androidx.room.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


@Entity(tableName = "questions")
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String description; // Nội dung của câu hỏi

    @ColumnInfo
    private ArrayList<String> answer; // Các đáp án để lựa chọn

    @ColumnInfo
    private ArrayList<Integer> result; // Đáp án đúng

    @ColumnInfo
    private String pathImage; // Đường dẫn ảnh nếu có

    @Ignore
    private ArrayList<Integer> userRsult;

    public Question() {

    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", answer=" + answer +
                ", result=" + result +
                ", pathImage='" + pathImage + '\'' +
                ", userRsult=" + userRsult +
                '}';
    }

    public Question(String _description, ArrayList<String> _answer, ArrayList<Integer> _result, String _pathImage) {
        this.description = _description;
        this.answer = _answer;
        this.result = _result;
        this.pathImage = _pathImage;
        this.userRsult = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public ArrayList<Integer> getUserRsult() {
        return userRsult;
    }

    public void setUserRsult(ArrayList<Integer> userRsult) {
        this.userRsult = userRsult;
    }
}