### 分库分表增删改查
`my.homework.jdbc`
- 使用ShardingSphere的Spring配置自动创建16个分表
- 表结构如下
```$sql
create table goods (
    id bigint primary key,
    goods_name varchar,
    no varchar,
    stock int,
    price int,
    introduce varchar
);
```

### 分布式事务
`my.homework.xa`
- 使用ShardingSphere的XA事务实现
- 从创建的dataSource中直接获取数据库连接的JDBC实现demo