package cn.edu.bztc.happyidom.db;

import java.io.File;

import java.io.FileOutputStream;
import java.io.InputStream;

import cn.edu.bztc.happyidom.R;

//66666666666666666666666
//66666666666666666666666
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;


public class DBOpenHelper {
	private final int BUFFER_SIZE = 400000;
	public static final String DB_NAME = "chengyu1.db";
	public static final String PACKAGE_NAME = "cn.edu.bztc.happyidom";
	public static final String DB_PATH = "/data"+ Environment.getDataDirectory().getAbsolutePath()+"/"+PACKAGE_NAME+"/databases";
	private Context context;
	public DBOpenHelper(Context context){
		this.context = context;
	}
	public  SQLiteDatabase openDatabase(){
		try{
			File myDataPath = new File(DB_PATH);
			if (!myDataPath.exists()){
				myDataPath.mkdirs();
			}
			String dbfile = myDataPath.getAbsolutePath() +"/"+DB_NAME;
			Log.i("file", dbfile);
			
			if(!(new File(dbfile).exists())){
				InputStream is = context.getResources().openRawResource(R.raw.chengyu1);
				FileOutputStream fos = new FileOutputStream(dbfile);
				byte[]buffer = new byte [BUFFER_SIZE];
				int count = 0 ;
				while ((count = is.read(buffer))>0){
					fos.write(buffer,0,count);
					Log.i("file", ""+count);
				}
				fos.close();
				is.close();
			}
			SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
			return db;
		}catch (Exception e){

			e.printStackTrace();
		}
		return null;
	}

}
