package com.example.alertdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class PositiveActivity extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_positive);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.string.positive, menu);
      return true;
   }

}
