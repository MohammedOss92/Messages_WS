package SqliteClasses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Classes.Messages;
import adapters.CustomMsgTypes;

/**
 * Created by Abdallah on 26/02/2016.
 */
public class Sqlite extends SQLiteOpenHelper {

    public Sqlite(Context context) {
        super(context, "MessarjgettcdsIIfp5y37", null, 1);

    }

    public Sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void clearTables() {

        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from messages";
        db.execSQL(sql);


        sql = "delete from MessageTypes";
        db.execSQL(sql);


    }


    public void updateFavOnRefersh() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "update messages set fav=1 where msgid in(select msgid from favs)";
        db.execSQL(sql);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String a = "Create Table MessageTypes (TypeID integer   unique    , TypeDescription text ,newMsg integer  )";
        db.execSQL(a);

        String b = "Create Table Messages     (MsgID  integer   unique ,MsgDescription text,TypeID integer,origPos integer ,newMsg int,fav int,orderOfFav int)";
        db.execSQL(b);

        String c = "Create table Favs(MsgID integer)";
        db.execSQL(c);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void saveMsgTypes(CustomMsgTypes cMT) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into MessageTypes(TypeID,TypeDescription,newMsg) values(" + cMT.getTitleID() + ",'" + cMT.getTitleDesc() + "'," + cMT.getNewMsg() + ")";
        db.execSQL(sql);
        db.close();
    }


    public void saveMessages(Messages msg) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into Messages(MsgID,MsgDescription,TypeID,origPOS,newMsg) values(" + msg.getMsgID() + ",'" + msg.getMsgDescription() + "'," + msg.getTypeId() + "," + msg.getOrigPos() + "," + msg.getNewMsg() + ")";
        db.execSQL(sql);
        db.close();
    }

    public void changeFav(Messages msg, int intFav) {


        SQLiteDatabase db = getWritableDatabase();
        String sql = "select max(orderOfFav) from messages";
        int intMaxOrderOfFav = 0;
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) ;
        {
            intMaxOrderOfFav = c.getInt(0);
        }
        intMaxOrderOfFav = intMaxOrderOfFav + 1;
        if (intFav == 0) {
            sql = "update Messages set fav=" + intFav + " ,orderOfFav=0 where msgID=" + msg.getMsgID();
            db.execSQL(sql);
            sql = "delete from  favs where msgID=" + msg.getMsgID();
            db.execSQL(sql);
        } else {

            sql = "update Messages set fav=" + intFav + " ,orderOfFav=" + intMaxOrderOfFav + " where msgID=" + msg.getMsgID();
            db.execSQL(sql);

            sql = "insert into favs values(" + msg.getMsgID() + ")";
            db.execSQL(sql);
        }

        c.close();
        db.close();
    }

    public int getIFMsgIsFav(Messages m) {
        int result = 0;
        SQLiteDatabase db = getWritableDatabase();
        Cursor countCursor = db.rawQuery("SELECT fav  from messages where msgID=" + m.getMsgID(), null);
        if (countCursor.moveToFirst()) {
            result = countCursor.getInt(0);
        }
        db.close();
        return result;
    }


    public String getMsgTitleByTitleID(int msgType) {

        String result = "";
        SQLiteDatabase db = getReadableDatabase();

        Cursor countCursor = db.rawQuery("SELECT TypeDescription from MessageTypes where typeid=" + msgType, null);
        if (countCursor.moveToFirst()) {
            result = countCursor.getString(0);
        }
        countCursor.close();
        db.close();

        return result;
    }


    public int getCountOfMessagesByMsfType(int msgType) {
        int result = 0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor countCursor = db.rawQuery("SELECT count(*) as c from messages where typeid=" + msgType + " and newMsg=1", null);
        if (countCursor.moveToFirst()) {
            result = countCursor.getInt(0);
        }
        countCursor.close();
        db.close();
        return result;
    }


    public List<CustomMsgTypes> getMsgTypes() {
        CustomMsgTypes u;

        List<CustomMsgTypes> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT *   FROM MessageTypes ", null);

        if (c.moveToFirst()) {

            do {
                u = new CustomMsgTypes();
                u.setTitleID(c.getInt(0));
                u.setTitleDesc(c.getString(1));
                u.setNewMsg(c.getInt(2));
                Cursor countCursor = db.rawQuery("SELECT count(*) as c from messages where typeid=" + c.getInt(0), null);
                if (countCursor.moveToFirst()) {
                    u.setCounter(countCursor.getInt(0));
                }
                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getMessages(int typeID) {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where TypeID='" + typeID + "' order by msgID desc", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));
                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getMessagesNotOrdered(int typeID) {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where TypeID='" + typeID + "' ", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));
                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getFavMessages() {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where fav=1  order by orderOfFav desc", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));
                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }

    public List<Messages> getFavMessagesOrderedASC() {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where fav=1  order by orderOfFav asc", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));

                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getFavMessagesNotOrdered() {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where fav=1  ", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));
                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getFavMessagesFiltered(String filterValue) {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where fav=1  and MsgDescription like'%" + filterValue + "%' order by orderOfFav desc", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));

                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getFavMessagesFilteredNotOrdered(String filterValue) {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where fav=1  and MsgDescription like'%" + filterValue + "%' ", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));

                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getMessagesFiltered(int typeID, String filterValue) {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where TypeID='" + typeID + "' and MsgDescription like'%" + filterValue + "%' order by msgID desc", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));

                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }


    public List<Messages> getMessagesFilteredNotOrdered(int typeID, String filterValue) {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where TypeID='" + typeID + "' and MsgDescription like'%" + filterValue + "%' ", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));

                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }
    public List<Messages> new_msg(int newmsg) {
        Messages u;

        List<Messages> myList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT *   FROM Messages   where newMsg=1='" + newmsg + "' order by msgID desc", null);

        if (c.moveToFirst()) {

            do {
                u = new Messages();
                u.setMsgID(c.getInt(0));
                u.setMsgDescription(c.getString(1));
                u.setTypeId(c.getInt(2));
                u.setOrigPos(c.getInt(3));
                u.setNewMsg(c.getInt(4));
                u.setOrderFav(c.getInt(6));
                myList.add(u);
            }
            while (c.moveToNext());
        }
        c.close();
        db.close();
        return myList;
    }

}
