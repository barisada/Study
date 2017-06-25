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

