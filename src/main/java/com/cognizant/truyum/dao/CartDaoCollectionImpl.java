package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("classpath:beans.xml")
public class CartDaoCollectionImpl implements CartDao{

	@Autowired
	private Map<Long, CartDao> userCarts;
	
	public CartDaoCollectionImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Map<Long, CartDao> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(Map<Long, CartDao> userCarts) {
		this.userCarts = userCarts;
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem item=menuItemDao.getMenuItem(menuItemId);
		
		if(userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList=((Cart) userCarts.get(userId)).getMenuItemList();
			menuItemList.add(item);
			((Cart) userCarts.get(userId)).setMenuItemList(menuItemList);
		}
		else{
			List<MenuItem> userList=new ArrayList<>();
			userList.add(item);
			Cart cart=new Cart(userList);
			userCarts.put(userId, (CartDao) cart);
		}
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = (Cart) userCarts.get(userId);
		List<MenuItem> allCartItems = cart.getMenuItemList();
		if(allCartItems.isEmpty()) {
			throw new CartEmptyException();
		}
		else {
			double total=0;
			for(MenuItem item : allCartItems) {
				total=total + item.getPrice();
			}
			cart.setTotal(total);
		}
		return allCartItems;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Cart cart=(Cart) userCarts.get(userId);
		List<MenuItem> allCartItems = cart.getMenuItemList();
		MenuItem itemRemove=null;
		
		for(MenuItem item: allCartItems) {
			if(item.getId()==menuItemId) {
				itemRemove=item;
				break;
			}
		}
		allCartItems.remove(itemRemove);
		cart.setMenuItemList(allCartItems);
		userCarts.put(userId, (CartDao) cart);
		
	}


}
