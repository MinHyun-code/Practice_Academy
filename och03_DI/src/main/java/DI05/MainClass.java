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
		System.out.println("全辨悼 林家 : " + addressList.get("全辨悼"));
		System.out.println("吝居 林家 : " + addressList.get("吝居"));

	}

}
