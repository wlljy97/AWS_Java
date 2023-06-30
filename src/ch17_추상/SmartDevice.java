package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public abstract class SmartDevice { // abstract : class 앞에 붙힌다. 추상클래스  설계
	private String deviceName;
	private double displaySize;
	
	public abstract void connectedWifi(); //이것을 호출할려면 구체화가 되어야한다.
	
}
