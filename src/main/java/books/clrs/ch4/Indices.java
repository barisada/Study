package books.clrs.ch4;

import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 8. 6..
 */
public class Indices {
	int start;
	int end;

	public Indices(int s, int e){
		this.start = s;
		this.end = e;
	}

	public int sum(int[] array){
		return IntStream.rangeClosed(start, end).map(i -> array[i]).sum();
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public Indices add(Indices other){
		int s = this.start <= other.start ? this.start : other.start;
		int e = this.end >= other.end ? this.end : other.end;
		return new Indices(s, e);
	}

	@Override public String toString() {
		return "Indices{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}