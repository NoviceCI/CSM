package xzf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xzf.dao.CarDao;
import xzf.dao.CustomerDao;
import xzf.dto.DashInfo;
import xzf.dto.PieChart;

@Transactional
@Service
public class DashServiceImpl implements DashService {

	@Autowired
	CarDao carDao;
	
	@Autowired
	CustomerDao customerDao;
	
	PieChart chartData ;
	
	private static String[] colorCodePieChart = {"#00c0ef","#3c8dbc","#d2d6de","#f56954","#00a65a","#f39c12","#3c8dbc"};
	//private static String[] colorCodePieChartH = {"#f56954","#00a65a","#f39c12","#3c8dbc"};
	
	@Override
	public DashInfo getDashInfo() {
		
		Random random = new Random();
		
		List<String> allTypeCar = carDao.getCarTypeCode();
		
		DashInfo dashInfo = new DashInfo();
		
		dashInfo.setTotalCar(carDao.countAll());
		dashInfo.setTotalCustomer(customerDao.countAll());
		
		List<PieChart> pieChartListData = new ArrayList<PieChart>();
		
		allTypeCar.forEach(typeCode-> {
			
			int color = random.nextInt(6);
			chartData = new PieChart();
			chartData.setValue(carDao.countBytype(typeCode));
			chartData.setColor(colorCodePieChart[color]);
			chartData.setHighlight(colorCodePieChart[color]);
			chartData.setLabel(typeCode);
			pieChartListData.add(chartData);
			
		});
		
		
		dashInfo.setPieCharts(pieChartListData);
		
		return dashInfo;
	}

}
