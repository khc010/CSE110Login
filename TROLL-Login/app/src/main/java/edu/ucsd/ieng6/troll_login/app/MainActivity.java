package edu.ucsd.ieng6.troll_login.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

import static edu.ucsd.ieng6.troll_login.app.Login.LoginDialogListener;


public class MainActivity extends FragmentActivity
                          implements LoginDialogListener {
	private JSONParser jsonparser;
	private String userURL = "troll.everythingcoed.com/user/login";\
	//Instantiate EditText objects to take in strings from the text fields
	EditText username = null;
	EditText password = null;
	TextView Results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jsonParser = new JSONParser();
        setContentView(R.layout.activity_main);
        //Read the text fields
        username = (EditText)findViewById(R.id.editTextUser);
        password = (EditText)findViewById(R.id.editTextPass);
        //error = (TextView)findViewById(R.id.tv_error);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void logIn(View view){
        LayoutInflater inflater = this.getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflater.inflate(R.layout.dialog_login, null))
                .setTitle(R.string.login_title)
                .setMessage(R.string.login_msg)
                .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Pass usrname and pwrd to helper function to get a json object
                    	String user = username.getText().toString();
                    	String pass = password.getText().toString();
                    	JSONObject json = getUser(user, pass);
                    	
                    	
                    	/*try {
                            if (json.getString(jsonResult) != null) {
                                Results.setText("");
                                String res = json.getString(jsonResult);
                                if(Integer.parseInt(res) == 1){
                                    //If it's a success create a new JSON object for the user element
                                    JSONObject json_user = json.getJSONObject("user");
                                    //Set the results text to the age from the above JSON object
                                    Results.setText("User Age: " + json_user.getString("age"));
                                     
                                }else{
                                    //If the user could not be found
                                    Results.setText("User could not be found");
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/
                    }
                })
                .setNeutralButton(R.string.signup, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Call to API to register new user

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showLoginDialog(View view) {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new Login();
        dialog.show(getSupportFragmentManager(), "LoginDialogFragment");
    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the LoginDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // User touched the dialog's positive button

    }

    @Override
    public void onDialogNeutralClick(DialogFragment dialog){
        // User touched the dialog's neutral button
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // User touched the dialog's negative button

    }
    
    //The below passes the tag and the user name over to the JSON parser class
    public JSONObject getUser(String username, String password){
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("api_key", "OlDwjUX0fQSm0vAy2D3fy4uCZ108bx5N"));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(userURL, params);
        return json;
    }


}

