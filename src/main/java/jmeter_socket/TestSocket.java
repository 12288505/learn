package jmeter_socket;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class TestSocket extends AbstractJavaSamplerClient {

	private SampleResult results;
	private String protocol;
	private static String body;

	// 初始化方法，实际运行时每个线程仅执行一次，在测试方法运行前执行，类似于LoadRunner中的init方法
	public void setupTest(JavaSamplerContext arg0) {

		results = new SampleResult();
		protocol = arg0.getParameter("protocol");

		System.out.println("-------" + protocol + "-------");

	}

	// 设置传入的参数，可以设置多个，已设置的参数会显示到Jmeter的参数列表中
	public Arguments getDefaultParameters() {

		Arguments params = new Arguments();
		params.addArgument("protocol", "");
		return params;

	}

	public SampleResult runTest(JavaSamplerContext arg0) {

		// String allResult = "--";
		String SignInResult = "";
		results.sampleStart(); // 定义一个事务，表示这是事务的起始点，类似于LoadRunner的lr.start_transaction
		System.out.println("-----------------开始调用Jmeter----------------");
		SignInResult = simpleTest(protocol);
		results.sampleEnd(); // 定义一个事务，表示这是事务的结束点，类似于LoadRunner的lr.end_transaction
		// allResult = allResult + "-" + SignInResult;
		if (SignInResult.isEmpty())

			results.setSuccessful(false); // 用于设置运行结果的成功或失败，如果是"false"则表示结果失败，否则则表示成功
		else
			results.setSuccessful(true);

		results.setResponseMessage(SignInResult);
		// results.setRequestHeaders(sendString);
		System.out.println("-----------------结束调用----------------");
		return results;

	}

	// 功能测试
	private static String simpleTest(String protocol) {

		String result = readInput(protocol);

		return result;

	}

	// 支持中文显示
	private static String readInput(String protocol) {

		Main cs = new Main();
		body = cs.getSocketBody(Integer.parseInt(protocol));
		return body;

	}

	public void teardownTest(JavaSamplerContext context) {

	}

}