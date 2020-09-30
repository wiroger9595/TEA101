package com.spaceDetail.model;

import java.util.List;


public class SpaceDetailService {
	
	private SpaceDetailDAOInterface dao;
	
	public SpaceDetailService() {
		dao =  new SpaceDetailDAO();
	}
	
	
	public SpaceDetailVO addSpaceDetail(SpaceDetailVO spaceDetailVO) {
		dao.insert(spaceDetailVO);
		return spaceDetailVO;
	}
	
	
	public SpaceDetailVO updateSapceDetail(SpaceDetailVO spaceDetailVO) {		
		dao.update(spaceDetailVO);
		return spaceDetailVO;
	}
	
	public void deleteSpaceDetail(String spaceId) {
		dao.delete(spaceId);
	}
	
	
	public SpaceDetailVO selectOneSpaceDetail(String spaceId) {
		return dao.selectOne(spaceId);
	}
	
	public List<SpaceDetailVO> selectAllSpaceDetail() {
		return dao.selectAll();
	}

}
