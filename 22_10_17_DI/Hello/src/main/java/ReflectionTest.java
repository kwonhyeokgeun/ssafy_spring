import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException {
		//내가 직접 MyReflection 클래스를 사용할 경우
//		MyReflection mr = new MyReflection();
//		mr.aboutMe();
		
		
		//Spring이 MyReflection 클래스를 사용할 경우
		String className="MyReflection";
		Class<?> myClass = Class.forName(className);
			
		//Reflection API
		MyReflection mf = (MyReflection) myClass.getDeclaredConstructor().newInstance();
		mf.aboutMe(); //MyReflection 클래스의 aboutMe메소드 실행
		
		
		
		//MyConfig.properties 파일에서 클래스명 읽어서 쓰기
//		InputStream is = new FileInputStream("MyConfig.properties");
//		Properties prop = new Properties();
//		prop.load(is);
//		
//		String className="MyReflection";
//		Class<?> myClass = Class.forName(className);
//		MyReflection mf = (MyReflection) myClass.getDeclaredConstructor().newInstance();
//		mf.aboutMe();
		
		
		className="MyReflection";
		myClass = Class.forName(className);
		Method m =myClass.getMethod("robot", int.class); //robot이라는 매소드, 인자가 int인
		String str = (String)m.invoke(mf, 80);  //robot 매소드에 인자에 80을 넣고 리턴값을 받아옴
		System.out.println(str);
	}

}
