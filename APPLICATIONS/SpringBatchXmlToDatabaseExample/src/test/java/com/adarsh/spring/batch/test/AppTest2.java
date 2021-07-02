package com.adarsh.spring.batch.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {
        "classpath:configuration/applicationContext-dataSource.xml",
        "classpath:configuration/applicationContext.xml",
        "classpath:configuration/applicationContext-job.xml",
        "classpath:configuration/applicationContext-test.xml"
})
public class AppTest2 extends AbstractTestNGSpringContextTests {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void launchJob() throws Exception {

		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);

	}
}
