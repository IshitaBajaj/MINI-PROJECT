/**
 * 
 */
package com.cg.artistsmanagementsystem.service;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.exception.AdminException;



/**
 * @author ibajaj
 *
 */
public interface IAdminService {
	public abstract boolean login(UserBean admin) throws AdminException;

	
	public abstract ComposerBean searchComposer(int composerId) throws AdminException;

	public abstract boolean addComposer(ComposerBean composer, UserBean admin) throws AdminException;

	public abstract boolean validateName(String name);

	public abstract boolean validateDate(String bornDate);

	public abstract boolean validateCaeipiNumber(String number);


	public abstract ArtistBean searchArtist(int artistId) throws AdminException;


	public abstract boolean addArtist(ArtistBean artist, UserBean admin) throws AdminException;


	public abstract boolean validateType(String type);


	public abstract boolean updateComposerName(ComposerBean composer, UserBean admin) throws AdminException;


	public abstract boolean updateComposerBornDate(ComposerBean composer,
			UserBean admin) throws AdminException;


	public abstract boolean updateComposerDiedDate(ComposerBean composer, UserBean admin) throws AdminException;


	public abstract boolean updateComposerCaeipiNumber(ComposerBean composer,
			UserBean admin) throws AdminException;


	public abstract boolean updateComposerMusicSocietyId(ComposerBean composer,
			UserBean admin) throws AdminException;


	


	
}
