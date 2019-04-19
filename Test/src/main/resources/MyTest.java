import org.springframework.util.Assert;

import com.Test.Test.com.Test.Test.RESTAPI;
import com.Test.Test.com.Test.Test.Result;

public class MyTest {

	@Test
	public void TestResult() {
		RESTAPI rest = new RESTAPI();
		
		Result result = rest.doRequest(null,"https://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search")
		assertEquals(result.getLo().size() > 0);
	}
}
