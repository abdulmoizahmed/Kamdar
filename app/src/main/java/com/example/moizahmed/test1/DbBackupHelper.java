package com.example.moizahmed.test1;

import android.app.backup.FileBackupHelper;
import android.content.Context;

/**
 * Created by Moiz Ahmed on 5/9/2016.
 */
public class DbBackupHelper extends FileBackupHelper {
    /**
     * Construct a helper to manage backup/restore of entire files within the
     * application's data directory hierarchy.
     *
     * @param context The backup agent's Context object
     */
    public DbBackupHelper(Context context, String DbName) {
        super(context, context.getDatabasePath(DbName).getAbsolutePath());
    }
}
