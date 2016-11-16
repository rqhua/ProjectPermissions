package engeneering.digital.solution.permissionslibrary.sharePrefs;

import android.content.Context;
import android.content.SharedPreferences;

import engeneering.digital.solution.permissionslibrary.utils.Constant;


/**
 * Created by alessio on 27/11/15.
 */
public class SharedPreferencesUtils {

    private static String prefsFileName = "";

    private static final String MSG_ANDROID_MARSHMALLOW_CONTACTS = "msg_android_marshmallow_rubrica";
    private static final String MSG_ANDROID_MARSHMALLOW_TELEFONO = "msg_android_marshmallow_telefono";
    private static final String MSG_ANDROID_MARSHMALLOW_GPS = "msg_android_marshmallow_gps";
    private static final String MSG_ANDROID_MARSHMALLOW_WRITE_STORAGE = "msg_android_marshmallow_camera";
    private static final String MSG_ANDROID_MARSHMALLOW_CAMERA = "msg_android_marshmallow_camera";
    private static final String MSG_ANDROID_MARSHMALLOW_ACCOUNT = "msg_android_marshmallow_account";
    private static final String MSG_ANDROID_MARSHMALLOW_CALENDARIO = "msg_android_marshmallow_calendario";
    private static final String MSG_ANDROID_MARSHMALLOW_SMS_SEND = "msg_android_marshmallow_sms_send";
    private static final String MSG_ANDROID_MARSHMALLOW_SMS_RECEIVE = "msg_android_marshmallow_sms_receive";
    private static final String MSG_ANDROID_MARSHMALLOW_SMS_READ = "msg_android_marshmallow_sms_read";
    private static final String MSG_ANDROID_MARSHMALLOW_CUSTOM = "msg_android_marshmallow_custom";


    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(prefsFileName, Context.MODE_PRIVATE);
    }

    //****************FUNCTIONS FOR THE PERMISSIONS RUNTIME REQUESTS*****************

    public static void setSharedPrefsFileName(String packageName){
        prefsFileName = Constant.FILE_PREFS + "_" + packageName;
    }


    public static int loadCheckForMessageSecurityMarshmallowContacts(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_CONTACTS, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowContacts(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_CONTACTS, msgAndroid6).commit();
    }

    public static int loadCheckForMessageSecurityMarshmallowCalendar(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_CALENDARIO, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowCalendar(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_CALENDARIO, msgAndroid6).commit();
    }

    public static int loadCheckForMessageSecurityMarshmallowSmsSend(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_SMS_SEND, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowSmsSend(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_SMS_SEND, msgAndroid6).commit();
    }

    public static int loadCheckForMessageSecurityMarshmallowSmsReceive(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_SMS_RECEIVE, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowSmsReceive(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_SMS_RECEIVE, msgAndroid6).commit();
    }

    public static int loadCheckForMessageSecurityMarshmallowSmsRead(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_SMS_READ, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowSmsRead(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_SMS_READ, msgAndroid6).commit();
    }

    public static int loadCheckForMessageSecurityMarshmallowPhoneCall(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_TELEFONO, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowPhoneCall(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_TELEFONO, msgAndroid6).commit();
    }


    public static int loadCheckForMessageSecurityMarshmallowGps(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_GPS, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowGps(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_GPS, msgAndroid6).commit();
    }


    public static int loadCheckForMessageSecurityMarshmallowWriteStorage(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_WRITE_STORAGE, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowWriteStorage(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_WRITE_STORAGE, msgAndroid6).commit();
    }


    public static int loadCheckForMessageSecurityMarshmallowCamera(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_CAMERA, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowCamera(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_CAMERA, msgAndroid6).commit();
    }


    public static int loadCheckForMessageSecurityMarshmallowAccount(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_ACCOUNT, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowAccount(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_ACCOUNT, msgAndroid6).commit();
    }


    public static int loadCheckForMessageSecurityMarshmallowCustom(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        return prefs.getInt(MSG_ANDROID_MARSHMALLOW_CUSTOM, 0);
    }

    public static void saveCheckForMessageSecurityMarshmallowCustom(Context context, int msgAndroid6) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(MSG_ANDROID_MARSHMALLOW_CUSTOM, msgAndroid6).commit();
    }



    //*********************************END**************************************


}
