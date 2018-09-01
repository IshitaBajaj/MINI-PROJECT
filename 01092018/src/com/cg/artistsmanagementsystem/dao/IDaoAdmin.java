/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.exception.AdminException;



/**
 * @author ibajaj
 *
 */
public interface IDaoAdmin {
	public abstract boolean login(UserBean adminBean) throws AdminException;

	public abstract ComposerBean searchComposer(int composerId) throws AdminException;

	public abstract boolean addComposer(ComposerBean composer, UserBean admin) throws AdminException;

	public abstract ArtistBean searchArtist(int artistId) throws AdminException;

	public abstract boolean addArtist(ArtistBean artist, UserBean admin) throws AdminException;

	public abstract boolean updateComposerName(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerBornDate(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerDiedDate(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerCaeipiNumber(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerMusicSocietyId(ComposerBean composer,
			UserBean admin) throws AdminException;
}
