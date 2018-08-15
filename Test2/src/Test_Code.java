import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test_Code {
ArrayList<Double> axis=new ArrayList<Double>();
ArrayList<Double> sun=new ArrayList<Double>();
ArrayList<Double> reliance=new ArrayList<Double>();
ArrayList<Double> bajaj=new ArrayList<Double>();
ArrayList<Double> titan=new ArrayList<Double>();
	Scanner sc=new Scanner(System.in);
	int count_time=0;
	int count_ema=0;
	double sum=0;
	void check_time()
	{	
		int i=1000;//have to delete this line to run program according computer time
		if(i>920)
		{
          count_time++;
          System.out.println("time accurate");
		}
		else
		{
			count_time=0;
			System.out.println("time problem");
			proceed();
		}
	}
	void check_ema()
	{
		if(ent_price>vwap)
		{
			count_ema++;
			System.out.println("price is ok");
		}
		else
		{
			count_ema=0;
			all_trade();
			System.out.println("price is less than vwap");
			proceed();
		}
	}
	void check_half()
	{
		if(i>1350 && count_ema==0)
		{
		System.out.println("You can exit for the day");	
		all_trade();
		System.exit(0);
		}
	}
	double exit_price;
	void exit()
	{
		if(i>1500 && i<1600)
		{
			enter_exit_price();
			exit_price();
		}
	}
	void enter_exit_price()
	{
		System.out.println("enter exit price");
		exit_price=sc.nextDouble();
		exit_price=close;
	}
     void exit_price()
     { 
    	 if(exit_price>vwap)
    	 {
    		 System.out.println("you can exit");
    		 ema_cal();
    		 vwap();
    		 System.out.println("close value of the day is  "+close);
    		 System.exit(0);
    	 }
    	 else
    	 {
    		 System.out.println("to exit for the day you have to enter value more than vwap value");
    	 }
     }
	 // check method
    void check()
    {
     check_time();
     check_half();
     System.out.println("trade started");
     ema();
     check_ema();
     vwap();
     proceed();
    }
    void proceed()
    {
    	System.out.println("Press 1. next entry 2. exit 3. Select Company");
    	int pro=sc.nextInt();
    	switch(pro)
    	{
    	case 1:
    	{
    		check();
    		break;
    	}
    	case 2:
    	{
    		enter_exit_price();
    		exit_price();
    		all_trade();
    		System.exit(0);
    		break;
    	}
    	case 3:
    	{
    		select_company();
    	break;
    	}
    	default:
    	System.out.println("Enter correct entry");
    	break;
    	}
    }
	void ema()
	{
		System.out.println("ema calculation method");
		calculate();
	}
	void ema_cal()
	{
		new_ema=alpha*close+(1-alpha)*ema50;
		System.out.println("New ema is  "+new_ema);
	}
	// ema method
	double ent_price;
	void enter()
	{	
		 System.out.println("Enter the entry price");
		 ent_price=sc.nextLong();	
		 System.out.println("Enter the volume");
	     vol=sc.nextLong();
	     close=ent_price;
	}
	//ema calculation
	double alpha=0.3f;
    double ema50=530.30;
    double new_ema;
	void calculate()
	{
		 enter();
		 check_ema();
		 long close=530;
		 new_ema=alpha*close+(1-alpha)*ema50;
		 System.out.println("New ema is  "+new_ema);
	}
	
	void vwap()
	{
		
		System.out.println("vwap calculation method");
		display_vwap();
	}
	// vwap methods
	double close;
	double vol;
	double candv;
	double newvol;
	double cum_candv;
	double com_vo=149430;
	double vwap;
    void base_calculation()
    {
    	cum_candv=79242729;
    	candv=close*vol;//calculating multiply of enetred close and volume
    	candv=candv+cum_candv;//new close and volume cumlative
    	newvol=com_vo+vol;//adding volume in old comulative
    	cum_candv=candv;
    }
    void advance_cal()
    {
    	vwap=candv/newvol;
    }
    void display_vwap()
    {
    	System.out.println("Ema is                         "+new_ema);
    	System.out.println("cumulative close and volume    "+cum_candv);
    	System.out.println("cumulative volume              "+com_vo);
    	System.out.println("Entered volume                 "+vol);
    	System.out.println("Entered close                  "+close);
    	base_calculation();
    	System.out.println("new cumulative close * volume  "+candv);
    	System.out.println("close and value + cum candv    "+candv);
    	System.out.println("cumulative volume              "+newvol);
    	advance_cal();
    	System.out.println("vwap value is                  "+vwap);
    	System.out.println("new cum_candv                  "+cum_candv);
    	
    }
	double rsum=0,tsum=0,bsum=0,ssum=0,asum=0;
    double rvwap,avwap,tvwap,bvwap,svwap;
    void axis_cal()
    {
    	avwap=candv/newvol;
    }
    void axis_trade()
    {   
    	axis_cal();
    	axis.add(avwap);
    	System.out.println("trade of axis "+axis);
    	for(Double ax:axis)
    	{
    	System.out.println("All vwap is   "+ax);
    	}
    	for(int i=0;i<axis.size();i++)
    	{
    		asum=asum+axis.get(i);
    	}
    	System.out.println("total trade "+asum);
    }
    void sun_cal()
    {
    	svwap=candv/newvol;
    }
    void sun_trade()
    {   
    	sun_cal();
    	sun.add(svwap);
    	System.out.println("trade of sun "+sun);
    	for(Double su:sun)
    	{
    	System.out.println("All vwap is   "+su);
    	}
    	for(int i=0;i<axis.size();i++)
    	{
    		ssum=ssum+axis.get(i);
    	}
    	System.out.println("total trade "+ssum);
    }
    void reliance_cal()
    {
    	rvwap=candv/newvol;
    }
    void reliance_trade()
    {   
    	reliance_cal();
    	reliance.add(rvwap);
    	System.out.println("trade of reliance"+reliance);
    	for(Double re:reliance)
    	{
    	System.out.println("All vwap is   "+re);
    	}
    	for(int i=0;i<axis.size();i++)
    	{
    		rsum=rsum+axis.get(i);
    	}
    	System.out.println("total trade "+rsum);
    }
    void bajaj_cal()
    {
    	bvwap=candv/newvol;
    }
    void bajaj_trade()
    {   
    	bajaj_cal();
    	bajaj.add(bvwap);
    	System.out.println("trade of bajaj"+bajaj);
    	for(Double baj:bajaj)
    	{
    	System.out.println("All vwap is   "+baj);
    	}
    	for(int i=0;i<axis.size();i++)
    	{
    		bsum=bsum+axis.get(i);
    	}
    	System.out.println("total trade "+bsum);
    }
    void titan_cal()
    {
    	tvwap=candv/newvol;
    }
    void titan_trade()
    {
    	titan_cal();
    	titan.add(tvwap);
    	System.out.println("trade of titan"+titan);
    	for(Double tit:titan)
    	{
    	System.out.println("All vwap is   "+tit);
    	}
    	for(int i=0;i<axis.size();i++)
    	{
    		tsum=tsum+axis.get(i);
    	}
    	System.out.println("total trade "+tsum);
    }
    void all_trade()
    {
    	System.out.println("All Trade values");
    	titan_trade();
    	reliance_trade();
    	bajaj_trade();
    	axis_trade();
    	sun_trade();
    }
   
	//time and date method
	static void Time()
	{
	DateFormat df=new SimpleDateFormat("dd//MM//yy");
	DateFormat tf=new SimpleDateFormat("hh:mm");
	Date date=new Date();
	System.out.println("Date is    "+df.format(date));
	System.out.println("Time is    "+tf.format(date));
	}
	//integer time method
    static long i;
	static long int_time()
	{
		Test_Code.Time();
		DateFormat simpletf=new SimpleDateFormat("hhmm");
		Date date=new Date();
		String s=simpletf.format(date);
		i=Long.parseLong(s);
		return i;
	}
	void select_company()
	{
	    System.out.println("Select company to start trade");
	    System.out.println("1.Reliance 2.Axis 3.Sun Pharma 4.Titan 5.Bajaj Finance");
	    int com=sc.nextInt();
	    switch(com)
	    {
	    case 1:
	    {
	    	check();
	    	ema();
	    	vwap();
	    	check();
	    	proceed();
	    	reliance_trade();
	    break;
	    }
	    case 2:
	    {
	    	check();
	    	ema();
	    	vwap();
	    	check();
	    	proceed();
	    	axis_trade();
	    break;
	    }
	    case 3:
	    {
	    	check();
	    	ema();
	    	vwap();
	    	check();
	    	proceed();
	    	sun_trade();
	    break;
	    }
	    case 4:
	    {
	    	check();
	    	ema();
	    	vwap();
	    	check();
	    	proceed();
	    	titan_trade();
	    break;
	    }
	    case 5:
	    {
	    	check();
	    	ema();
	    	vwap();
	    	check();
	    	proceed();
	    	bajaj_trade();
	    break;
	    }
	    default:
	    	System.out.println("Enter correct number");
	    break;
	    }
	 }

	public static void main(String[] args) {
	Test_Code.thanx();
	Test_Code tc=new Test_Code();
    Test_Code.int_time();
    while(true)
    {
    tc.select_company();
	System.out.println("All Trade Status");
	tc.all_trade();
    }
	}
	static void thanx()
	{
		System.out.println("This code explore the basic idea of the stock indicator");
		
	}
}
