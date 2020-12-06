### 批量插入测试
`my.homeework.insert`
- 测试环境：100万数据，带主键索引
- 使用批处理添加商品数据完成，完成时间4~5min
- 使用单条SQL执行，执行很慢，半小时未完成

### 动态数据源
`my.homework.GoodsService`
- 不同的数据源使用不同JdbcTemplate来实现数据源切换

### 使用ShardingSphere 读写分离
`my.homework.GoodsShardingService`
- 使用Springboot+ShardingSphere配置实现读写分离

