package PRM391.getDriverLicense.model;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class myResource {
    private StringBuilder builder;
    private InputStream is;

    // Hàm khởi tạo
    public myResource(Resources getResouce, int res) {
        try {
            InputStream IS = getResouce.openRawResource(res);
            setIs(IS);
            if (getIs() != null) {
                Scanner scanner = new Scanner(getIs());
                setBuilder(new StringBuilder());
                while (scanner.hasNextLine()) {
                    getBuilder().append(scanner.nextLine());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy text từ file JSON
    public String toString() {
        return builder.toString();
    }

    // Chuyển đổi text thành đối tượng JSON Array
    public JSONArray ArrayJSON() throws Exception {
        return new JSONArray(toString());
    }

    // Lấy câu hỏi theo index
    public Question getIndex(int index) throws Exception {
        Question question = null;

        JSONObject object = ArrayJSON().getJSONObject(index);
        String des = object.getString("description").toString();
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Integer> rlt = new ArrayList<>();
        JSONArray tempArr = object.getJSONArray("answer");
        for (int i = 0; i < tempArr.length(); i++) {
            ans.add(tempArr.getString(i).toString());
        }
        tempArr = object.getJSONArray("result");
        for (int i = 0; i < tempArr.length(); i++) {
            rlt.add(tempArr.getInt(i));
        }
        String path = object.getString("pathImage");
        question = new Question(des, ans, rlt, path);
        return question;
    }

    // Lấy câu hỏi theo vị trí từ bao nhiêu cho tới bao nhiêu
    public ArrayList<Question> getIndex(int begin, int end) throws Exception {
        ArrayList<Question> arrayList = null;
        for (int i = begin; i <= end; i++) {
            arrayList.add(getIndex(i));
        }
        return arrayList;
    }

    // Đọc file ảnh từ thư mục asset trong project
    public Drawable getDrawable(AssetManager asset, String filename) {
        try {
            // get input stream
            setIs(asset.open(filename));
            // load image as Drawable
            return Drawable.createFromStream(getIs(), null);
        } catch (IOException ex) {
            return null;
        }
    }

    // --------------------- GETTER - SETTER -------------------------
    private StringBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }
}
