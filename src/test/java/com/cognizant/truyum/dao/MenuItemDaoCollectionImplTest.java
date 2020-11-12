package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	
	/*public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDaoCollectionImpl m=new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems=m.getMenuItemListAdmin();
		for(MenuItem menuItem:menuItems) {
			System.out.println(menuItem.toString());
		}
	}
	
	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDaoCollectionImpl m=new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems=m.getMenuItemListCustomer();
		for(MenuItem menuItem:menuItems) {
			System.out.println(menuItem.toString());
		}
	}
	
	public static void testModifyMenuItem() throws ParseException {
		MenuItem menuItem=new MenuItem(000002, "Cake", 80.00f, true, DateUtil.convertToDate("11/12/2019"), "Main Course", false);
		MenuItemDaoCollectionImpl m=new MenuItemDaoCollectionImpl();
		MenuItemDao menu=m;
		MenuItemDao.modifyMenuItem(menuItem);
		System.out.println("Modified MenuItem details are :" + menu.getMenuItem(000002));
	}
	
	public void testGetMenuItem() {
		
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println("only for admin");
		testGetMenuItemListAdmin();
		System.out.println("only for customer");
		testGetMenuItemListCustomer();
		System.out.println("after modifying");
		testModifyMenuItem();
	}*/
}
