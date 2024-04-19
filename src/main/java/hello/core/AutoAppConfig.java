package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /*
            basePackages : 탐색할 패키지의 시작 위치를 지정하는 속성, 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
            basePackageClasses : 지정한 클래스의 패키지를 탐색 시작 위로 지정한다.
            basePackages, basePackageClasses 를 지정하지 않을 때 : 상단의 package를 기준으로 하위 내 모든 @Component를 찾는다.

            권장하는 방법 : 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는것이다.

         */

        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class  )
)
public class AutoAppConfig
{

}
