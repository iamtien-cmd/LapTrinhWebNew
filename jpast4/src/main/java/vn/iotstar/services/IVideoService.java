package vn.iotstar.services;

import java.util.List;


import vn.iotstar.entity.Video;

public interface IVideoService {
	Video findByVideoname(String name);
	List<Video> findAll(int page, int pagesize);
	int count();
	void delete(String id);
	void update(Video Video);
	void insert(Video Video);
	List<Video> searchByName(String keyword);
	Video findById(String videoid);
	List<Video> findAll();
}
