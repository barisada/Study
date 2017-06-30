# DI 인젝션 스터디

>스프링의 DI 기능은 BeanFactory와 이것의 하위 인터페이스를 구현한 것


### BeanFactory
  
* 스프링 코어 인터페이스
* 어플리케이션 컴포넌트의 중앙 등록(central registry), 중앙 구성(centralizes configuration) 역할을 담당. 
	* See chapters 4 and 11 of "Expert One-on-One J2EE Design and Development" for a discussion of the benefits of this approach.
* 어플리케이션의 객체를 구성할때는 일반적으로 setter와 constructor를 통한 Dependency Injection ("push configuration")를 사용하는 것이 BeanFactory lookup 같은 "pull" 구성 방식보다 좋다. **스프링의 DI 기능은 BeanFactory와 이것의 하위 인터페이스를 구현한 것**이다.
* 보통 BeanFactory는 XML등으로 bean을 정의한 구성요소를 로드하고 __org.springframework.beans__ 패키기를 사용하여 bean을 구성한다. 그러나 구현은 Java 코드에서 직접 작성한 Java 객체를 필요에 따라 간단히 반환 할 수 있다. LDAP, RDBMS, XML, 특성 파일 등 정의가 저장 될 수있는 방법에 제약이 없다. 구현은 빈 사이의 참조 (Dependency Injection)를 지원하도록 권장된다.
* ListableBeanFactory와 대조적으로 BeanFactory의 모든 오퍼레이션은 HierarchicalBeanFactory인 경우 부모 팩토리 또한 체크한다. 만약 bean이 현재 팩토리 인스턴스에서 발견되지 않으면 즉시 부모 팩토리에서 체크한다. 이 팩토리 인스탄스의 Beans들은 부모 팩토리에 있는 같은 이름의 beans들을 오버라이드 하도록 되어있다.

Bean factory 구현은 가능한 표준 bean 라이프사이클을 지원해야한다. 전체 초기화 메소드들과 표준 순서는 아래와 같다.

1. BeanNameAware's setBeanName
2. BeanClassLoaderAware's setBeanClassLoader
3. BeanFactoryAware's setBeanFactory
4. EnvironmentAware's setEnvironment
5. EmbeddedValueResolverAware's setEmbeddedValueResolver
6. ResourceLoaderAware's setResourceLoader (only applicable when running in an application context)
7. ApplicationEventPublisherAware's setApplicationEventPublisher (only applicable when running in an application context)
8. MessageSourceAware's setMessageSource (only applicable when running in an application context)
9. ApplicationContextAware's setApplicationContext (only applicable when running in an application context)
10. ServletContextAware's setServletContext (only applicable when running in a web application context)
11. postProcessBeforeInitialization methods of BeanPostProcessors
12. InitializingBean's afterPropertiesSet
13. a custom init-method definition
14. postProcessAfterInitialization methods of BeanPostProcessors

아래 라이프사이클 메소드는 Bean factory 종료시 적용된다.

1. postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors
2. DisposableBean's destroy
3. a custom destroy-method definition



#GM님 파트

### OOP 프로그래밍 SOLID 5원칙

1. S : 객체에게 하나의 책임을 지게하는일. -> 객체가 변하는 이유는 단 하나여야한다.  -> 변화시 최소한의 영향을 주게 됨.
2. O : 확장에는 열려있고, 변화에는 닫혀있긔. -> 확장은 가능하면서도 확장 코드를 수정이 없어야한다. -> 추상화를 통해서 해결.
3. L : 부모 객체의 메소드는 자식 객체 메소드에서도 정상동작해야함. -> 계약한대로 동장하지 않으면 확장 할 수 없다.
4. I : 인터페이스는 그 인터페이스를 사용하는 클라이언트 기준으로 분리해야한다.
5. D : 고수준 정책이 저수준 구현에 의존하면 안된다.

#####해설
- S를 뒷받치하는게 I
- O를 뒷받침하는게 L(추상화), D(다형성)
 
 -> 스프링의 DI를 쓴다는건 SOLID한 원칙을 지키는 것을 누릴 수 있게 해준다.
 
#####기타
- dbms tranaction은 acid 원칙을따른다.
	- 그중 Isolation 3가지 문제를 방지하기 위해서고, anci에서는 4가지 방법으로 해결 방법을 제공.
	- 오라클은 read_commit, repeat_commit, serialize commit지원
	- mysql, mssql은 처음 2개만 지원
- concurrenthashmap은 16개의 hashset을 lock 걸어서 단일 1개 lock 보다 빠름.
 
  