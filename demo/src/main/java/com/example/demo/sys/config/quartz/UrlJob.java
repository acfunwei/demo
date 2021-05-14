package com.example.demo.sys.config.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UrlJob extends QuartzJobBean {

	// 将logger变为多例共享
	private static Logger logger = LoggerFactory.getLogger(UrlJob.class);

//	@Autowired
//	private RestTemplate restTemplate;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("任务启动");
	}

}
