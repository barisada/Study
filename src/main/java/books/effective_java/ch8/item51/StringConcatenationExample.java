package books.effective_java.ch8.item51;

import org.springframework.util.StopWatch;

import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created on 2018. 4. 1..
 */
public class StringConcatenationExample {

	public String badConcat(){
		String result = "";
		for(int i = 0; i < 20000; i++){
			result += i;
		}
		return result;
	}

	public String goodConcat(){
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < 20000; i++){
			sb.append(i + "");
		}
		return  sb.toString();
	}

}
