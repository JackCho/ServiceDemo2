/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/soutamabin/Documents/workspace/ServiceServer/src/com/example/serviceserver/IRemoteService.aidl
 */
package com.example.serviceserver;
public interface IRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.serviceserver.IRemoteService
{
private static final java.lang.String DESCRIPTOR = "com.example.serviceserver.IRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.serviceserver.IRemoteService interface,
 * generating a proxy if needed.
 */
public static com.example.serviceserver.IRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.serviceserver.IRemoteService))) {
return ((com.example.serviceserver.IRemoteService)iin);
}
return new com.example.serviceserver.IRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_savePersonInfo:
{
data.enforceInterface(DESCRIPTOR);
com.example.serviceserver.Person _arg0;
if ((0!=data.readInt())) {
_arg0 = com.example.serviceserver.Person.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.savePersonInfo(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getAllPerson:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.example.serviceserver.Person> _result = this.getAllPerson();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.serviceserver.IRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void savePersonInfo(com.example.serviceserver.Person person) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((person!=null)) {
_data.writeInt(1);
person.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_savePersonInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.util.List<com.example.serviceserver.Person> getAllPerson() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.example.serviceserver.Person> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAllPerson, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.example.serviceserver.Person.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_savePersonInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getAllPerson = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void savePersonInfo(com.example.serviceserver.Person person) throws android.os.RemoteException;
public java.util.List<com.example.serviceserver.Person> getAllPerson() throws android.os.RemoteException;
}
