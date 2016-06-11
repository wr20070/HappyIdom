package cn.edu.bztc.happyidom.test;

import java.util.List;

import cn.edu.bztc.happyidom.db.AnimalDao;
import cn.edu.bztc.happyidom.entity.Animal;
import android.test.AndroidTestCase;

public class AnimalDaoTest extends AndroidTestCase {
	public void testGetAllAnimals(){
		AnimalDao animalDao = AnimalDao.getlnstance(getContext());
    	List<Animal>animals=animalDao.getAllAnimals();
		System.out.println(animals.size());
		for(Animal animal:animals){
			System.out.println(animal.getName());
		}
	}
}
