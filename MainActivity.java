package worldcup.cricketworldcup.mynewexcelwork;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MainActivity extends AppCompatActivity {
    File directory, sd, file;
    WritableWorkbook workbook;
    List<MyInfo> listdata;
    private static final String TAG = "APP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listdata = new ArrayList<>();

        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));
        listdata.add(new MyInfo("oshin", "gardening"));
        listdata.add(new MyInfo("oshin", "Programming"));
        listdata.add(new MyInfo("oshin", "Swimming "));


    }

    public void createExcelSheet() {
        if(isStoragePermissionGranted()) {
            String csvFile = "Mytest.xls";
            sd = Environment.getExternalStorageDirectory();
            directory = new File(sd.getAbsolutePath());
            file = new File(directory, csvFile);
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            try {
                workbook = Workbook.createWorkbook(file, wbSettings);
                createFirstSheet();

                //closing cursor
                workbook.write();
                workbook.close();

                Toast.makeText(this, "File Saved !", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{

            Toast.makeText(this, "Permission Denied !", Toast.LENGTH_SHORT).show();
        }
    }

    public void createFirstSheet() {
        try {

            //Excel sheet name. 0 (number)represents first sheet
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            // column and row title
            sheet.addCell(new Label(0, 0, "NameInitial"));
            sheet.addCell(new Label(1, 0, "firstName"));


            for (int i = 0; i < listdata.size(); i++) {
                sheet.addCell(new Label(0, i + 1, listdata.get(i).getName()));
                sheet.addCell(new Label(1, i + 1, listdata.get(i).getHobby()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void SaveTheFile(View view) {
        createExcelSheet();
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
