/**
 * 
 */
package com.quartz.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quartz.bean.FbpWsLog;

/**
 * @author Administrator
 *
 */
public interface FbpWsLogService {

	Void saveLogger(FbpWsLog fbpWsLog);

	List<FbpWsLog> select(FbpWsLog fbpWsLog);

	Page<FbpWsLog> selectPage(FbpWsLog fbpWsLog);

}
