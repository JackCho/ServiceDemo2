package com.example.serviceserver;

import java.util.LinkedList;
import java.util.List;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class RemoteService extends Service {

	private LinkedList<Person> personList = new LinkedList<Person>();

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {

		@Override
		public void savePersonInfo(Person person) throws RemoteException {
			if (person != null) {
				personList.add(person);
			}
		}

		@Override
		public List<Person> getAllPerson() throws RemoteException {
			return personList;
		}
	};
}
