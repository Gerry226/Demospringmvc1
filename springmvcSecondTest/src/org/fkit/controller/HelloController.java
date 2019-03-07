package org.fkit.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc的数据类型绑定
 * @author cuichao
 *
 */
@Controller
public class HelloController{
	private static final Log logger = LogFactory.getLog(HelloController.class);
	
	@RequestMapping(value="/hello")
	public ModelAndView hello(){
		// TODO Auto-generated method stub
		logger.info("handleRequest被调用");
		//创建准备返回的ModelAndView对象，此对象包含返回视图名，模型的名称以及模型对象
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","hello world");
		mv.setViewName("/WEB-INF/content/welcome.jsp");
		return mv;
		
	}
	//一、int和Integer类型
	//1。参数为int类型的请求，若没有传入参数，报500的错误
	@RequestMapping(value="/baseType")
	@ResponseBody
	public String  baseType(int age){
		
		return "age" +age;	
	}
	@RequestMapping(value="/baseType2")
	@ResponseBody
	//@RequestParam注解value属性为传参别名，defaultValue默认赋值，required是否必须传值默认true。
    //若把required设置为false，不传参则不报错
	public String baseType2(@RequestParam(value="xage",defaultValue="1",required=true)int age){
		
		return "age:"+age ;
	}
	
	//参数为数组类型
	@RequestMapping(value="/array2")
	@ResponseBody
	public String array2(String [] name){
		StringBuffer sbf = new StringBuffer(); //线程安全
	//	StringBuilder sbf = new StringBuilder(); 线程不安全
		//
		for (String item : name) {
			sbf.append(item).append("  ");
			System.out.println(sbf);
		}
		return sbf.toString() ;
	}
	
	
	@RequestMapping("/array")
    @ResponseBody
    public String array(String[] name) {
        StringBuilder sbf = new StringBuilder();
        for(String item:name) {
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }
	//三、参数为对象（简单对象）
	@RequestMapping("/ob")
    @ResponseBody
    public String object(User user) {
       
        return user.toString() ;
    }
	
	//多层级对象
	@RequestMapping("/ob2")
    @ResponseBody
    public String objects(User2 user) {
       //name=Tom&age=12&info.phone&info.adress=ss
        return user.toString() ;
    }
	
	//1.2 若参数为2个对象
	
	@RequestMapping("/ob3")
    @ResponseBody
    public String objects2(User2 user2,Admin admin) {
		//localhost:8989/springmvcSecondTest/ob3?user2.name=Tom2&age=20&admin.name=Lucy
        return user2.toString() + "  " + admin.toString();
    }
	
	@InitBinder("user2")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user2.");
    }
    
    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }
	
}
