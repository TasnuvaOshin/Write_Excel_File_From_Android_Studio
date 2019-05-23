package worldcup.cricketworldcup.mynewexcelwork;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "APP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void SaveData(View view) {

       if(isStoragePermissionGranted()) {
           String oshin = "hello";
           File textFile = new File(Environment.getExternalStorageDirectory(), "oshin");
           FileOutputStream fos = null;
           try {
               fos = new FileOutputStream(textFile);
               fos.write(oshin.getBytes());
               fos.close();

               Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
           } catch (IOException e) {
               e.printStackTrace();

           }
       }else{

           Toast.makeText(this, "Permission not Gurented ", Toast.LENGTH_SHORT).show();


       }


    }

    private boolean checkPermission(String writeExternalStorage) {
       int check = ContextCompat.checkSelfPermission(this,writeExternalStorage);
       return (check == PackageManager.PERMISSION_GRANTED);

    }


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
}
