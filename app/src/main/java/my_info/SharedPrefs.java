package my_info;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Reza on 01/11/2017.
 */

public class SharedPrefs {

    SharedPreferences preferences;
    Context context;

    public SharedPrefs(Context context){
        this.context = context;
    }


    public SharedPreferences getPreferences(){
        preferences = context.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        return preferences;
    }

    public void saveUserInfo(int userId, String imgUrl,String name,String phone,String address,String postal_code,
                             String specialties,String sheba){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt("userId", userId);
        editor.putString("img", imgUrl);
        editor.putString("name", name);
        editor.putString("phone", phone);
        editor.putString("address", address);
        editor.putString("postal_code", postal_code);
        editor.putString("specialties", specialties);
        editor.putString("sheba", sheba);
        editor.apply();
    }



    public void saveUserId(int userId, String phone){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt("userId", userId);
        editor.putString("phone", phone);
        editor.apply();
    }

    public void savePhone(String phone){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString("phone", phone);
        editor.apply();
    }

    public void saveSubUserId(int subUserId){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt("subUserId", subUserId);
        editor.apply();
    }

    public int getUserId(){
        int userId = getPreferences().getInt("userId", 0);
        return userId;
    }



    public void saveQuestionInfo(int userId, int amount,int question_id,String title,String description,int question_type,
                             String category,String date){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt("userId", userId);
        editor.putInt("amount", amount);
        editor.putInt("question_id", question_id);
        editor.putString("title", title);
        editor.putString("description", description);
        editor.putInt("question_type", question_type);
        editor.putString("category", category);
        editor.putString("date", date);
        editor.apply();
    }


    public void saveMyRespective(String my_respective){
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString("my_respective", my_respective);
        editor.apply();
    }

    public String getMyRespective(){
        String userId = getPreferences().getString("my_respective", "");
        return userId;
    }
}
