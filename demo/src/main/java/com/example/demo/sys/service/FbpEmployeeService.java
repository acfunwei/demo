package com.example.demo.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FbpEmployee;
import com.example.demo.mapper.FbpEmployeeMapper;

@Service
public class FbpEmployeeService {

	@Autowired
	private FbpEmployeeMapper fbpEmployeeMapper;

	public FbpEmployee insert(FbpEmployee fbpEmployee) {
		fbpEmployeeMapper.insert(fbpEmployee);
		return fbpEmployee;
	}

}
