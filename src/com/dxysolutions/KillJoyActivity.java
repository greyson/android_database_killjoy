package com.dxysolutions;

import android.app.Activity;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

public class KillJoyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new Backgrounder( this ).execute();
    }

    public static class Backgrounder extends AsyncTask< Void, Void, Void >
    {
       Backgrounder( Context activity )
       {
          myHelper = new DatabaseHelper( activity );
       }

       @Override
       protected Void doInBackground( Void... params )
       {
          SQLiteDatabase db = myHelper.getReadableDatabase();
          Cursor c = db.rawQuery( "SELECT _id, anumber, another FROM rowsrowsrows", null );

          // This is a tight loop, assume that we want character data,
          // but that we are going to discard it as soon as we use it.
          // The CharArrayBuffer appears to be designed for just such a
          // purpose.
          CharArrayBuffer buffer = new CharArrayBuffer( 10 );
          while( c.moveToNext() )
          {
             // But as you can see, one of these two statements crashed
             // with a deadd00d segmentation fault.
             c.copyStringToBuffer( 1, buffer );
             c.copyStringToBuffer( 2, buffer );
          }

          return null;
       }

       private DatabaseHelper myHelper;
    }
}