package com.bankofshanghai.controller;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;   
import java.sql.DriverManager;   
import java.sql.SQLException;   
import java.sql.Statement;
//import net.sf.json.*;

import com.bankofshanghai.mypojo.BankResult;

import com.bankofshanghai.utils.JsonUtils;




@Controller
public class SimulateDadaController {
	
	class Result {
		public String id;     //身份证
		public String idFrom; //付款账号
		public String idTo;   //收款账号
		public Integer money;  //交易金额
		public String city;    //交易所在地
		public Date time;   //交易时间
		public Integer tag;    //标记是否为欺诈
		public String channel;    //交易渠道个人网上银行、企业网上银行、手机银行、网上支付、网上支付等
		public String serviceType; //交易类型（业务类型本人互转、第三方转账、跨行同城转账、跨行异地转账）
		public String IP;         //交易ip地址
		public String state;    //交易状态：回应代码
		public String authMode; //认证方式：分为E盾、短信验证码、手机盾等
		public String terminalNumber;  //终端号
		public String mac;
		Result() {
		};
	}
	private final static int MAX_COMPANY_LIST_LEN = 1200;
	private final static String companyListString = "00000C#00000E#000075#000095#0000F0#000102#000103#000130#000142#000143#00014A#000163#000164#000181#000196#000197#0001C7#0001C9#0001E6#0001E7#000216#000217#00024A#00024B#00025F#000278#00027D#00027E#0002A5#0002B3#0002B9#0002BA#0002DC#0002EE#0002FC#0002FD#000331#000332#000342#000347#00034B#00036B#00036C#00037F#000393#00039F#0003A0#0003E3#0003E4#0003FE#00040B#00041F#000423#000427#000428#000438#00044D#00044E#000456#00045A#00046B#00046D#00046E#000480#000496#00049A#00049B#0004BD#0004C0#0004C1#0004DC#0004DD#0004DE#0004E2#0004EA#000500#000501#000502#00051A#000531#000532#00055D#00055E#00055F#000573#000574#000585#00059A#00059B#0005B5#0005DC#0005DD#000625#000628#00062A#000652#000653#00065B#00067C#00068C#0006C1#0006D6#0006D7#00070D#00070E#00074D#00074F#000750#000772#000784#000785#0007B3#0007B4#0007E0#0007E9#0007EB#0007EC#000802#00080E#000820#000821#000874#00087C#00087D#000883#00089A#0008A3#0008A4#0008C2#0008C7#0008E2#0008E3#000911#000912#000918#000943#000944#00097B#00097C#000997#0009B6#0009B7#0009E8#0009E9#000A04#000A27#000A28#000A41#000A42#000A57#000A5E#000A8A#000A8B#000A95#000AB7#000AB8#000AD9#000AE0#000AF3#000AF4#000AF7#000B06#000B0E#000B45#000B46#000B5D#000B5F#000B60#000B85#000B86#000BAC#000BBE#000BBF#000BC5#000BCD#000BDB#000BE1#000BFC#000BFD#000C30#000C31#000C41#000C43#000C85#000C86#000CCE#000CCF#000CDB#000CE5#000CE6#000CF1#000CF7#000CF8#000D0B#000D28#000D29#000D54#000D56#000D57#000D65#000D66#000D88#000D93#000D9D#000DAE#000DBC#000DBD#000DE5#000DEC#000DED#000E07#000E08#000E0C#000E35#000E38#000E39#000E40#000E5C#000E62#000E6A#000E7F#000E83#000E84#000E86#000EB3#000EC0#000EC7#000ED6#000ED7#000EED#000F06#000F20#000F23#000F24#000F34#000F35#000F3D#000F61#000F62#000F66#000F6A#000F8F#000F90#000F9F#000FB5#000FBB#000FC3#000FCB#000FCD#000FDE#000FF7#000FF8#001007#00100B#00100D#001011#001014#001018#00101F#001029#00102F#001040#001045#00104B#001054#001055#00105A#001079#00107B#001083#00108C#0010A6#0010B3#0010DB#0010E3#0010F6#0010FA#0010FF#00110A#001111#00111A#001120#001121#001124#00113F#001143#001150#001158#00115C#00115D#001180#001185#00118B#001192#001193#001195#00119F#0011AE#0011BB#0011BC#0011F9#001200#001201#001217#00121E#001225#001237#00123F#001243#001244#001247#00124B#001262#001279#00127F#001280#001283#00128A#0012A9#0012C9#0012D1#0012D2#0012D9#0012DA#0012EE#0012F0#0012F2#0012FB#001302#00130A#001310#001315#001319#00131A#001320#001321#001346#001349#00135F#001360#001365#001370#001371#001372#001374#001377#00137F#001380#001392#0013A9#0013C3#0013C4#0013CE#0013E8#0013F7#0013FD#001404#00140D#00140E#00141B#00141C#001422#001438#00143E#001451#001469#00146A#00146C#00147C#00149A#0014A7#0014A8#0014A9#0014BF#0014C2#0014C7#0014D5#0014E8#0014F1#0014F2#0014F6#001500#001517#00152A#00152B#00152C#00152F#00153F#001540#001560#001562#001563#001570#001599#00159A#00159B#0015A0#0015A8#0015B9#0015C1#0015C5#0015C6#0015C7#0015DE#0015E8#0015E9#0015F9#0015FA#001601#001620#001626#001632#001635#001646#001647#00164D#00164E#001660#00166B#00166C#00166F#001675#001676#00169C#00169D#0016B5#0016B6#0016B8#0016BC#0016C7#0016C8#0016CA#0016CB#0016DB#0016E0#0016EA#0016EB#0016F0#001700#001708#00170E#00170F#00173F#001742#00174B#001759#00175A#001765#00177C#001783#001784#001794#001795#00179A#0017A4#0017B0#0017C9#0017CB#0017CC#0017D1#0017D5#0017DF#0017E0#0017E2#0017E3#0017E4#0017E5#0017E6#0017E7#0017E8#0017E9#0017EA#0017EB#0017EC#0017EE#0017F2#00180F#001813#001818#001819#00182F#001830#001831#001832#001833#001834#001839#001842#00184D#001868#00186E#001871#001873#001874#001882#00188B#00188D#0018A4#0018AF#0018B0#0018B9#0018BA#0018C0#0018C5#0018DE#0018F8#0018FE#001906#001907#00192C#00192D#00192F#001930#001947#00194F#001955#001956#00195B#00195E#001963#001969#001979#00198F#001992#001999#0019A6#0019A9#0019AA#0019B7#0019B9#0019BB#0019C0#0019C5#0019CB#0019D1#0019D2#0019E1#0019E2#0019E3#0019E7#0019E8#001A16#001A1B#001A1E#001A2F#001A30#001A4B#001A66#001A6C#001A6D#001A70#001A75#001A77#001A80#001A89#001A8A#001A8F#001AA0#001AA1#001AA2#001AAD#001AC1#001ADB#001ADC#001ADE#001AE2#001AE3#001AF0#001B0C#001B0D#001B11#001B21#001B25#001B2A#001B2B#001B2F#001B33#001B52#001B53#001B54#001B59#001B63#001B77#001B78#001B8F#001B90#001B98#001BAF#001BBA#001BC0#001BD4#001BD5#001BD7#001BDD#001BE9#001BED#001BEE#001C0E#001C0F#001C10#001C11#001C12#001C17#001C23#001C35#001C43#001C57#001C58#001C8E#001C9A#001C9C#001CA4#001CB0#001CB1#001CB3#001CBF#001CC0#001CC1#001CC4#001CC5#001CD4#001CD6#001CDF#001CEB#001CF0#001CF6#001CF9#001CFB#001D09#001D0D#001D25#001D28#001D2E#001D3B#001D42#001D45#001D46#001D4C#001D4F#001D6B#001D6E#001D70#001D71#001D73#001D7E#001D98#001DA1#001DA2#001DAF#001DB5#001DBA#001DBE#001DE0#001DE1#001DE5#001DE6#001DE9#001DF6#001DFD#001DFE#001E0B#001E10#001E13#001E14#001E1F#001E2A#001E3A#001E3B#001E45#001E46#001E49#001E4A#001E4F#001E52#001E58#001E5A#001E64#001E65#001E67#001E6B#001E79#001E7A#001E7D#001E7E#001E8D#001EA3#001EA4#001EA8#001EBD#001EBE#001EC1#001EC2#001EC9#001ECA#001EDC#001EE1#001EE2#001EE5#001EF6#001EF7#001F00#001F01#001F0A#001F12#001F26#001F27#001F29#001F33#001F3B#001F3C#001F41#001F46#001F5B#001F5C#001F5D#001F6C#001F6D#001F7E#001F9A#001F9D#001F9E#001FA7#001FC4#001FC9#001FCA#001FCC#001FCD#001FDA#001FDE#001FDF#001FE4#001FF3#002032#002040#002060#002075#00207B#0020A6#0020AF#0020D8#0020DA#002105#002108#002109#002119#00211B#00211C#00211E#002129#002135#002136#002143#00214C#002155#002156#002159#00215A#00215C#00215D#002162#00216A#00216B#002170#002180#002191#00219B#00219E#0021A0#0021A1#0021AA#0021AB#0021AE#0021BA#0021BE#0021D1#0021D2#0021D7#0021D8#0021E1#0021E9#0021FC#0021FE#00220C#00220D#002210#002219#00222D#00223A#00223F#002241#002255#002256#002257#002264#002265#002266#002267#00226B#002275#00227F#002283#002290#002291#002298#0022A1#0022A5#0022A6#0022B0#0022B4#0022BD#0022BE#0022CE#0022FA#0022FB#0022FC#0022FD#002304#002305#00230B#00230D#002312#002314#002315#002326#002332#002333#002334#002339#00233A#00233E#002345#00235D#00235E#002368#002369#00236C#002374#002375#00237D#002395#002399#00239C#0023A2#0023A3#0023AB#0023AC#0023AE#0023AF#0023B4#0023BE#0023C2#0023C6#0023D3#0023D4#0023D6#0023D7#0023DF#0023EA#0023EB#0023ED#0023EE#0023F1#0023F8#002400#002401#002403#002404#002413#002414#002436#002437#002438#002443#002450#002451#002454#00246C#002473#00247C#00247D#00247F#002481#002482#00248D#002490#002491#002492#002493#002495#002497#002498#0024A0#0024A1#0024A5#0024B5#0024BA#0024BE#0024C1#0024C3#0024C4#0024D6#0024D7#0024DC#0024E8#0024E9#0024EF#0024F7#0024F9#002500#00252E#002538#002545#002546#002547#002548#00254B#002564#002566#002567#002568#002583#002584#00259C#00259E#0025B3#0025B4#0025B5#0025BA#0025BC#0025BD#0025C3#0025C4#0025CF#0025D0#0025E7#0025F1#0025F2#002608#00260A#00260B#002636#002637#00263E#002641#002642#00264A#002651#002652#002654#002655#00265A#00265D#00265F#002668#002669#002688#002698#002699#0026B0#0026B9#0026BA#0026BB#0026C6#0026C7#0026CA#0026CB#0026CC#0026F3#003005#003019#00301E#003024#003040#003065#00306E#003071#003078#00307B#003080#003085#003094#003096#0030A3#0030B6#0030BD#0030C1#0030F2#004001#00400B#004027#004043#004096#005004#00500B#00500F#005014#00502A#00503E#005043#005050#005053#005054#005073#005080#00508B#005099#0050A2#0050A7#0050BA#0050BD#0050D1#0050DA#0050E2#0050E3#0050E4#0050F0#006008#006009#00602F#006038#00603E#006047#00605C#006070#006083#00608C#006097#0060B0#0060CF#008021#008039#00805F#00809F#0080A0#0080C8#009004#00900C#009021#009027#00902B#00905F#009069#00906D#00906F#009086#00908E#009092#00909C#0090A6#0090AB#0090B1#0090BF#0090CF#0090D9#0090F2#00A024#00A040#00A077#00A081#00A08E#00A0BF#00A0C5#00A0C6#00A0C9#00A0CA#00A0F8#00AA00#00AA01#00AA02#00B04A#00B064#00B08E#00B0C2#00B0D0#00C04F#00C0BE#00C0F9#00D006#00D058#00D063#00D079#00D088#00D090#00D095#00D096#00D097#00D0B7#00D0BA#00D0BB#00D0BC#00D0C0#00D0D3#00D0D8#00D0E4#00D0F6#00D0FF#00E000#00E003#00E00C#00E014#00E01E#00E02B#00E034#00E04F#00E052#00E064#00E06F#00E08F#00E0A3#00E0B0#00E0B1#00E0DA#00E0F7#00E0F9#00E0FC#00E0FE#02608C#02C08C#080007#080009#080028#080046#08004E";
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";   
    public static final String DBURL = "jdbc:mysql://localhost:3306/bank?characterEncoding=utf-8";   
    //现在使用的是mysql数据库，是直接连接的，所以此处必须有用户名和密码   
    public static final String USERNAME = "root";   
    public static final String PASSWORD = "474104";   

	class Province{
		private Integer ProId;
		private String name;
		private Integer ProSort;
		private String ProRemark;
		
		
		public Integer getProId() {
			return ProId;
		}
		public void setProId(Integer proId) {
			ProId = proId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getProSort() {
			return ProSort;
		}
		public void setProSort(Integer proSort) {
			ProSort = proSort;
		}
		public String getProRemark() {
			return ProRemark;
		}
		public void setProRemark(String proRemark) {
			ProRemark = proRemark;
		}
	}

	@RequestMapping("/ajax/simulateNormal")
	@ResponseBody
	public BankResult simulateNormalData(Integer moneyFrom, Integer moneyTo, String city, String timeFrom, String timeTo, Integer amount,  String channel, String serviceType, String IP, String state, String authMode, String terminalNumber, String mac) {

		Result[] re = new Result[amount];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < amount; i++) {
			re[i] = new Result();
			re[i].id = getFixLenthString(8);
			re[i].idFrom = "62" + getFixLenthString(16);
			re[i].idTo = "62" + getFixLenthString(16);
			re[i].money = randommoney(moneyTo, moneyFrom);
			re[i].city = city;
			re[i].time = randomDate(timeFrom, timeTo);
			re[i].tag = 0;
			re[i].channel = (channel==null||"".equals(channel))? "empty":(channel.equals("0"))?getRandomChannel():channel;
			re[i].serviceType = (serviceType==null||serviceType.equals(""))?"empty":(serviceType.equals("0"))?getRandomServiceType():serviceType;
			re[i].IP = (IP==null|| IP.equals(""))?"empty":getRandomIp();
			re[i].state = (state==null||state.equals(""))? "empty":state;
			re[i].authMode = (authMode==null||authMode.equals(""))? "empty":(authMode.equals("0"))?getRandomAuthMode():authMode;
			re[i].terminalNumber = (terminalNumber==null||terminalNumber.equals(""))? "empty":(terminalNumber.equals("0"))?getRandomTerminalNumber():terminalNumber;
			re[i].mac = (mac==null || mac.equals(""))?"empty":(mac.equals("0"))?getRandomMac():mac;
		}
		writeSql(re,amount);
		try {
			
			FileWriter fileWriter = new FileWriter("./Result.csv", true);
			for (int k = 0; k < amount; k++) {
				fileWriter.write(re[k].id + ',' + re[k].idFrom + ',' + re[k].idTo + ',' + re[k].money + ',' + re[k].city+ ',' + format.format(re[k].time) );
				if(re[k].channel!="empty"){fileWriter.write(","+re[k].channel);}
				if(re[k].serviceType!="empty"){fileWriter.write(","+re[k].serviceType);}
				if(re[k].IP!="empty"){fileWriter.write(","+re[k].IP);}
				if(re[k].state!="empty"){fileWriter.write(","+re[k].state);}
				if(re[k].authMode!="empty"){fileWriter.write(","+re[k].authMode);}
				if(re[k].terminalNumber!="empty"){fileWriter.write(","+re[k].terminalNumber);}
				if(re[k].mac!="empty"){fileWriter.write(","+re[k].mac);}
				fileWriter.write(","+re[k].tag);
				fileWriter.write("\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
			mysql();
			deleteTemp();
			return BankResult.ok();
		} catch (Exception er) {
			System.out.println(er.getMessage());
			return BankResult.build(0, "filewriter error");
		}		
	}

	@RequestMapping("/ajax/simulateFraud")
	@ResponseBody
	public BankResult simulateFraudlData(Integer fraudNumIdFrom, Integer fraudNumIdTo1, Integer fraudNumIdTo2, Integer fraudMoneyFrom,
			Integer fraudMoneyTo, String fraudNumCity, String fraudTimeFrom, String fraudTimeTo, String timeRange,
			String timeType, String percent,String fraudChannel,String fraudServiceType,String fraudIp,String fraudState,String fraudAuthMode,String fraudTerminalNumber,String fraudMac) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Result[] re_fraud = new Result[fraudNumIdFrom * fraudNumIdTo2];
		int j = 0;
		int temptag;
		String tempIdFrom;
		String tempId;
		Date tempdatebegin;
		Date tempdateend;
		Integer tempTimeType= Integer.parseInt(timeType);
		Integer tempTimeRange=Integer.parseInt(timeRange);
		for (int i = 0; i < fraudNumIdFrom; i++) {
			int temp = randomint(fraudNumIdTo2, fraudNumIdTo1);
			tempIdFrom = "62" + getFixLenthString(16);
			tempId = getFixLenthString(8);
			tempdatebegin = randomDateFraud(fraudTimeFrom, fraudTimeTo, tempTimeType, tempTimeRange);
			tempdateend = addOrMinusYear(tempdatebegin, tempTimeType, tempTimeRange);
			temptag = (Math.random() < Double.valueOf(percent)) ? 1 : 0;
			String[] tempMac = new String[temp];
			for (int c=0;c<temp;c++){
				tempMac[c] = getRandomMac();
			}
			for (int k = 0; k < temp; k++) {
				re_fraud[j] = new Result();
				re_fraud[j].id = tempId;
				re_fraud[j].idFrom = tempIdFrom;
				re_fraud[j].idTo = "62" + getFixLenthString(16);
				re_fraud[j].money = randommoney(fraudMoneyTo, fraudMoneyFrom);
				re_fraud[j].city = fraudNumCity;
				re_fraud[j].time = randomDateFraudFinal(tempdatebegin, tempdateend);
				re_fraud[j].tag = temptag;
				re_fraud[j].channel = (fraudChannel==null||"".equals(fraudChannel))? "empty":(fraudChannel.equals("0"))?getRandomChannel():fraudChannel;
				re_fraud[j].serviceType = (fraudServiceType==null||fraudServiceType.equals(""))?"empty":(fraudServiceType.equals("0"))?getRandomServiceType():fraudServiceType;
				re_fraud[j].IP = (fraudIp==null|| fraudIp.equals(""))?"empty":getRandomIp();
				re_fraud[j].state = (fraudState==null||fraudState.equals(""))? "empty":fraudState;
				re_fraud[j].authMode = (fraudAuthMode==null||fraudAuthMode.equals(""))? "empty":(fraudAuthMode.equals("0"))?getRandomAuthMode():fraudAuthMode;
				re_fraud[j].terminalNumber = (fraudTerminalNumber==null||fraudTerminalNumber.equals(""))? "empty":(fraudTerminalNumber.equals("0"))?getRandomTerminalNumber():fraudTerminalNumber;
				re_fraud[j].mac = (fraudMac==null || fraudMac.equals(""))?"empty":(fraudMac.equals("0"))?tempMac[randomint(temp-1,0)]:fraudMac;
				j++;
			}	
		}
		writeSql(re_fraud,j);	
		try {
			FileWriter fileWriter = new FileWriter("./ResultFraud.csv", true);
			for (int k = 0; k < j; k++) {
				fileWriter.write(re_fraud[k].id + ',' + re_fraud[k].idFrom + ',' + re_fraud[k].idTo + ','+ re_fraud[k].money + ',' + re_fraud[k].city + ',' + format.format(re_fraud[k].time)); 
				if(re_fraud[k].channel!="empty"){fileWriter.write(","+re_fraud[k].channel);}
				if(re_fraud[k].serviceType!="empty"){fileWriter.write(","+re_fraud[k].serviceType);}
				if(re_fraud[k].IP!="empty"){fileWriter.write(","+re_fraud[k].IP);}
				if(re_fraud[k].state!="empty"){fileWriter.write(","+re_fraud[k].state);}
				if(re_fraud[k].authMode!="empty"){fileWriter.write(","+re_fraud[k].authMode);}
				if(re_fraud[k].terminalNumber!="empty"){fileWriter.write(","+re_fraud[k].terminalNumber);}
				if(re_fraud[k].mac!="empty"){fileWriter.write(","+re_fraud[k].mac);}
				fileWriter.write(","+re_fraud[k].tag);
				fileWriter.write("\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
			mysql();
			deleteTemp();
			return BankResult.ok();
		} catch (Exception er) {
			System.out.println(er.getMessage());
			return BankResult.build(0, "filewriter error");
		}

	}

	@RequestMapping("/ajax/simulateRule1")
	@ResponseBody
	public void simulateRule1Data(int numRule1, double rule1Percent) {
		Result[] re_rule1 = new Result[numRule1 * 10];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int rule1k = 0;
		String rule1city = "中国上海上海";
		String tempRule1IdFrom;
		String tempRule1Id;
		Date tempRule1Date = new Date();
		Date tempRule1DateBegin;
		Date tempRule1DateEnd;
		int tempRule1tag;
		for (int i = 0; i < numRule1; i++) {
			int temp = randomint(3, 6);
			tempRule1IdFrom = "62" + getFixLenthString(16);
			tempRule1Id = getFixLenthString(8);
			tempRule1DateBegin = addOrMinusYear(tempRule1Date, 2, -6);
			tempRule1DateEnd = addOrMinusYear(tempRule1DateBegin, 5, 1);
			tempRule1tag = (Math.random() < rule1Percent) ? 1 : 0;
			for (int j = 0; j < temp; j++) {
				re_rule1[rule1k] = new Result();
				re_rule1[rule1k].id = tempRule1Id;
				re_rule1[rule1k].idFrom = tempRule1IdFrom;
				re_rule1[rule1k].idTo = "62" + getFixLenthString(16);
				re_rule1[rule1k].money = randommoney(300, 100);
				re_rule1[rule1k].city = rule1city;
				re_rule1[rule1k].time = randomDateFraudFinal(tempRule1DateBegin, tempRule1DateEnd);
				re_rule1[rule1k].tag = tempRule1tag;
				rule1k++;
			}
			re_rule1[rule1k] = new Result();
			re_rule1[rule1k].id = tempRule1Id;
			re_rule1[rule1k].idFrom = tempRule1IdFrom;
			re_rule1[rule1k].idTo = "62" + getFixLenthString(16);
			re_rule1[rule1k].money = randommoney(20000, 10000);
			re_rule1[rule1k].city = rule1city;
			re_rule1[rule1k].time = tempRule1DateEnd;
			re_rule1[rule1k].tag = tempRule1tag;
			rule1k++;
		}
		try {
			FileWriter fileWriter = new FileWriter("./ResultFraud.csv", true);
			for (int k = 0; k < rule1k; k++) {
				fileWriter.write(re_rule1[k].id + ',' + re_rule1[k].idFrom + ',' + re_rule1[k].idTo + ','
						+ re_rule1[k].money + ',' + re_rule1[k].city + ',' + format.format(re_rule1[k].time) + ','
						+ re_rule1[k].tag);
				fileWriter.write("\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
	}

	private static int randomint(int max, int min) {
		Random random = new Random();
		int randomNumber = random.nextInt(max) % (max - min + 1) + min;
		return randomNumber;
	}

	private static int randommoney(int max, int min) {
		Random random = new Random();
		int temp = random.nextInt(max) % (max - min + 1) + min;
		int randomNumber = temp - temp % 100;
		return randomNumber;
	}

	private static String getFixLenthString(int strLength) {

		// Random rm = new Random();

		// 获得随机数
		// double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
		// double pross = (Math.random()*Math.pow(10, strLength));
		// 将获得的获得随机数转化为字符串
		String fixLenthString1 = String.valueOf(Math.random());
		String fixLenthString2 = String.valueOf(Math.random());
		// 返回固定的长度的随机数
		return (fixLenthString1.substring(2, strLength / 2 + 2) + fixLenthString2.substring(2, strLength / 2 + 2));
	}

	private static Date randomDate(String beginDate, String endDate) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);// 开始日期
			Date end = format.parse(endDate);// 结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Date randomDateFraudFinal(Date beginDate, Date endDate) {
		try {
			// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// Date start = format.parse(beginDate);// 开始日期
			Date start = beginDate;
			Date end = endDate;// 结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Date randomDateFraud(String beginDate, String endDate, int k, int i) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);// 开始日期
			Date temp = format.parse(endDate);// 结束日期
			Date end = addOrMinusYear(temp, k, i);
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end) {
		long rtnn = begin + (long) (Math.random() * (end - begin));
		if (rtnn == begin || rtnn == end) {
			return random(begin, end);
		}
		return rtnn;
	}

	public static Date addOrMinusYear(Date ti, int k, int i) {
		Date rtn = null;
		GregorianCalendar cal = new GregorianCalendar();
		// Date date = new Date(ti);
		cal.setTime(ti);
		cal.add(k, i);
		rtn = cal.getTime();
		return rtn;
		// 年份的加减，比如求一年后i=1，取1年前i=-1
		// 如果是月份加减cal.add(2, i);
		// 如果是星期加减cal.add(3, i);
		// 如果是每日加减cal.add(5, i);
		// 如果是小时加减cal.add(10, i);
		// 如果是分钟加减cal.add(12, i);
		// 如果是秒的加减cal.add(13, i);
	}
    
	//随机生成国内IP地址  
    public static String getRandomIp(){
         
        //ip范围
        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
                         {1038614528,1039007743},//61.232.0.0-61.237.255.255
                         {1783627776,1784676351},//106.80.0.0-106.95.255.255
                         {2035023872,2035154943},//121.76.0.0-121.77.255.255
                         {2078801920,2079064063},//123.232.0.0-123.235.255.255
                         {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
                         {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
                         {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
                         {-770113536,-768606209},//210.25.0.0-210.47.255.255
                         {-569376768,-564133889}, //222.16.0.0-222.95.255.255
        };
         
        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
        return ip;
    }
 
    //将十进制转换成ip地址
    public static String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";
         
        b[0] = (int)((ip >> 24) & 0xff);
        b[1] = (int)((ip >> 16) & 0xff);
        b[2] = (int)((ip >> 8) & 0xff);
        b[3] = (int)(ip & 0xff);
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]); 
         
        return x; 
     }

    public static String getRandomMac(){
    	
    //	private final static String companyListString = "00000C#00000E#000075#000095#0000F0#000102#000103#000130#000142#000143#00014A#000163#000164#000181#000196#000197#0001C7#0001C9#0001E6#0001E7#000216#000217#00024A#00024B#00025F#000278#00027D#00027E#0002A5#0002B3#0002B9#0002BA#0002DC#0002EE#0002FC#0002FD#000331#000332#000342#000347#00034B#00036B#00036C#00037F#000393#00039F#0003A0#0003E3#0003E4#0003FE#00040B#00041F#000423#000427#000428#000438#00044D#00044E#000456#00045A#00046B#00046D#00046E#000480#000496#00049A#00049B#0004BD#0004C0#0004C1#0004DC#0004DD#0004DE#0004E2#0004EA#000500#000501#000502#00051A#000531#000532#00055D#00055E#00055F#000573#000574#000585#00059A#00059B#0005B5#0005DC#0005DD#000625#000628#00062A#000652#000653#00065B#00067C#00068C#0006C1#0006D6#0006D7#00070D#00070E#00074D#00074F#000750#000772#000784#000785#0007B3#0007B4#0007E0#0007E9#0007EB#0007EC#000802#00080E#000820#000821#000874#00087C#00087D#000883#00089A#0008A3#0008A4#0008C2#0008C7#0008E2#0008E3#000911#000912#000918#000943#000944#00097B#00097C#000997#0009B6#0009B7#0009E8#0009E9#000A04#000A27#000A28#000A41#000A42#000A57#000A5E#000A8A#000A8B#000A95#000AB7#000AB8#000AD9#000AE0#000AF3#000AF4#000AF7#000B06#000B0E#000B45#000B46#000B5D#000B5F#000B60#000B85#000B86#000BAC#000BBE#000BBF#000BC5#000BCD#000BDB#000BE1#000BFC#000BFD#000C30#000C31#000C41#000C43#000C85#000C86#000CCE#000CCF#000CDB#000CE5#000CE6#000CF1#000CF7#000CF8#000D0B#000D28#000D29#000D54#000D56#000D57#000D65#000D66#000D88#000D93#000D9D#000DAE#000DBC#000DBD#000DE5#000DEC#000DED#000E07#000E08#000E0C#000E35#000E38#000E39#000E40#000E5C#000E62#000E6A#000E7F#000E83#000E84#000E86#000EB3#000EC0#000EC7#000ED6#000ED7#000EED#000F06#000F20#000F23#000F24#000F34#000F35#000F3D#000F61#000F62#000F66#000F6A#000F8F#000F90#000F9F#000FB5#000FBB#000FC3#000FCB#000FCD#000FDE#000FF7#000FF8#001007#00100B#00100D#001011#001014#001018#00101F#001029#00102F#001040#001045#00104B#001054#001055#00105A#001079#00107B#001083#00108C#0010A6#0010B3#0010DB#0010E3#0010F6#0010FA#0010FF#00110A#001111#00111A#001120#001121#001124#00113F#001143#001150#001158#00115C#00115D#001180#001185#00118B#001192#001193#001195#00119F#0011AE#0011BB#0011BC#0011F9#001200#001201#001217#00121E#001225#001237#00123F#001243#001244#001247#00124B#001262#001279#00127F#001280#001283#00128A#0012A9#0012C9#0012D1#0012D2#0012D9#0012DA#0012EE#0012F0#0012F2#0012FB#001302#00130A#001310#001315#001319#00131A#001320#001321#001346#001349#00135F#001360#001365#001370#001371#001372#001374#001377#00137F#001380#001392#0013A9#0013C3#0013C4#0013CE#0013E8#0013F7#0013FD#001404#00140D#00140E#00141B#00141C#001422#001438#00143E#001451#001469#00146A#00146C#00147C#00149A#0014A7#0014A8#0014A9#0014BF#0014C2#0014C7#0014D5#0014E8#0014F1#0014F2#0014F6#001500#001517#00152A#00152B#00152C#00152F#00153F#001540#001560#001562#001563#001570#001599#00159A#00159B#0015A0#0015A8#0015B9#0015C1#0015C5#0015C6#0015C7#0015DE#0015E8#0015E9#0015F9#0015FA#001601#001620#001626#001632#001635#001646#001647#00164D#00164E#001660#00166B#00166C#00166F#001675#001676#00169C#00169D#0016B5#0016B6#0016B8#0016BC#0016C7#0016C8#0016CA#0016CB#0016DB#0016E0#0016EA#0016EB#0016F0#001700#001708#00170E#00170F#00173F#001742#00174B#001759#00175A#001765#00177C#001783#001784#001794#001795#00179A#0017A4#0017B0#0017C9#0017CB#0017CC#0017D1#0017D5#0017DF#0017E0#0017E2#0017E3#0017E4#0017E5#0017E6#0017E7#0017E8#0017E9#0017EA#0017EB#0017EC#0017EE#0017F2#00180F#001813#001818#001819#00182F#001830#001831#001832#001833#001834#001839#001842#00184D#001868#00186E#001871#001873#001874#001882#00188B#00188D#0018A4#0018AF#0018B0#0018B9#0018BA#0018C0#0018C5#0018DE#0018F8#0018FE#001906#001907#00192C#00192D#00192F#001930#001947#00194F#001955#001956#00195B#00195E#001963#001969#001979#00198F#001992#001999#0019A6#0019A9#0019AA#0019B7#0019B9#0019BB#0019C0#0019C5#0019CB#0019D1#0019D2#0019E1#0019E2#0019E3#0019E7#0019E8#001A16#001A1B#001A1E#001A2F#001A30#001A4B#001A66#001A6C#001A6D#001A70#001A75#001A77#001A80#001A89#001A8A#001A8F#001AA0#001AA1#001AA2#001AAD#001AC1#001ADB#001ADC#001ADE#001AE2#001AE3#001AF0#001B0C#001B0D#001B11#001B21#001B25#001B2A#001B2B#001B2F#001B33#001B52#001B53#001B54#001B59#001B63#001B77#001B78#001B8F#001B90#001B98#001BAF#001BBA#001BC0#001BD4#001BD5#001BD7#001BDD#001BE9#001BED#001BEE#001C0E#001C0F#001C10#001C11#001C12#001C17#001C23#001C35#001C43#001C57#001C58#001C8E#001C9A#001C9C#001CA4#001CB0#001CB1#001CB3#001CBF#001CC0#001CC1#001CC4#001CC5#001CD4#001CD6#001CDF#001CEB#001CF0#001CF6#001CF9#001CFB#001D09#001D0D#001D25#001D28#001D2E#001D3B#001D42#001D45#001D46#001D4C#001D4F#001D6B#001D6E#001D70#001D71#001D73#001D7E#001D98#001DA1#001DA2#001DAF#001DB5#001DBA#001DBE#001DE0#001DE1#001DE5#001DE6#001DE9#001DF6#001DFD#001DFE#001E0B#001E10#001E13#001E14#001E1F#001E2A#001E3A#001E3B#001E45#001E46#001E49#001E4A#001E4F#001E52#001E58#001E5A#001E64#001E65#001E67#001E6B#001E79#001E7A#001E7D#001E7E#001E8D#001EA3#001EA4#001EA8#001EBD#001EBE#001EC1#001EC2#001EC9#001ECA#001EDC#001EE1#001EE2#001EE5#001EF6#001EF7#001F00#001F01#001F0A#001F12#001F26#001F27#001F29#001F33#001F3B#001F3C#001F41#001F46#001F5B#001F5C#001F5D#001F6C#001F6D#001F7E#001F9A#001F9D#001F9E#001FA7#001FC4#001FC9#001FCA#001FCC#001FCD#001FDA#001FDE#001FDF#001FE4#001FF3#002032#002040#002060#002075#00207B#0020A6#0020AF#0020D8#0020DA#002105#002108#002109#002119#00211B#00211C#00211E#002129#002135#002136#002143#00214C#002155#002156#002159#00215A#00215C#00215D#002162#00216A#00216B#002170#002180#002191#00219B#00219E#0021A0#0021A1#0021AA#0021AB#0021AE#0021BA#0021BE#0021D1#0021D2#0021D7#0021D8#0021E1#0021E9#0021FC#0021FE#00220C#00220D#002210#002219#00222D#00223A#00223F#002241#002255#002256#002257#002264#002265#002266#002267#00226B#002275#00227F#002283#002290#002291#002298#0022A1#0022A5#0022A6#0022B0#0022B4#0022BD#0022BE#0022CE#0022FA#0022FB#0022FC#0022FD#002304#002305#00230B#00230D#002312#002314#002315#002326#002332#002333#002334#002339#00233A#00233E#002345#00235D#00235E#002368#002369#00236C#002374#002375#00237D#002395#002399#00239C#0023A2#0023A3#0023AB#0023AC#0023AE#0023AF#0023B4#0023BE#0023C2#0023C6#0023D3#0023D4#0023D6#0023D7#0023DF#0023EA#0023EB#0023ED#0023EE#0023F1#0023F8#002400#002401#002403#002404#002413#002414#002436#002437#002438#002443#002450#002451#002454#00246C#002473#00247C#00247D#00247F#002481#002482#00248D#002490#002491#002492#002493#002495#002497#002498#0024A0#0024A1#0024A5#0024B5#0024BA#0024BE#0024C1#0024C3#0024C4#0024D6#0024D7#0024DC#0024E8#0024E9#0024EF#0024F7#0024F9#002500#00252E#002538#002545#002546#002547#002548#00254B#002564#002566#002567#002568#002583#002584#00259C#00259E#0025B3#0025B4#0025B5#0025BA#0025BC#0025BD#0025C3#0025C4#0025CF#0025D0#0025E7#0025F1#0025F2#002608#00260A#00260B#002636#002637#00263E#002641#002642#00264A#002651#002652#002654#002655#00265A#00265D#00265F#002668#002669#002688#002698#002699#0026B0#0026B9#0026BA#0026BB#0026C6#0026C7#0026CA#0026CB#0026CC#0026F3#003005#003019#00301E#003024#003040#003065#00306E#003071#003078#00307B#003080#003085#003094#003096#0030A3#0030B6#0030BD#0030C1#0030F2#004001#00400B#004027#004043#004096#005004#00500B#00500F#005014#00502A#00503E#005043#005050#005053#005054#005073#005080#00508B#005099#0050A2#0050A7#0050BA#0050BD#0050D1#0050DA#0050E2#0050E3#0050E4#0050F0#006008#006009#00602F#006038#00603E#006047#00605C#006070#006083#00608C#006097#0060B0#0060CF#008021#008039#00805F#00809F#0080A0#0080C8#009004#00900C#009021#009027#00902B#00905F#009069#00906D#00906F#009086#00908E#009092#00909C#0090A6#0090AB#0090B1#0090BF#0090CF#0090D9#0090F2#00A024#00A040#00A077#00A081#00A08E#00A0BF#00A0C5#00A0C6#00A0C9#00A0CA#00A0F8#00AA00#00AA01#00AA02#00B04A#00B064#00B08E#00B0C2#00B0D0#00C04F#00C0BE#00C0F9#00D006#00D058#00D063#00D079#00D088#00D090#00D095#00D096#00D097#00D0B7#00D0BA#00D0BB#00D0BC#00D0C0#00D0D3#00D0D8#00D0E4#00D0F6#00D0FF#00E000#00E003#00E00C#00E014#00E01E#00E02B#00E034#00E04F#00E052#00E064#00E06F#00E08F#00E0A3#00E0B0#00E0B1#00E0DA#00E0F7#00E0F9#00E0FC#00E0FE#02608C#02C08C#080007#080009#080028#080046#08004E";
    	String mac=getMacAddrWithFormat("-");
    	return mac;
    	
    }
    public static String getMacAddrWithFormat(String in_split) {
		String mac = getCompanyMacAddrPart() + getRandomMacAddrPart();

		String outMac = "";
		for (int i = 0; i < mac.length();) {
			outMac += mac.charAt(i++);
			
			if (0 == i % 2 && i < mac.length()) {
				outMac += in_split;
			}
		}

		return outMac;
	}

	private static String getCompanyMacAddrPart() {

		String[] compListArray = new String[MAX_COMPANY_LIST_LEN];

		compListArray = companyListString.split("#");

		int index = (int) Math.round(Math.random() * (compListArray.length - 1)
				+ 0);

		return compListArray[index];
	}

	private static String getRandomMacAddrPart() {
		String baseMacSeed = "0123456789ABCDEF";

		String wapsMacAddr = "";

		for (int i = 0; i < 3; i++) {
			wapsMacAddr += getRandomByteStr(baseMacSeed);
		}

		return wapsMacAddr;
	}

	private static String getRandomByteStr(String macSeed) {
		int h = (int) Math.round(Math.random() * 15 + 0);
		int l = (int) Math.round(Math.random() * 15 + 0);

		String byteStr = String.format("%c%c", macSeed.charAt(h),
				macSeed.charAt(l));

		return byteStr;
	}
	
	public static String getRandomChannel(){
		String channel = randomint(3,1)+"";
		return channel;
	}
	public static String getRandomServiceType(){
		String s = random(4,1)+"";
		return s;
	}
	public static String getRandomTerminalNumber(){
		String s = getFixLenthString(6);
		return s;
	}
	public static String getRandomAuthMode(){
		String s = randomint(3,1)+"";
		return s;
	}
	public static BankResult writeSql(Result[] re, Integer amount){
		try {
			FileWriter fileWriterSql = new FileWriter("D:\\ResultSql.csv", true);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int k = 0; k < amount; k++) {
				fileWriterSql.write(re[k].id + ',' + re[k].idFrom + ',' + re[k].idTo + ',' + re[k].money + ',' + re[k].city+ ',' + format.format(re[k].time) 
				+','+re[k].channel
				+','+re[k].serviceType
				+','+re[k].IP
				+','+re[k].state
				+','+re[k].authMode
				+','+re[k].terminalNumber
				+','+re[k].mac
				+','+re[k].tag);
				fileWriterSql.write("\r\n");
			}
			fileWriterSql.flush();
			fileWriterSql.close();
			return BankResult.ok();
		} catch (Exception er) {
			System.out.println(er.getMessage());
			return BankResult.build(0, "filewriter error");
		}		
		
	}
	public static void mysql(){
		Connection conn = null;   
        //数据库操作对象   
        Statement stmt = null;   
        //1、加载驱动程序   
        try {   
                Class.forName(DBDRIVER);   
        } catch (ClassNotFoundException e) {   
                e.printStackTrace();   
        }   
        //2、连接数据库   
        //通过连接管理器连接数据库   
        try {   
                //在连接的时候直接输入用户名和密码才可以连接   
                conn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);   
        } catch (SQLException e) {   
                e.printStackTrace();   
        }   
        //3、向数据库中插入一条数据   
      // String sql = "INSERT INTO person(name,age) VALUES ('Michael',20)";  
        String sql = "load data infile 'D:/ResultSql.csv' into table bank_simulate character set gbk fields terminated by ',' optionally enclosed by \"\" lines terminated by '\r\n';";
        try {   
                stmt = conn.createStatement();   
        } catch (SQLException e) {   
                e.printStackTrace();   
        }   
        //4、执行语句   
        try {   
                stmt.executeUpdate(sql);   
        } catch (SQLException e) {   
                e.printStackTrace();   
        }   
        //5、关闭操作，步骤相反哈~   
        try {   
                stmt.close();   
                conn.close();   
        } catch (SQLException e) {   
                e.printStackTrace();   
        }   

	}
	public static void deleteTemp(){
		File file = new File("D:\\ResultSql.csv");
		file.delete();
	}
	//    String citylist = "[{\"ProID\":1,\"name\":\"北京市\",\"ProSort\":1,\"ProRemark\":\"直辖市\"},"
//    		+"{\"ProID\":2,\"name\":\"天津市\",\"ProSort\":2,\"ProRemark\":\"直辖市\"},"
//    		+"{\"ProID\":3,\"name\":\"河北省\",\"ProSort\":5,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":4,\"name\":\"山西省\",\"ProSort\":6,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":5,\"name\":\"内蒙古自治区\",\"ProSort\":32,\"ProRemark\":\"自治区\"},"
//    		+"{\"ProID\":6,\"name\":\"辽宁省\",\"ProSort\":8,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":7,\"name\":\"吉林省\",\"ProSort\":9,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":8,\"name\":\"黑龙江省\",\"ProSort\":10,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":9,\"name\":\"上海市\",\"ProSort\":3,\"ProRemark\":\"直辖市\"},"
//    		+"{\"ProID\":10,\"name\":\"江苏省\",\"ProSort\":11,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":11,\"name\":\"浙江省\",\"ProSort\":12,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":12,\"name\":\"安徽省\",\"ProSort\":13,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":13,\"name\":\"福建省\",\"ProSort\":14,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":14,\"name\":\"江西省\",\"ProSort\":15,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":15,\"name\":\"山东省\",\"ProSort\":16,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":16,\"name\":\"河南省\",\"ProSort\":17,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":17,\"name\":\"湖北省\",\"ProSort\":18,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":18,\"name\":\"湖南省\",\"ProSort\":19,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":19,\"name\":\"广东省\",\"ProSort\":20,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":20,\"name\":\"海南省\",\"ProSort\":24,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":21,\"name\":\"广西壮族自治区\",\"ProSort\":28,\"ProRemark\":\"自治区\"},"
//    		+"{\"ProID\":22,\"name\":\"甘肃省\",\"ProSort\":21,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":23,\"name\":\"陕西省\",\"ProSort\":27,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":24,\"name\":\"新疆维吾尔自治区\",\"ProSort\":31,\"ProRemark\":\"自治区\"},"
//    		+"{\"ProID\":25,\"name\":\"青海省\",\"ProSort\":26,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":26,\"name\":\"宁夏回族自治区\",\"ProSort\":30,\"ProRemark\":\"自治区\"},"
//    		+"{\"ProID\":27,\"name\":\"重庆市\",\"ProSort\":4,\"ProRemark\":\"直辖市\"},"
//    		+"{\"ProID\":28,\"name\":\"四川省\",\"ProSort\":22,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":29,\"name\":\"贵州省\",\"ProSort\":23,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":30,\"name\":\"云南省\",\"ProSort\":25,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":31,\"name\":\"西藏自治区\",\"ProSort\":29,\"ProRemark\":\"自治区\"},"
//    		+"{\"ProID\":32,\"name\":\"台湾省\",\"ProSort\":7,\"ProRemark\":\"省份\"},"
//    		+"{\"ProID\":33,\"name\":\"澳门特别行政区\",\"ProSort\":33,\"ProRemark\":\"特别行政区\"},"
//    		+"{\"ProID\":34,\"name\":\"香港特别行政区\",\"ProSort\":34,\"ProRemark\":\"特别行政区\"}]";
    
   // List<Province> cities = JsonUtils.jsonToList(citylist, Province.class);
	//int k = cities.size();
	//Province pro = new Province();
  //  JSONObject a = new JSONObject(citylist);  
   // JSONArray jsonarray = new JSONArray();
  //  jsonarray = JSONArray.fromObject(citylist);  
  //  System.out.println("jsonArray:"+jsonarray);
	
    
	 
}




























