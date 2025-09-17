package com.bfs;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestBase {

	// Custom annotation definition
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface RunWithInputs {
		String inputs();
	}

	// Method to process the annotation and execute the method with specified inputs
	public void runTestWithInputs(Object testInstance) throws NoSuchMethodException {
		Class<?> clazz = testInstance.getClass();

		// Get the method with @RunWithInputs annotation
		java.lang.reflect.Method[] methods = clazz.getDeclaredMethods();
		for (java.lang.reflect.Method method : methods) {
			if (method.isAnnotationPresent(RunWithInputs.class)) {
				RunWithInputs annotation = method.getAnnotation(RunWithInputs.class);
				String inputs = annotation.inputs();

				try {
					int result = (int) method.invoke(testInstance, new Object[] { inputs });
					System.out.println("Result: " + result);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws NoSuchMethodException {
		RottenOranges rottenOranges = new RottenOranges();
		TestBase testBase = new TestBase();
		testBase.runTestWithInputs(rottenOranges);
	}
}