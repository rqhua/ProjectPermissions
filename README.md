# ProjectPermissions library
ProjectPermissions is an Android library that manage simply the most common runtime permissions<br />
* Permissions managed in this library are
 * CONTACTS
    * **android.permission.WRITE_CONTACTS**
    * **android.permission.READ_CONTACTS**
 * CALENDAR   
    * **android.permission.WRITE_CALENDAR**
    * **android.permission.READ_CALENDAR**
 * PHONECALL   
    * **android.permission.CALL_PHONE**
    * **android.permission.READ_PHONE_STATE**
 * GPS
    * **android.permission.ACCESS_FINE_LOCATION**
    * **android.permission.ACCESS_COARSE_LOCATION**
 * WRITESTORAGE
    * **android.permission.READ_EXTERNAL_STORAGE**
    * **android.permission.WRITE_EXTERNAL_STORAGE**
 * **android.permission.CAMERA**
 * **android.permission.GET_ACCOUNTS**
 * **android.permission.SEND_SMS**
 * **android.permission.RECEIVE_SMS**
 * **android.permission.READ_SMS** 
 
## Gradle usage
* This project is on jcenter, to use it<br />
* Available from jcenter

##Method and its parameters
You have to declare library object in this way:<br />
**CheckRuntimePermissions checkRuntimePermissions = new CheckRuntimePermissions();**<br />
<br />
then, call this method to request a permission
* checkRuntimePermissions.setPermissions(....)
  * You can call a **standard** request (e.g. CALENDAR permission or CAMERA permission etc.)<br />
  * You can create a **custom** request, which means that you can ask more request at the same time (e.g. CAMERA and GET_ACCOUNT)


The necessary parameters are:<br />
**For the activity**
* context
* permission to request (you can get the permission name direct from the library)
* package name

**For the fragment**
* fragment
* context
* permission to request (you can get the permission name direct from the library)
* package name

**The optional parameters for the activity and fragment are:**<br />
* List\<String> permissions
* HashMap\<String, String> tvStrings

The **List\<String> permissions** can be left null in the standard request<br /> 
but it's required to call a custom request (for the custom request you must call CUSTOMREQUEST as permission to request)<br />

Instead, you can left null **HashMap\<String, String> tvStrings** and the system get the default value. 

## DO NOT FORGET TO INCLUDE THE PERMISSIONS THAT YOU WANT TO REQUEST, IN YOUR MANIFEST FILE!!



<br /><br />
**The following Activity snippet show how to make a standard request**

###Activity
```
private CheckRuntimePermissions checkRuntimePermissions = new CheckRuntimePermissions();



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
   
        boolean checkPerms = checkRuntimePermissions.setPermissions(this, checkRuntimePermissions.CALENDAR, getApplicationContext().getPackageName(), null, null);
            if (checkPerms) {
                //DO SOMETHING
            }
   }
   
   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean result;
        switch (requestCode) {

            //YOU CAN GET THE DEDICATED REQUEST CODE FROM THEL LIBRARY CLASS Constant 
            case Constant.REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS_CALENDAR:
                result = checkRuntimePermissions.permissionResults(requestCode, permissions, grantResults);
                if (result) {
                    //DO SOMETHING
                } else {
                    Toast.makeText(this, "Permission ko!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
```
<br />
<br /><br />
**The following Activity snippet show how to make a custom request**

###Activity
```
private CheckRuntimePermissions checkRuntimePermissions = new CheckRuntimePermissions();



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
   
        List<String> permissions = new ArrayList<>();
        HashMap<String, String> texts = new HashMap<>();

        permissions.add("android.permission.CAMERA");
        permissions.add("android.permission.GET_ACCOUNTS");

        //THIS VALUES IS OPTIONAL - IF YOU DON'T SET, THE APP GET THE DEFAULT VALUE
        texts.put(Constant.TITLE_PERMISSION, "Title something");
        texts.put(Constant.TEXT_PERMISSION, "Text something");
        texts.put(Constant.TITLE_PERMISSION_DIALOG_SETTING, "Title something for settings");
        texts.put(Constant.TEXT_PERMISSION_DIALOG_SETTINGS, "Text something for settings");

        boolean checkPerms = checkRuntimePermissions.setPermissions(this, checkRuntimePermissions.CUSTOMREQUEST, getApplicationContext().getPackageName(), permissions, texts);

        if (checkPerms) {
            //DO SOMETHING
        }
   }
   
   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean result;
        switch (requestCode) {

            //YOU CAN GET THE DEDICATED REQUEST CODE FROM THEL LIBRARY CLASS Constant 
            case Constant.REQUEST_CODE_ASK_MULTIPLE_CUSTOM_PERMISSIONS:
                result = checkRuntimePermissions.permissionResults(requestCode, permissions, grantResults);
                if (result) {
                    //DO SOMETHING
                } else {
                    Toast.makeText(this, "Permission ko!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
```
<br />
<br /><br />
**The following Fragment snippet show how to make a standard request (the difference with custom request is the same of the activity)**

###Fragment
```
CheckRuntimePermissions checkRuntimePermissions = new CheckRuntimePermissions();

<br /><br />

@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        
        boolean checkPerms = checkRuntimePermissions.setPermissions(this, getActivity(), checkRuntimePermissions.CAMERA, getActivity().getApplicationContext().getPackageName(), null, null);
        if (checkPerms) {
            //DO SOMETHING
        }

        return root;
    }
    
    
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        boolean result;
        switch (requestCode) {

            //YOU CAN GET THE DEDICATED REQUEST CODE FROM THEL LIBRARY CLASS Constant 
            case Constant.REQUEST_CODE_ASK_SINGLE_PERMISSION_CAMERA:
                result = checkRuntimePermissions.permissionResults(requestCode, permissions, grantResults);
                if (result) {
                    //DO SOMETHING IN FRAGMENT
                } else {
                    Toast.makeText(getActivity(), "Permission ko!", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
```

<br />
#DEVELOPED BY
* **alesms** - alessioengineering@gmail.com

License
-------

    Copyright 2016 alesms

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
