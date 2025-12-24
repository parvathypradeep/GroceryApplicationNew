package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class"); // Logger and LogMnanager are classes that helps in retry mechanism
	private static final int maxTry = 2;  // maxtry-no: of times it should retry
	private int count = 0; // count - track count of retry happened

	@Override
	public boolean retry(final ITestResult iTestResult) {  // retry method is overrided from IRetryAnalyzer interface
	if (!iTestResult.isSuccess()) {
	if (this.count < maxTry) {
	LOG.info("Retrying test " + iTestResult.getName() + " with status "
	+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
	this.count++;
	return true;
	}
	}
	return false;
	}

	public String getResultStatusName(final int status) {
	String resultName = null;
	if (status == 1) {
	resultName = "SUCCESS";
	}
	if (status == 2) {
	resultName = "FAILURE";
	}
	if (status == 3) {
	resultName = "SKIP";
	}
	return resultName;
	}

}
