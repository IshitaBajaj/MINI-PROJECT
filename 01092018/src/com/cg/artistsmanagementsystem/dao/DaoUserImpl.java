/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cg.artistsmanagementsystem.bean.UserBean;

/**
 * @author ibajaj
 *
 */
public class DaoUserImpl implements IDaoUser{
	Connection con=null;
	boolean status;
	String userPwd;
	
	@Override
	public boolean login(UserBean user) {
		try{
			
			con=DBUtil.getConnection();
			status=false;
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.USER_LOGIN);
			preparedStatement.setInt(1,user.getUserId());
			//System.out.println(admin.getUserId()+admin.getUserPwd());
			ResultSet resultSet=preparedStatement.executeQuery();
			//System.out.println("ye bhi chala");
			if(resultSet.next())
			{	
				userPwd=resultSet.getString(1);
				if(userPwd.equals(user.getUserPwd()))
						{
						status=true;
						}
				
			}
			}
			catch(Exception e)
			{
				
				
			}
		return status;
	}

}
