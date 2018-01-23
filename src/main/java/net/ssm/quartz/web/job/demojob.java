package net.ssm.quartz.web.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/22.
 */
public class demojob implements Job {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        log.info("This is a first spring combine quartz !");
        log.info("Welcome to Spring_Quartz World!"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        log.info("Let's begin ! \n \n");
    }
}
