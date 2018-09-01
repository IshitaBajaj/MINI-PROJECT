package com.cg.artistsmanagementsystem.service;

import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.dao.DaoAdminImpl;
import com.cg.artistsmanagementsystem.dao.DaoUserImpl;
import com.cg.artistsmanagementsystem.dao.IDaoAdmin;
import com.cg.artistsmanagementsystem.dao.IDaoUser;

public class UserServiceImpl implements IUserService {
	IDaoUser userDao=null;
	@Override
	public boolean login(UserBean user) {
		userDao=new DaoUserImpl();
		
		boolean status=userDao.login(user);
		return status;
		
	}

}
