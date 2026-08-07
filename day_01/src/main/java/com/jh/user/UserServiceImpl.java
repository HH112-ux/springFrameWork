package com.jh.user;

public class UserServiceImpl implements UserService{
    @Override
    public void save() {
        //UserDao dao=(UserDao) XmlBeanFactory.getBean("D:\\idea_workspace\\springFramework\\day_01\\src\\main\\resources\\bean.xml","userDao1");
        UserDao userDao = (UserDao)
                BeanFactory.getBean("userDao");//new UserDaoMybatisImpl();//UserDaoJdbcImpl();
        userDao.save();
    }
}
