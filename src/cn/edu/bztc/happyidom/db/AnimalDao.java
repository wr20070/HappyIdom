package cn.edu.bztc.happyidom.db;

import java.util.ArrayList;
import java.util.List;

import cn.edu.bztc.happyidom.entity.Animal;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AnimalDao {
	private static AnimalDao animalDao;
	private SQLiteDatabase db;
	/**
	 * 构造方法私有化
	 */
	private AnimalDao(Context context){
		DBOpenHelper dbHelper = new DBOpenHelper(context);
		db= dbHelper.openDatabase();
	}
	/**
	 * 获取AnimalDao的实例
	 */
	public synchronized static AnimalDao getlnstance(Context context){
		if (animalDao==null){
			animalDao=new AnimalDao(context);
		}
		return animalDao;
	}
	/**
	 * 从数据库读取所有动物类成语  呵呵
	 */
	public List<Animal>getAllAnimals(){
		List<Animal> list = new ArrayList<Animal>();
		Cursor cursor = db.query("animal", null, null, null, null, null, null);
		Log.i("file", "df"+cursor.getColumnCount());
		System.out.println(cursor.getCount());
		if (cursor.moveToFirst()) {
			do{
				Animal animal=new Animal();
				animal.setId(cursor.getInt(cursor.getColumnIndex("id")));
				animal.setName(cursor.getString(cursor.getColumnIndex("name")));
				animal.setPinyin(cursor.getString(cursor.getColumnIndex("ping")));
				animal.setDiangu(cursor.getString(cursor.getColumnIndex("diangu")));
				animal.setChuchu(cursor.getString(cursor.getColumnIndex("chuchu")));
				animal.setLizi(cursor.getString(cursor.getColumnIndex("lizi")));
				animal.setSpinyin(cursor.getString(cursor.getColumnIndex("spinyin")));
				list.add(animal);
			}while(cursor.moveToNext());
		}
		return list;
	}
}
