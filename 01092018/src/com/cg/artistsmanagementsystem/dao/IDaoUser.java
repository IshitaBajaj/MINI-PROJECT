/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

import com.cg.artistsmanagementsystem.bean.UserBean;

/**
 * @author ibajaj
 *
 */
public interface IDaoUser {
	public abstract boolean login(UserBean user);
}
