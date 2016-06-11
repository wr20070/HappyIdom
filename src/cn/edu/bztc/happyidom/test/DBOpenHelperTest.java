package cn.edu.bztc.happyidom.test;

import cn.edu.bztc.happyidom.db.DBOpenHelper;
import android.test.AndroidTestCase;

public class DBOpenHelperTest extends AndroidTestCase {
	public void testDBCopy(){
		DBOpenHelper dbOpenHelper=new DBOpenHelper(getContext());
		dbOpenHelper.openDatabase();
	}

}
