package com.dao;

import com.model.Fashion;
import com.model.Laptop;
import com.model.Mobile;

public interface customerDAO {

	void saveLaptop(Laptop laptop);

	void saveMobile(Mobile mobile);

	void saveFashion(Fashion fashion);

}
