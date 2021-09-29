package com.guohao.stepcounter.frame;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;

public class FrameApplication extends Application {

    private static LinkedList<Activity> activityList = new LinkedList<Activity>();

    /**
     * 获取Activity列表
     * @return
     */
    public LinkedList<Activity> getActivityList() {
        return activityList;
    }

    /**
     * 添加Activity
     * @param activity
     */
    public void addToActivityList(Activity activity) {
        if(activity != null) {
            activityList.add(activity);
        }
    }

    /**
     * 移除Activity
     * @param activity
     */
    public void removeFromActivityList(Activity activity) {
        if(activity != null && activityList.contains(activity)) {
            activityList.remove(activity);
        }
    }

    /**
     * 清空Activity列表
     */
    public void clearActivityList() {
        if(activityList != null && activityList.size() > 0) {
            for(int i = activityList.size() - 1; i >= 0; i--) {
                Activity activity = activityList.get(i);
                if(activity != null) {
                    activity.finish();  //结束Activity
                    activityList.remove(i);  //移出Activity列表
                }
            }
        }
    }

    /**
     * 退出App
     */
    public void exitApp() {

        try{
            clearActivityList();
        } catch (final  Exception exc) {

        } finally {
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }

    }

}
