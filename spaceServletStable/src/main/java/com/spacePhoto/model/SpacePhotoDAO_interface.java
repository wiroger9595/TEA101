package com.spacePhoto.model;

import java.util.List;

public interface SpacePhotoDAO_interface {
	public void insert(SpacePhotoVO spacePhotoVO);
	public void delete(String spacePhotoId);
	public void update(SpacePhotoVO spacePhotoVO);
	public SpacePhotoVO selectOne(String spacePhotoId);
	public List<SpacePhotoVO> getAll();
}
