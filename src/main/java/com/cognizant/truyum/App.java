package com.cognizant.truyum;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(ctx);
        
        MenuItemDaoCollectionImpl impl= (MenuItemDaoCollectionImpl) ctx.getBean("menuItemDaoCollectionImpl");
        
        for(MenuItem item:impl.getMenuItemListAdmin()) {
        	System.out.println(item.toString());
        }
        
        MenuItemService services=  ctx.getBean(MenuItemService.class);
        
        AnnotationConfigApplicationContext ctx1=new AnnotationConfigApplicationContext();
        ctx1.scan("com.cognizant");
        ctx1.refresh();
        MenuItemService service=  ctx1.getBean(MenuItemService.class);
        for(MenuItem item:service.getMenuItemListAdmin()) {
        	System.out.println(item.toString());
        }
    }
}
