package com.cg.artistsmanagementsystem.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.dao.DaoAdminImpl;
import com.cg.artistsmanagementsystem.dao.IDaoAdmin;
import com.cg.artistsmanagementsystem.exception.AdminException;

public class AdminServiceImpl implements IAdminService {
	IDaoAdmin adminDao=null;
	@Override
	public boolean login(UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		
		boolean status=adminDao.login(admin);
		return status;
		
	}
	
	@Override
	public ComposerBean searchComposer(int composerId) throws AdminException {
		adminDao=new DaoAdminImpl();
		ComposerBean composer=adminDao.searchComposer(composerId);	
		return composer;
	}
	@Override
	public boolean addComposer(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.addComposer(composer,admin);
		return status;
	}
	@Override
	public boolean validateName(String name) {
		Pattern p=Pattern.compile("[A-Za-z ]{1,50}");
		Matcher m=p.matcher(name);
		boolean status=m.matches();
		return status;
	}
	@Override
	public boolean validateDate(String bornDate) {
		boolean status=true;
		if("NA".equals(bornDate))
			return status;
		else
		{
			Pattern p=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
			Matcher m=p.matcher(bornDate);
			status=m.matches();
		}
		return status;
	}
	@Override
	public boolean validateCaeipiNumber(String number) {
		Pattern p=Pattern.compile("[0-9A-Z]{1,10}");
		Matcher m=p.matcher(number);
		boolean status=m.matches();
		return status;
	}

	@Override
	public ArtistBean searchArtist(int artistId) throws AdminException {
		adminDao=new DaoAdminImpl();
		ArtistBean artist=adminDao.searchArtist(artistId);
		return artist;
	}

	@Override
	public boolean addArtist(ArtistBean artist, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		
		boolean status=adminDao.addArtist(artist,admin);
		return status;
	}

	@Override
	public boolean validateType(String type) {
		int length=type.length();
		if(length==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateComposerName(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerName(composer,admin);
		return status;
	}

	@Override
	public boolean updateComposerBornDate(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerBornDate(composer,admin);
		return status;
	}

	@Override
	public boolean updateComposerDiedDate(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerDiedDate(composer,admin);
		return status;
	}

	@Override
	public boolean updateComposerCaeipiNumber(ComposerBean composer,
			UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerCaeipiNumber(composer,admin);
		return status;
	}

	@Override
	public boolean updateComposerMusicSocietyId(ComposerBean composer,
			UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerMusicSocietyId(composer,admin);
		return status;
	}

	
}
