package books.effective_java.ch10.item71;

/**
 * Created on 2018. 4. 22..
 */
public class LazyInitializationExample {
	private Object lazyInitField;
	private volatile Object doubleCheckIdiomField;

	public synchronized Object getLazyInitField(){
		if(lazyInitField == null){
			lazyInitField = computeFieldValue();
		}

		return lazyInitField;
	}

	private Object computeFieldValue() {
		return new Object();
	}

	public Object getDoubleCheckIdiomField(){
		Object result = doubleCheckIdiomField;
		if(result == null){     //check without lock
			synchronized (this){
				result = doubleCheckIdiomField;
				if(result == null){     //check with lock
					doubleCheckIdiomField = result = computeFieldValue();
				}
			}
		}

		return result;
	}

	private static Object staticComputeFieldValue(){
		return new Object();
	}

	public static Object getStaticLazyInitField(){
		return FieldHolder.field;
	}

	//lazy initialization holder class idiom
	private static class FieldHolder{
		static final Object field = staticComputeFieldValue();
	}

}
