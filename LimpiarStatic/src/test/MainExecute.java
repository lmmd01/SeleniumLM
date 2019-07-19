package test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MainExecute {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		MyClassWithStatic test = new MyClassWithStatic();

		test.setVariablesData();

		Field[] fields = MyClassWithStatic.class.getDeclaredFields();

		for (Field field : fields) {
			if (Modifier.isStatic(field.getModifiers())) {
				String strValue = (String)field.get(test);
				System.out.println("\nEl valor antes es: " + strValue);
				System.out.println(field);
				
				field.set(null, "");
				String strValue2 = (String)field.get(test);
				System.out.println("El valor despues es: " + strValue2);
				
			}
		}
	}

}
