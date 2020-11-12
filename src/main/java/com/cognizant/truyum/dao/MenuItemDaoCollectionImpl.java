package com.cognizant.truyum.dao;

import java.util.ArrayList;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@ImportResource("classpath:bean.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao{

	@Autowired
	private ArrayList<MenuItem> menuItemList;


	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public ArrayList<MenuItem> getMenuItemListAdmin(){
		return menuItemList;
	}

	public ArrayList<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
		DateUtil d = new DateUtil();
		for(MenuItem item:menuItemList) {
			if(item.isActive()==true &&(item.getDateOfLaunch().before(d.convertToDate("19/08/2019")))) {
				menu.add(item);
			}
		}
		return menu;
	}
	
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for(MenuItem item:menuItemList) {
			if(item.getId()==(menuItem.getId())) {
				item.setId(menuItem.getId());
				item.setName(menuItem.getName());
				item.setCategory(menuItem.getCategory());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
			}
		}
}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menu=null;
		for(MenuItem item:menuItemList) {
			if(item.getId()==menuItemId) {
				menu=item;
				break;
			}
		}
		return menu;
	}
}