package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.model.CartItem;
import com.niit.model.User;

public class CartItemDaoImpl implements CartItemDao{
	
	private SessionFactory sessisonFactory;
	public void saveOrUpdateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session =sessisonFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}

	public void removeCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		Session session=sessisonFactory.getCurrentSession();
		CartItem casrtItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(casrtItem);
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		Session session=sessisonFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		return user;
	}
	
}
