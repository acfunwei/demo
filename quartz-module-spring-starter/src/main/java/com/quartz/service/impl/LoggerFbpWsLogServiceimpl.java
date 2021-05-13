package com.quartz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quartz.bean.FbpWsLog;
import com.quartz.service.FbpWsLogService;

/**
 * 只在控制台进行打印
 * 
 * @author Administrator
 *
 */
@Service
public class LoggerFbpWsLogServiceimpl implements FbpWsLogService {

	private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Override
	public Void saveLogger(FbpWsLog fbpWsLog) {
		logger.info(JSON.toJSONString(fbpWsLog));
		return null;
	}

	@Override
	public List<FbpWsLog> select(FbpWsLog fbpWsLog) {
		return new ArrayList<FbpWsLog>(0);
	}

	@Override
	public Page<FbpWsLog> selectPage(FbpWsLog fbpWsLog) {
		// TODO Auto-generated method stub
		return null;
	}

}
