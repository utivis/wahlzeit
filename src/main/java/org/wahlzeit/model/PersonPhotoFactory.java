package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

public class PersonPhotoFactory extends PhotoFactory {

	protected PersonPhotoFactory() {
		super();
		// do nothing else
	}
	
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 * @methodtype initialization
	 */
	public static void initializePersonPhotoFactory() {
		log.config(LogBuilder.createSystemMessage().addAction("try setting PersonPhotoFactory").toString());
		setInstance(new PersonPhotoFactory());
	}
	
	
	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return new PersonPhoto();
	}
	
	
	/**
	 * Creates a new photo with the specified id
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
		return new PersonPhoto(id);
	}

}
