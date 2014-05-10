package com.example.restexample.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by calber on 10/5/14.
 */
public class OrmHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "localtsc.db";
    private static final int DATABASE_VERSION = 0;
    private static OrmHelper instance;

    public static OrmHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new OrmHelper(ctx);
        }
        return instance;
    }

    private OrmHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private Dao<Response, Long> response = null;

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Response.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<Response, Long> getResponseDao() {
        return response;
    }
}
