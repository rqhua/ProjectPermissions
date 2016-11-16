# ProjectPermissions
project to manage most common runtime permissions<br />
* If you want to know which permissions are in, read the **CheckRuntimePermissions** class.

# How it work
This library handles permission's runtime requests.
To use it, simply import the entire library project (or create a aar and import).
You can use the library in the Activity and Fragment;


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
