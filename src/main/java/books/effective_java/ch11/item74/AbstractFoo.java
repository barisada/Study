package books.effective_java.ch11.item74;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created on 2018. 4. 29..
 */
public abstract class AbstractFoo {
	private int x,y;

	private enum State{ NEW, INITIALIZING, INITIALIZED}
	private final AtomicReference<State> init =
			new AtomicReference<>(State.NEW);

	public AbstractFoo(int x, int y){
		initialize(x, y);
	}

	// This constructor and the following method allow
	// subclass's readObject method to initialize our state.
	protected AbstractFoo(){}
	protected final void initialize(int x, int y){
		if(!init.compareAndSet(State.NEW, State.INITIALIZING))
			throw new IllegalStateException(("Already initialized"));

		this.x = x;
		this.y = y;
		init.set(State.INITIALIZED);
	}

	protected final int getX(){
		checkInit();
		return x;
	}

	protected final int getY(){
		checkInit();
		return y;
	}

	protected final State getState(){
		checkInit();
		return init.get();
	}

	private void checkInit() {
		if(init.get() != State.INITIALIZED)
			throw new IllegalStateException("Uninitialized");
	}
}
