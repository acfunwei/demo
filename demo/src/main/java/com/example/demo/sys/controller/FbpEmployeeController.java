package com.example.demo.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.impl.SnowFlakeUidGenerator;
import com.example.demo.entity.FbpEmployee;
import com.example.demo.mapper.TestMapper;
import com.example.demo.sys.service.FbpEmployeeService;

@RestController
public class FbpEmployeeController {
	@Autowired
	private FbpEmployeeService fbpEmployeeService;
	@Autowired
	private DefaultUidGenerator defaultUidGenerator;
	@Autowired
	private CachedUidGenerator cachedUidGenerator;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private SnowFlakeUidGenerator snowFlakeUidGenerator;

	@RequestMapping("/insert")
	public FbpEmployee insert(FbpEmployee employee) {
		return fbpEmployeeService.insert(employee);
	}

	@RequestMapping("/snownextval")
	public Map<String, Object> snownextval() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Long> longs = new ArrayList<Long>(10 << (10 ^ 4));
		System.out.println(10 << (10 ^ 4));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0, len = 10 << (10 ^ 4); i < len; i++) {
			longs.add(snowFlakeUidGenerator.nextId());
		}
		stopWatch.stop();
		System.out.println("生成" + (10 << (10 ^ 4)) + "id花费" + stopWatch.getTotalTimeMillis() + "毫秒");
		result.put("nextval", longs);
		return result;
	}

	@RequestMapping("/nextval")
	public Map<String, Object> nextval() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Long> longs = new ArrayList<Long>(10 << (10 ^ 4));
		System.out.println(10 << (10 ^ 4));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0, len = 10 << (10 ^ 4); i < len; i++) {
			longs.add(defaultUidGenerator.getUID());
		}
		stopWatch.stop();
		System.out.println("生成" + (10 << (10 ^ 4)) + "id花费" + stopWatch.getTotalTimeMillis() + "毫秒");
		result.put("nextval", longs);
		return result;
	}

	@RequestMapping("/cachenextval")
	@Transactional
	public Map<String, Object> cachenextval() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Long> longs = new ArrayList<Long>(10 << (10 ^ 4));
		System.out.println(10 << (10 ^ 4));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0, len = 10 << (10 ^ 4); i < len; i++) {
			longs.add(cachedUidGenerator.getUID());
		}
		stopWatch.stop();
		StopWatch stopWatch2 = new StopWatch();
		stopWatch2.start();
		try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
			TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
			for (Long long1 : longs) {
				testMapper.insert(long1);
			}
			sqlSession.commit();
		}
		stopWatch2.stop();
		String msg = "生成" + (10 << (10 ^ 4)) + "id, 花费" + stopWatch.getTotalTimeMillis() + "毫秒; " + "插入数据库花费"
				+ stopWatch2.getTotalTimeMillis() + "毫秒";
//		result.put("nextval", longs);
		result.put("msg", msg);
		return result;
	}

	@RequestMapping("/invoke")
	@ResponseBody
	public Map<String, Object> invoke() {
		return testMapper.test();
	}

}
