package com.example.serviceserver;

import java.util.List;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.serviceclient.R;

public class MainActivity extends Activity implements OnClickListener {

	private Button bind, unbind, savePerson, getPersons;

	private IRemoteService mService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bind = (Button) findViewById(R.id.bind_service);
		unbind = (Button) findViewById(R.id.unbind_service);
		savePerson = (Button) findViewById(R.id.save_person);
		getPersons = (Button) findViewById(R.id.get_persons);

		bind.setOnClickListener(this);
		unbind.setOnClickListener(this);
		savePerson.setOnClickListener(this);
		getPersons.setOnClickListener(this);
	}

	private ServiceConnection mConn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.e("test", "onServiceDisconnected");
			mService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.e("test", "onServiceConnected");
			mService = IRemoteService.Stub.asInterface(service);
			bindSuccess();
		}
	};

	private int index = 0;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bind_service:
			Intent service = new Intent("com.service.server");
			bindService(service, mConn, Context.BIND_AUTO_CREATE);
			break;
		case R.id.unbind_service:
			unbindService(mConn);
			unbindSuccess();
			break;
		case R.id.save_person:
			Person person = new Person();
			index = index + 1;
			person.setName("Person" + index);
			person.setAge(20 + index);
			try {
				mService.savePersonInfo(person);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case R.id.get_persons:
			List<Person> list = null;
			try {
				list = mService.getAllPerson();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (list != null) {
				Log.e("test", "get persons--->" + list.toString());
			} else {
				Toast.makeText(MainActivity.this, "get data error",
						Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
	}

	private void unbindSuccess() {
		unbind.setEnabled(false);
		savePerson.setEnabled(false);
		getPersons.setEnabled(false);
	}

	private void bindSuccess() {
		unbind.setEnabled(true);
		savePerson.setEnabled(true);
		getPersons.setEnabled(true);
	}

}
