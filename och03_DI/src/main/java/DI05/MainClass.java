package DI05;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		String configLocation = "classpath:applicationCTX5.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		CollectionBean collectionBean = ctx.getBean("collectionBean", CollectionBean.class);
		Map<String, String> addressList = (Map<String,String>) collectionBean.getAddressList();
		System.out.println("ȫ�浿 �ּ� : " + addressList.get("ȫ�浿"));
		System.out.println("�߾� �ּ� : " + addressList.get("�߾�"));

	}

}
