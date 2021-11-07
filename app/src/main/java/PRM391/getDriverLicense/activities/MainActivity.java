package PRM391.getDriverLicense.activities;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;

import PRM391.getDriverLicense.R;
import PRM391.getDriverLicense.model.AppDatabase;
import PRM391.getDriverLicense.model.Question;
import PRM391.getDriverLicense.model.QuestionDao;
import PRM391.getDriverLicense.model.myResource;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    QuestionDao questionDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // Ẩn Actionbar
            getSupportActionBar().hide();


            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "questions")
                    .allowMainThreadQueries()
                    .build();
            questionDao = db.questionDao();

        try {
            Log.i("zzzzzzz", (new myResource(getResources(), R.raw.resource)).getIndex(100).toString());
            Question q = questionDao.findQuestionById(101);
            q.setUserRsult(new ArrayList<Integer>());
            Log.i("zzzzzzz", q.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setRoomDatabaseData();

        //((TextView) findViewById(R.id.activity_Title)).setText(questionDao.getAll().get(0).getId() + "" );
        }

        public void setRoomDatabaseData() {
            myResource m = new myResource(getResources(), R.raw.resource);

            try {
//            questionDao.clearQuestionsTable();
                int num = m.ArrayJSON().length();

                for (int i = 0; i < num; i++) {
                    Question q = m.getIndex(i);
                    questionDao.insert(q);
                }

            } catch (Exception e) {
                ((TextView) findViewById(R.id.activity_Title)).setText(e.getMessage());
                e.printStackTrace();
            }

        }

        // Chứa dựng sự kiện click cho các thành phần trong layout
        public void onClick (View v){
            Intent intent = null;
                switch (v.getId()) {
                    case R.id.layout_Learning:
                        // Click layout, button Học
                        intent = new Intent(this, LearningActivity.class);
                        intent = new Intent(this, LearningActivity.class);
                        break;
                        case R.id.layout_Contest:
                            // Click layout, button Thi
                            intent = new Intent(this, ContestWelcome.class);
                            break;
                        case R.id.layout_TrafficSign:
                            // Click layout, button biển báo
                            intent = new Intent(this, TrafficSignActivity.class);
                            break;
                        default:
                            Toast.makeText(this, "Chức năng chưa được phát triển", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    try {
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                        }
                    } catch (Exception e) {
                    }
                }
            }
