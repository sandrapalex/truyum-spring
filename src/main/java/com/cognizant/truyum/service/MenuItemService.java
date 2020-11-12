package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
public class MenuItemService{
	
	private MenuItemDao menuItemDao;
	
	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	@Autowired
	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		 List<MenuItem> menuListsAdmin=menuItemDao.getMenuItemListAdmin();
		 return menuListsAdmin;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		
		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItem(long menuItemId) {
		
		return menuItemDao.getMenuItem(menuItemId);
	}

	public void modifyMenuItem(MenuItem menuItemId) {
		// TODO Auto-generated method stub
		menuItemDao.modifyMenuItem(menuItemId);
	}
}
