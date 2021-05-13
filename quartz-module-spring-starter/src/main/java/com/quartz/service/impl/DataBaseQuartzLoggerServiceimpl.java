package com.quartz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quartz.bean.FbpWsLog;
import com.quartz.mapper.FbpWsLogMapper;
import com.quartz.service.FbpWsLogService;

@Service
public class DataBaseQuartzLoggerServiceimpl implements FbpWsLogService {

	@Autowired
	private FbpWsLogMapper fbpWsLogMapper;

	@Override
	public Void saveLogger(FbpWsLog fbpWsLog) {
		fbpWsLogMapper.insert(fbpWsLog);
		return null;
	}

	@Override
	public List<FbpWsLog> select(FbpWsLog fbpWsLog) {
		return fbpWsLogMapper.selectList(new QueryWrapper<FbpWsLog>(fbpWsLog));
	}

	@Override
	public Page<FbpWsLog> selectPage(FbpWsLog fbpWsLog) {
		Page<FbpWsLog> page = new Page<FbpWsLog>(0, 0, true);
		page = fbpWsLogMapper.selectPage(page, null);
		return page;
	}

}
