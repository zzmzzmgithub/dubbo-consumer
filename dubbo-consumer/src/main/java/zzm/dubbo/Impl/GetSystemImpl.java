package zzm.dubbo.Impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GetSystemImpl {

	//静态加载资源配置文件
		public final static String[] strArrar =new String[] {"dubbo/dubbo-consumer.xml"};
		
		@SuppressWarnings("resource")
		public static void main(String[] args) throws Exception {
			 //
	        System.out.println("==================Begin to load=================");
	        // 加载Spring配置文件
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(strArrar);
	        context.start();
	        
	        //像本地一样使用bean
	        com.zzm.inface.GetSystemIP getSystemIP = (com.zzm.inface.GetSystemIP)context.getBean("getIP");
	        
	        try {
				String ip =getSystemIP.getIP();
				System.out.println(ip);
				System.out.println("=======================END==============================");
				 // 为保证服务一直开着，利用输入流的阻塞来模拟,测试用
		        System.in.read();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
}
