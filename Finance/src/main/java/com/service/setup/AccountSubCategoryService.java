package com.service.setup;


public interface AccountSubCategoryService {

	public Object getAll();

	public Object save(String jsonData, String Authorization);

	public Object update(String jsonData, long id, String Authorization);

	public Object delete(String id, String Authorization);
	
}
