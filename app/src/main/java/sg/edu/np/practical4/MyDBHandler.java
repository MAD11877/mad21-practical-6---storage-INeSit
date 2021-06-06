package sg.edu.np.practical4;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "userDB.db";
    public static String USERS = "Users"; //Assigned the table to create
    public static String COLUMN_NAME = "Name"; //Assigned the column to create in table
    public static String COLUMN_DESCRIPTION = "Description";
    public static String COLUMN_ID = "ID";
    public static String COLUMN_FOLLOWED = "Followed";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("CREATE TABLE " + USERS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Description TEXT,Followed BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + USERS);
    }

    public void addUser(User userData){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,userData.getName());
        values.put(COLUMN_DESCRIPTION,userData.getDescription());
        values.put(COLUMN_ID,userData.getId());
        values.put(COLUMN_FOLLOWED,userData.getFollowed());
        SQLiteDatabase db = this.getWritableDatabase(); //Allows the app to write data to the database
        db.insert(USERS, null, values);
        db.close();
    }
    public ArrayList<User> getUsers(ArrayList<User> userArrayList){
        ArrayList<User> userList = new ArrayList<>();

        for(User u : userArrayList){
            User user = findUser(u.getName());
            userList.add(user);
        }
        return userList;
    }

    public User findUser(String name){
        String query = "SELECT * FROM " + USERS +COLUMN_NAME + "=\"" + name + "=\"";
        //SELECT * FROM Accounts WHERE UserName = "username"

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null); //Finds the row that has data matching the query

        User queryData = new User();

        if(cursor.moveToFirst()){ //First row of the table that matches the query / Finds the first occurance of the query
            queryData.setName(cursor.getString(0));
            queryData.setDescription(cursor.getString(1));
            queryData.setId(cursor.getInt(2));
            boolean followed = cursor.getInt(3 ) > 0;
            queryData.setFollowed(followed);

        }
        else{
            queryData = null;
        }
        db.close();

        return queryData;

    }
    public void updateUser(User user){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE " + USERS + " SET " + COLUMN_FOLLOWED + " = " + user.getFollowed() + " WHERE Name = " + "'"+user.getName()+"'");
        db.close();
        /*
        User updateUser = findUser(user.getName());
        if(updateUser != null){
            updateUser.setDescription(user.getDescription());
            updateUser.setId(user.getId());
            updateUser.setFollowed(user.getFollowed());

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_DESCRIPTION, updateUser.getDescription());
            values.put(COLUMN_ID,updateUser.getId());
            values.put(COLUMN_FOLLOWED,updateUser.getFollowed());

            db.update(USERS,values,"Name=?",new String[]{updateUser.getName()});
            db.close();
        }
        */


    }
}
