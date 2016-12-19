package test;

import java.math.BigDecimal;


public class Location {
	/**
	 * 计算两点之间距离
	 * @param _lat1 - start纬度
	 * @param _lon1 - start经度
	 * @param _lat2 - end纬度
	 * @param _lon2 - end经度
	 * @return km(四舍五入)
	 */
	public static double getDistance(double _lat1,double _lon1, double _lat2,double _lon2){
		double lat1 = (Math.PI/180)*_lat1;
		double lat2 = (Math.PI/180)*_lat2;
		
		double lon1 = (Math.PI/180)*_lon1;
		double lon2 = (Math.PI/180)*_lon2;
		
		//地球半径
		double R = 6378.1*1000;
		
		double d =  Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1))*R;
		
		return new BigDecimal(d).setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static void main(String[] args) {
		//GeoPoint point1 = new GeoPoint((int)(113.372814*1e6),(int)(23.134256*1e6));//天河公园
		//GeoPoint point2 = new GeoPoint((int)(113.413402*1e6),(int)(23.137679*1e6));//黄村地铁
		//广州南站22.99546 ,113.276779
		//车陂 113.401879,23.130747
		//东圃镇 113.4099,23.128875
		//东圃天银大厦 113.410688,23.128253
		System.out.println(getDistance(23.128253, 113.410688, 23.128875 ,113.4099));
	}


}
