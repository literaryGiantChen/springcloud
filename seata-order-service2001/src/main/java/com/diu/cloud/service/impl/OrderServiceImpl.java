package com.diu.cloud.service.impl;

import com.diu.cloud.dao.OrderDao;
import com.diu.cloud.domain.Order;
import com.diu.cloud.service.AccountService;
import com.diu.cloud.service.OrderService;
import com.diu.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author DIU
 * @date 2021/10/14 17:15
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    public AccountService accountService;

    @Resource
    public StorageService storageService;

//    @Autowired
//    public OrderServiceImpl(AccountService accountService, StorageService storageService) {
//        this.accountService = accountService;
//        this.storageService = storageService;
//    }

    @Override
    @GlobalTransactional(name = "nacos_service_tx_group", rollbackFor = Exception.class)
    public int createOrder(Order order) {
        // 创建订单
        orderDao.createOrder(order);

        // 调用远程库存服务 扣减库存
        storageService.decrease(order.getProductId(), order.getCount());

        // 调用远程用户服务 扣减余额
        accountService.decrease(order.getUserId(), order.getMoney());

        // 修改订单状态码 完成本次订单服务
        orderDao.updateStatus(order.getId(), 1);
        return 1;
    }
}
