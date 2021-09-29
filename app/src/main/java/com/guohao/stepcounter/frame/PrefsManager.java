package com.guohao.stepcounter.frame;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences工具类
 */
public class PrefsManager {

    private final Context context;
    private static final String PREFERENCES_NAME = "STEP_COUNTER";

    public PrefsManager(Context context) {
        this.context = context;
    }

    /**
     * 清除SharedPreferences保存的所有数据
     */
    public void clear() {
        context.getSharedPreferences(PrefsManager.PREFERENCES_NAME, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .commit();
    }

    /**
     * 检查是否存在key映射的数据
     * @param key
     * @return
     */
    public boolean containts(String key) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
                .contains(key);
    }

    /**
     * 读数据
     * @param key
     * @param defaultObj
     * @return
     */
    public Object get(String key, Object defaultObj) {

        SharedPreferences sp = context.getSharedPreferences(PrefsManager.PREFERENCES_NAME, Context.MODE_PRIVATE);

        if(defaultObj instanceof Boolean) {
            return sp.getBoolean(key, (Boolean)defaultObj);
        } else if(defaultObj instanceof Integer) {
            return sp.getInt(key, (Integer)defaultObj);
        } else if (defaultObj instanceof Long) {
            return sp.getLong(key, (Long)defaultObj);
        } else if(defaultObj instanceof Float) {
            return sp.getFloat(key, (Float)defaultObj);
        } else if(defaultObj instanceof String) {
            return sp.getString(key, (String)defaultObj);
        }

        return null;
    }

    /**
     * 写数据
     * @param key
     * @param value
     */
    public void put(String key, Object value) {

        SharedPreferences.Editor editor = context.getSharedPreferences(PrefsManager.PREFERENCES_NAME, Context.MODE_PRIVATE).edit();

        if(value instanceof Boolean) {
            editor.putBoolean(key, (Boolean)value);
        } else if(value instanceof Integer) {
            editor.putInt(key, (Integer)value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long)value);
        } else if(value instanceof Float) {
            editor.putFloat(key, (Float)value);
        } else if(value instanceof String) {
            editor.putString(key, (String)value);
        }

    }

}
