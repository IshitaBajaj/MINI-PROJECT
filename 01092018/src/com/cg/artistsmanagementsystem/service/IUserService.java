/**
 * 
 */
package com.cg.artistsmanagementsystem.service;

import com.cg.artistsmanagementsystem.bean.UserBean;

/**
 * @author ibajaj
 *
 */
public interface IUserService {
	
	public abstract boolean login(UserBean userBean);
}
