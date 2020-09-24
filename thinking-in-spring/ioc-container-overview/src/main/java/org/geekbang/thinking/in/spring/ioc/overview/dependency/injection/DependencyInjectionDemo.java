package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.annotition.Super;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖查找示例
 * @author liujunqi
 *
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置xml配置文件
        // 启动spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        // 依赖来源一：自定义 Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository);
//        System.out.println(userRepository.getUsers().size());

        // 依赖来源二： 依赖注入 （内建依赖）
        System.out.println(userRepository.getBeanFactory());
//        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory userFactory = userRepository.getObjectFactory();

        System.out.println(userFactory.getObject() == beanFactory);

        // 依赖查找
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源三：容器内建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }
}
