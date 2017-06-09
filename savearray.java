package com.hirani.saveobject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

public class savearray {
    

    public static void persistAppUser(SaveArraySatGet user, Context context, String Key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_PREF", Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String details = gson.toJson(user);
        Log.e("savearray", "getPersistAppUser: " + details);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Key, details).apply();
        editor.commit();
    }

    public static SaveArraySatGet getPersistAppUser(Context context,String Key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_PREF", Context.MODE_PRIVATE);
        String details = sharedPreferences.getString(Key, null);
        Gson gson = new Gson();

        return gson.fromJson(details, SaveArraySatGet.class);
    }

}
