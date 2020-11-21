### 作业

#### Spring Bean的配置
`scr/main/java/my/homework/bean`
- XML方式
- Annotation方式

#### 自定义starter
school模块下为自动配置的starter
包含对School等对象的创建和属性注入


#### JDBC 
`scr/main/java/my/homework/jdbc`中
- 通过工厂类从Hikari连接池中获取连接
- 使用`connection.setAutoCommit(false)`改为手动提交事务
- 批处理使用JDBC原生的`addBatch()`和`executeBatch()`方法