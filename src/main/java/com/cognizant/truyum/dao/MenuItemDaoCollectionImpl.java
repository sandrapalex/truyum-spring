package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("classpath:beans.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	
	@Autowired
	//@Qualifier("menuItems")
	private List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCus=new ArrayList<MenuItem>();
		Date date=new Date();
		for(MenuItem menuItem:menuItemList) {
			if(menuItem.getDateOfLaunch().getTime()<=date.getTime() && menuItem.isActive()) {
				menuItemListCus.add(menuItem);
			}
		}
		return menuItemListCus;
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem item=null;
		for(MenuItem menuItem: menuItemList) {
			if(menuItemId==menuItem.getId()) {
				item= menuItem;
			}
		}
		return item;
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		for(MenuItem item: menuItemList) {
			if(menuItem.getId()==item.getId()) {
				item.setName(menuItem.getName());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setFreeDelivery(menuItem.isFreeDelivery());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
			}
		}
	}
	
}
