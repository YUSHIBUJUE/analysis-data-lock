package com.example.analysis.datalock.mapper;


import com.example.analysis.datalock.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	void update(@Param("user") User user);
}