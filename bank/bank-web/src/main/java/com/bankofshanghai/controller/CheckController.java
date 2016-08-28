package com.bankofshanghai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.DataTri;
import com.bankofshanghai.service.CheckService;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.StatisticsService;
import com.bankofshanghai.service.UsermanService;
import com.github.pagehelper.PageInfo;

@Controller
public class CheckController {

	@Autowired
	private CheckService checkService;
	@Autowired
	private DataService dataService;
	@Autowired
	private UsermanService usermanService;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping("/checkdata")
	public String checkData(HttpServletRequest request,@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos) 
					throws Exception{
		int pageNo=pageNos;
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		List<BankData> list=dataService.queryByPage(fromuser, touser, tool, pageNo, rows);
		request.setAttribute("listss", list);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		return "checkData";
	}

	@RequestMapping("/check")
	public String check(BankData data, Model model) {
		//开始
		long startTime=System.currentTimeMillis();
		//获得检测结果
		int result = checkService.check(data, dataService.getStatisticsDataByUser(data));
		if (result == -1)  //检测失败
			model.addAttribute("message","检测失败");
		else  //成功
			data.setSafeLevel(result);
		//结束
		long endTime=System.currentTimeMillis()-startTime;
		model.addAttribute("time", endTime+"毫秒");
		model.addAttribute("data", data);
		return "checkData";
	}
	
	@RequestMapping("/check_all")
	public String check_all(HttpServletRequest request, Model model,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos){
		rows = 999;
		long startTime=System.currentTimeMillis();
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		int count=0;
		List<BankData> list=dataService.queryByPage(fromuser, touser, tool, pageNos, rows);
		int n = list.size();
		model.addAttribute("count_n",n);
		for(int i=0;i<n;i++){
			BankData data= list.get(i);
			/*Long userid = (long) data.getFromuser();
			BankUser user = usermanService.getUserByID(userid);
			Integer usertype=user.getUsertype();
			if(usertype==0)//黑名单
			{
				data.setSafeLevel(99);
				dataService.updateDataSafe(data);
			}
			else{
			    
				if(usertype==1)//白名单
				{
					data.setSafeLevel(0);
					dataService.updateDataSafe(data);
				}
				
				else // 灰名单，高风险ip、手机号等
				{*/
					int result = checkService.check(data, dataService.getStatisticsDataByUser(data));
					if (result == -1)  //检测失败
						model.addAttribute("message","检测失败");
					else  {//成功
						data.setSafeLevel(result);
						count++;
					}
					model.addAttribute("data", data);
				//}
					
			//}
			
		}
		long endTime=System.currentTimeMillis()-startTime;
		model.addAttribute("time", endTime+"毫秒");
		model.addAttribute("count",count);
		return "checkData";
	}
	
	@RequestMapping("/check_test")
	public String check_test(HttpServletRequest request, Model model,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos,
			@RequestParam(required = false, defaultValue = "0") int count,
			@RequestParam(required = false, defaultValue = "0") int count_n) {
		
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		List<BankData> list=dataService.queryByPage(fromuser, touser, tool, pageNos, rows);
		
		int count_black=0;
		int count_white=0;
		int n = list.size();
		for(int i=0;i<n;i++){
			BankData data= list.get(i);
			/*Long userid = (long) data.getFromuser();
			BankUser user = usermanService.getUserByID(userid);
			Integer usertype=user.getUsertype();
			if(usertype==0)//黑名单
			{
				data.setSafeLevel(99);
				dataService.updateDataSafe(data);
				count_black++;
			}
			else{
			    
				if(usertype==1)//白名单
				{
					data.setSafeLevel(0);
					dataService.updateDataSafe(data);
					count_white++;
				}
				
				else // 灰名单，高风险ip、手机号等
				{*/
					int result = checkService.check(data, dataService.getStatisticsDataByUser(data));
					if (result == -1)  //检测失败
						model.addAttribute("message","检测失败");
					else  {//成功
						data.setSafeLevel(result);
						count++;
					}
					model.addAttribute("data", data);
					count_n++;
				//}
					
			//}
			
		}
		System.out.println("交易总数为："+n);
		model.addAttribute("count_n",count_n);
		System.out.println("黑名单交易数:"+count_black);
		model.addAttribute("count_black",count_black);
		System.out.println("白名单交易数:"+count_white);
		model.addAttribute("count_white",count_white);
		System.out.println("欺诈交易数为:"+count);
		model.addAttribute("count",count);
		
		list=dataService.queryByPage(fromuser, touser, tool, pageNos, rows);
		
		Long id=null;Integer tri1=null;Integer tri2=null;Integer tri3=null;Integer tri4=null;Integer tri5=null;
		Integer tri6=null;Integer tri7=null;Integer tri8=null;Integer tri9=null;Integer tri10=null;Integer tri11=null;
		Integer tri12=null;
		
		List<DataTri> list_tri = dataService.selectDataTri(id, tri1, tri2, tri3, tri4, tri5, tri6, tri7, tri8, tri9, tri10, tri11, tri12);
		int[] count_datatri = new int[13];
		count_datatri = statisticsService.count_datatri(list_tri);
		
		request.setAttribute("datatri1", count_datatri[1]);       //每条规则触发的数量
		request.setAttribute("datatri2", count_datatri[2]);
		request.setAttribute("datatri3", count_datatri[3]);
		request.setAttribute("datatri4", count_datatri[4]);
		request.setAttribute("datatri5", count_datatri[5]);
		request.setAttribute("datatri6", count_datatri[6]);
		request.setAttribute("datatri7", count_datatri[7]);
		request.setAttribute("datatri8", count_datatri[8]);
		request.setAttribute("datatri9", count_datatri[9]);
		request.setAttribute("datatri10", count_datatri[10]);
		request.setAttribute("datatri11", count_datatri[11]);
		request.setAttribute("datatri12", count_datatri[12]);
		
		
		request.setAttribute("listss", list);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNos); //页号
		
		return "checkData";
	}
}
