package com.dxysolutions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper
{

   public DatabaseHelper( Context context )
   {
      super( context, "lotsOrows.db", null, 1 );
   }

   @Override
   public void onCreate( SQLiteDatabase db )
   {
      db.beginTransaction();
      try
      {
         db.execSQL( "CREATE TABLE rowsrowsrows(" +
         		" _id INTEGER NOT NULL PRIMARY KEY, " +
         		" anumber INTEGER NOT NULL, " +
         		" another INTEGER NOT NULL )" );

         // I have a feeling it's quantity, not quality; the
         // original data on which I got this to happen was just
         // float-based lat/long addresses.
         SQLiteStatement stmt = db.compileStatement(
               "INSERT INTO rowsrowsrows( anumber, another ) " +
         		"VALUES(?,?)" );
         for( int i = 0; i < 1000; ++i )
         {
            stmt.bindLong( 1, i );
            stmt.bindLong( 2, i * 987 );
            stmt.executeInsert();
         }
         db.setTransactionSuccessful();
      }
      finally
      {
         db.endTransaction();
      }
   }

   @Override
   public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
   {
      // This space intentionally blank.
   }

}
