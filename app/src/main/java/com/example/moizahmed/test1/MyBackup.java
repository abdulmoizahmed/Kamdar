package com.example.moizahmed.test1;

import android.app.backup.BackupAgent;
import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FileBackupHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.os.ParcelFileDescriptor;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.sql.SQLData;

/**
 * Created by Moiz Ahmed on 5/8/2016.
 */
public class MyBackup extends BackupAgentHelper {
    private static final String DB_NAME = "Khaatah.db";

    static final String File_Name_Of_Prefrences = "myPrefrences";
    static final String PREFS_BACKUP_KEY = "moizbackup";

    @Override
    public void onCreate() {
//        SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this,
//                File_Name_Of_Prefrences);
//        addHelper(PREFS_BACKUP_KEY, helper);
     //  FileBackupHelper dbs = new FileBackupHelper(this,DB_NAME);
       // addHelper("dbs", dbs);


     addHelper("DATABASE", new DbBackupHelper(this,DB_NAME));
    }


    @Override
    public File getFilesDir(){
        File path = getDatabasePath(DB_NAME);
        return path.getParentFile();
    }

}
