package test;

import java.lang.reflect.GenericArrayType;

public class Domain {
	volatile int temp;
String name;
public int getTemp() {
	return temp;
}

public void setTemp(int temp) {
	this.temp = temp;
}

public Domain() {
	super();
	// TODO Auto-generated constructor stub
}

public Domain(int temp) {
	super();
	this.temp = temp;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
@Override
public boolean equals(Object obj) {
	if(null==obj||obj.getClass()!=this.getClass())
		return false;
	Domain temp=(Domain)obj;
	if(temp.getName()==name&&temp.getTemp()==getTemp()){
		return true;
	}
	return false;
}
@Override
public String toString() {
	return "Domain [temp=" + temp + ", name=" + name + "]";
}


}
