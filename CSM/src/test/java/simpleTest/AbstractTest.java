package simpleTest;

import org.apache.log4j.spi.LoggerFactory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xzf.CsmApplication;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=CsmApplication.class)
public abstract class AbstractTest {

	protected Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	
}
