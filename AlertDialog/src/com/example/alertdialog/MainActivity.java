package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }
	
   public void open(View view){
      AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
      alertDialogBuilder.setMessage(R.string.decision);
      alertDialogBuilder.setPositiveButton(R.string.positive_button, 
      new DialogInterface.OnClickListener() {
		
         @Override
         public void onClick(DialogInterface arg0, int arg1) {
            Intent positveActivity = new Intent(getApplicationContext(),com.example.alertdialog.PositiveActivity.class);
            startActivity(positveActivity);
			
         }
      });
      alertDialogBuilder.setNegativeButton(R.string.negative_button, 
      new DialogInterface.OnClickListener() {
			
         @Override
         public void onClick(DialogInterface dialog, int which) {
            Intent negativeActivity = new Intent(getApplicationContext(),com.example.alertdialog.NegativeActivity.class);
            startActivity(negativeActivity);
		 }
      });
	    
      AlertDialog alertDialog = alertDialogBuilder.create();
      alertDialog.show();
	    
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
}
