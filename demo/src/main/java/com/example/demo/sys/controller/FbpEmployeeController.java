package com.example.demo.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.fsg.uid.UidGenerator;
import com.example.demo.entity.FbpEmployee;
import com.example.demo.mapper.TestMapper;
import com.example.demo.sys.service.FbpEmployeeService;

@RestController
public class FbpEmployeeController {
	@Autowired
	private FbpEmployeeService fbpEmployeeService;
	@Autowired
	private UidGenerator uidGenerator;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private TestMapper testMapper;

	@RequestMapping("/insert")
	public FbpEmployee insert(FbpEmployee employee) {
		return fbpEmployeeService.insert(employee);
	}

	@RequestMapping("/sequence")
	public Map<String, Object> nextval() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Long> longs = new ArrayList<Long>(10 << (10 ^ 4));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0, len = 10 << (10 ^ 4); i < len; i++) {
			longs.add(uidGenerator.getUID());
		}
		stopWatch.stop();
		String msg = "生成" + (10 << (10 ^ 4)) + "条id,一共花费" + stopWatch.getTotalTimeMillis() + "毫秒";
		result.put("msg", msg);
		result.put("nextval", longs);
		return result;
	}

	@RequestMapping("/invoke")
	@ResponseBody
	public Map<String, Object> invoke() {
		return testMapper.test();
	}

}
