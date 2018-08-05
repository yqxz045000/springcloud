

 *	与eureka Server 进行相互注册，构建高可用Eureka server
 * 原理：EurekaServer 多实例相互注册，实例会彼此增量的同步注册信息，从而确保所有节点数据一致