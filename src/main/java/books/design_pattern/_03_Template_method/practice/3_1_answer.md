### 1. java.io.InputStream
 - this class uses 'Template Method Pattern'
 - To use this class subclass must implement
    - read() method

### 2. For 'public final void display()', what does final mean?
 - Final means that this method cannot be overridden by subclass.
 - GoF recommended not override 'Template Method'
 
### 3. Java8 and Template Method Pattern
 - since java8 introduced 'default' method 'Template Method' can be used not only abstract class but also Interface