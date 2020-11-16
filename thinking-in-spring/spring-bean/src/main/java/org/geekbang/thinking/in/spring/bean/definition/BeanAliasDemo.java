package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 别名示例
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        // 配置xml配置文件
        // 启动spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        // 通过别名"xiaomage-user"获取bean
        User xiaomageUser = beanFactory.getBean("xiaomage-user", User.class);
        User user = beanFactory.getBean("user", User.class);

        System.out.println("xiaomageUser 是否与 user bean相同: " + (xiaomageUser == user));

        xiaomageUser.setName("aaa");
        System.out.println(user.getName());
    }
}
