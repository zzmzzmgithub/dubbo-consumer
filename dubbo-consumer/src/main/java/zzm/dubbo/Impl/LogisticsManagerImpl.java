package zzm.dubbo.Impl;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coo8.logistics.business.interfaces.IGetLogisticsInformationManager;
import com.coo8.logistics.model.LogisticsInfoBean;
import com.coo8.logistics.model.LogisticsInfoDetailBean;




import zzm.dubbo.util.TestUtil;

public class LogisticsManagerImpl {
	
	//静态加载资源配置文件
	public final static String[] strArrar =new String[] {"dubbo/dubbo-consumer.xml"};
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		 //
        System.out.println("Begin to load");
        // 加载Spring配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(strArrar);
        context.start();
        //
        System.out.println("End to load");

        // 调用远程方法
        IGetLogisticsInformationManager logisticsManager = (IGetLogisticsInformationManager)context.getBean("logisticsManager");
        
        LogisticsInfoBean bean=new LogisticsInfoBean();
        
        
        //UAT
       // bean.setSubOrderId("2193300121");
        //bean.setMainNo("374578287164");
        //bean.setCourierCompanyCode("99900039");
        
        
        //PRE
        bean.setSubOrderId("1865811048");
        bean.setMainNo("909652450830");
        
        
        
        try {
			LogisticsInfoBean resultBean =logisticsManager.billQuery(bean);
			
			List<LogisticsInfoDetailBean> beanList = resultBean.getDetailbean();
			
			System.out.println("========================================================");
			
			TestUtil.modelToString(resultBean);
			
			System.out.println("========================================================");
			
			TestUtil.ListModelToString(beanList);
			
			System.out.println("========================================================");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	
	
}
