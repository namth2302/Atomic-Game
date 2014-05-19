package com.atomic.game.android;

import sun.security.pkcs11.Secmod.DbMode;

import com.atomic.game.database.database;
import com.atomic.game.database.user;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends Activity implements OnClickListener {

	private EditText nameEditText;
	private EditText passEditText;
	private EditText verifyPassEditText;
	private Button btnSignUp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		nameEditText = (EditText) findViewById(R.id.editText_UseName);
		passEditText = (EditText) findViewById(R.id.editText_password_2);
		verifyPassEditText = (EditText) findViewById(R.id.editText_verifyPassword);
		btnSignUp = (Button) findViewById(R.id.btnSignup);
		btnSignUp.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		database db = new database(this);
		String userName = nameEditText.getText().toString();
		String userPassword = passEditText.getText().toString();
		String userVerify = verifyPassEditText.getText().toString();
		user user_ = new user(userName, userPassword);

		// Boolean check = db.checkUser(userName);
		// if (check == false) {
		// Toast toast = Toast.makeText(signup.this,
		// "This name is already registered !!!", Toast.LENGTH_SHORT);
		// toast.show();
		// } else {
		// Toast toast = Toast.makeText(signup.this, "Why !!!",
		// Toast.LENGTH_SHORT);
		// toast.show();
		// }

		int check = 0;
		if (userName.equals("") | userPassword.equals("")) {
			Toast toast3 = Toast.makeText(signup.this,
					"Name or Password: empty", Toast.LENGTH_SHORT);
			toast3.show();
		} else {
			try {
				check = db.checkUser(userName);
			} catch (Exception e) {
				// TODO: handle exception
				// co the tao nick
			}
			if (check == 1) {
				Toast toast2 = Toast.makeText(signup.this,
						"This name is already registered !!!",
						Toast.LENGTH_SHORT);
				toast2.show();
			} else {
				if (!userPassword.equals(userVerify)) {
					Toast toast = Toast.makeText(signup.this,
							"Password not same Verify Password",
							Toast.LENGTH_SHORT);
					toast.show();
				} else {
					db.addUser(user_);
					Toast toast3 = Toast.makeText(signup.this,
							"Registered !!!", Toast.LENGTH_SHORT);
					toast3.show();
					Intent in = new Intent(getApplicationContext(), login.class);
					startActivity(in);
				}
			}
		}
		// if (check) {
		// Toast toast = Toast.makeText(signup.this,
		// "This name is already registered !!!", Toast.LENGTH_SHORT);
		// toast.show();
		// }
		// if (!check) {
		// db.addUser(user_);
		// Intent in = new Intent(getApplicationContext(), login.class);
		// startActivity(in);
		// }

	}
	// end view

	// }
	// private AlertDialog createDialog() {
	// // TODO Auto-generated method stub
	// AlertDialog.Builder builder = new AlertDialog.Builder(this);
	// builder.setTitle("Message");
	// builder.setMessage("Complete !!!");
	// builder.setCancelable(false);
	// builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
	//
	// @Override
	// public void onClick(DialogInterface dialog, int which) {
	// // TODO Auto-generated method stub
	//
	// finish();
	// }
	// });
	// return null;
	// }

}
