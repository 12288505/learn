package jmeter_socket;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class TestSocket extends AbstractJavaSamplerClient {

	private SampleResult results;
	private String protocol;
	private static String body;

	// ��ʼ��������ʵ������ʱÿ���߳̽�ִ��һ�Σ��ڲ��Է�������ǰִ�У�������LoadRunner�е�init����
	public void setupTest(JavaSamplerContext arg0) {

		results = new SampleResult();
		protocol = arg0.getParameter("protocol");

		System.out.println("-------" + protocol + "-------");

	}

	// ���ô���Ĳ������������ö���������õĲ�������ʾ��Jmeter�Ĳ����б���
	public Arguments getDefaultParameters() {

		Arguments params = new Arguments();
		params.addArgument("protocol", "");
		return params;

	}

	public SampleResult runTest(JavaSamplerContext arg0) {

		// String allResult = "--";
		String SignInResult = "";
		results.sampleStart(); // ����һ�����񣬱�ʾ�����������ʼ�㣬������LoadRunner��lr.start_transaction
		System.out.println("-----------------��ʼ����Jmeter----------------");
		SignInResult = simpleTest(protocol);
		results.sampleEnd(); // ����һ�����񣬱�ʾ��������Ľ����㣬������LoadRunner��lr.end_transaction
		// allResult = allResult + "-" + SignInResult;
		if (SignInResult.isEmpty())

			results.setSuccessful(false); // �����������н���ĳɹ���ʧ�ܣ������"false"���ʾ���ʧ�ܣ��������ʾ�ɹ�
		else
			results.setSuccessful(true);

		results.setResponseMessage(SignInResult);
		// results.setRequestHeaders(sendString);
		System.out.println("-----------------��������----------------");
		return results;

	}

	// ���ܲ���
	private static String simpleTest(String protocol) {

		String result = readInput(protocol);

		return result;

	}

	// ֧��������ʾ
	private static String readInput(String protocol) {

		Main cs = new Main();
		body = cs.getSocketBody(Integer.parseInt(protocol));
		return body;

	}

	public void teardownTest(JavaSamplerContext context) {

	}

}