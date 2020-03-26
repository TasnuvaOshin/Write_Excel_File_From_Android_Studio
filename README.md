# Write_Excel_File_From_Android_Studio
You can Create a excel File From Android Studio ---


## Easy Steps  ---------------- Step 1---------

Download this Jxl Library File  

[![Download Library](https://img.shields.io/apm/dm/vim-mode?label=download%20Core)](https://drive.google.com/file/d/1c1lObBM7nITH03F8JtmheI5ya1jlMC8d/view?usp=sharing)


> After Downloading this File Add this File to Your Android Studio -
 Project ->app ->libs ->Pest the file 

> {if you cant understand this please checkout the screenshot 1 }



 




## ---------------Step 2--------------------------

Add MultiDex in your build.gradle file (Module app)


<br>





## apply plugin: 'com.android.application'
```java
// code 

 android {
     compileSdkVersion 28
     defaultConfig {
         applicationId "worldcup.cricketworldcup.mynewexcelwork"
         minSdkVersion 14
         targetSdkVersion 28
         multiDexEnabled true
         versionCode 1
         versionName "1.0"
         testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
     }
     dexOptions {
         //incremental = true;
         preDexLibraries = false
         javaMaxHeapSize "4g"
     }

     packagingOptions {
         exclude 'META-INF/NOTICE.txt' // will not include NOTICE file
         exclude 'META-INF/LICENSE.txt' // will not include LICENSE file
     }

     buildTypes {
         release {
             minifyEnabled false
             proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
         }
     }
 }

 dependencies {
     implementation fileTree(dir: 'libs', include: ['*.jar'])
     implementation 'com.android.support:appcompat-v7:28.0.0'
     implementation 'com.android.support.constraint:constraint-layout:1.1.3'
     testImplementation 'junit:junit:4.12'
     implementation 'com.android.support:multidex:1.0.1'
     androidTestImplementation 'com.android.support.test:runner:1.0.2'
     androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
 }


```

---





## ---------Step 3 ---------------------------------


* Add this Permission Into your Manifest File :

 ## Code
```java
// code

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    
   ```

---
    
 
## ------------Step 4 -----------------   

*Now Checkout the MainActivity.java file ---------You can able to Create Your #Excel File Into Your Device Extralnal or Internal Storage 
*For Making Normal File You can check Main2Activity .


## ------------Step 5 ------------------
> Dont Forget To Use Permission . Without Permission it will not work .


 
 
 
 ## Add Permission
```java
// code
 
 
 
 public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }


```

---


## Authors

* **Tasnuva Tabassum Oshin** -- [IDevelopApps](https://github.com/TasnuvaOshin)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* For any Query Email Me - tasnuva.oshin12@gmail.com
* My Youtube Channel  - https://www.youtube.com/channel/UCf_kr77VNwQBTG2Xy1EBCkw
* Thanks
