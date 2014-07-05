package com.flour.launcher3;

import android.content.Context;
import android.content.SharedPreferences;


public class SettingsProvider
{
	
   public static String KEY_PREFERENCES = "preferences";

   public static String KEY_SETTINGS_BOOT = "boot_settings";
   public static String KEY_INTERFACE_HOMESCREEN_DRAWER_ENABLE_DRAWER = "interface_homescreen_drawer_enable_drawer";

   public static SharedPreferences getPreferences(Context context) {
       return context.getSharedPreferences(KEY_PREFERENCES, Context.MODE_MULTI_PROCESS);
   }
   
   public static boolean getBoolean(Context context, String key, boolean defaultValue) {
       return getPreferences(context).getBoolean(key, defaultValue);
   }
   
   public static void putBoolean(Context context, String key, boolean value) {
       getPreferences(context).edit().putBoolean(key, value).commit();
   }
}

