package com.miftah.asyst.pgn.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionUtil {

    final String KEY_USERNAME = "username";
    final String KEY_PASSWORD = "password";

    Context mContext;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SessionUtil(Context context) {
        this.mContext = context;

        preferences = context.getSharedPreferences("pgn", 0);//object preferen
        editor = preferences.edit();//edit preferen(menyimpan data)
    }

    public void saveUsername(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.commit();
    }

    public void savePassword(String password) {
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public String loadUsername() {
        String username = preferences.getString(KEY_USERNAME, "");
        return username;
    }

    public String loadPassword() {
        String password = preferences.getString(KEY_PASSWORD, "");
        return password;
    }


}
