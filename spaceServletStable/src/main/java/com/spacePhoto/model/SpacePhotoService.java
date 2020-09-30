package com.spacePhoto.model;

import java.util.List;

public class SpacePhotoService {
	
	private SpacePhotoDAO_interface dao;
	
	public SpacePhotoService() {
		dao = new SpacePhotoDAO();
	}
	
	public SpacePhotoVO addSpacePhoto(SpacePhotoVO spacePhotoVO) {
		dao.insert(spacePhotoVO);
		return spacePhotoVO;
	}
	
	public SpacePhotoVO updateSpacePhoto(SpacePhotoVO spacePhotoVO) {
		dao.update(spacePhotoVO);
		return spacePhotoVO;
	}
	
	public void deleteSpacePhoto(String spacePhotoId) {
		dao.delete(spacePhotoId);
	}
	
	public SpacePhotoVO selectOneSpacePhoto(String spacePhotoId) {
		return dao.selectOne(spacePhotoId);
	}
	
	public List<SpacePhotoVO> getAll(){
		return dao.getAll();
	}
	
	public SpacePhotoVO updateSpacePhoto(String spacePhotoId, String spaceId, byte[] spacePhoto) {
		
		SpacePhotoVO spacePhotoVO = new SpacePhotoVO();
		
		spacePhotoVO.setSpacePhotoId(spacePhotoId);
		spacePhotoVO.setSpaceId(spaceId);
		spacePhotoVO.setSpacePhoto(spacePhoto);
//		spacePhotoVO.setSpacePhotoBase64(spacePhotoBase64);
		dao.update(spacePhotoVO);
		
		return spacePhotoVO;
	}
	
	public SpacePhotoVO addSpacePhoto(String spacePhotoId, String spaceId, byte[] spacePhoto) {
		
		SpacePhotoVO spacePhotoVO = new SpacePhotoVO();
		
		spacePhotoVO.setSpacePhotoId(spacePhotoId);
		spacePhotoVO.setSpaceId(spaceId);
		spacePhotoVO.setSpacePhoto(spacePhoto);
//		spacePhotoVO.setSpacePhotoBase64(spacePhotoBase64);
		dao.insert(spacePhotoVO);
		
		return spacePhotoVO;
	}
}
