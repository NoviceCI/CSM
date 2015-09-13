package xzf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import xzf.dao.CarDao;
import xzf.domain.Car;
import xzf.domain.Images;
import xzf.dto.CarInfo;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao ;
	

	@Override
	public CarInfo getCarDetail(int id) {
		Car car = carDao.getCarDetail(id);
		CarInfo carInfo = new CarInfo(car,car.getCustomer());
		List<String> strings = new ArrayList<>();
		car.getImageses().forEach(img->{
			strings.add("data:image/png;base64,"+Base64Coder.encodeLines(img.getData()));
		});
		carInfo.setImages(strings);
		return carInfo;
	}

	@Override
	public Integer countAll() {
		return carDao.countAll();	}

	@Override
	public int countByKeyword(String keyword) {
		return carDao.countByKeyword(keyword);
	}

	@Override
	public List<Car> findByKeyword(String keyword, int offset, int limit) {
		return carDao.findByKeyword(keyword, offset, limit);
	}

}
