package com.diu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.diu.cloud.myhandler.CustomerBlockHandler;
import com.diu.cloud.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author DIU
 * @date 2021/10/12 17:28
 * 单机阈值是现在请求的次数
 * 统计窗口时长:统计页面停留时长
 */
@RestController
@Slf4j
public class FlowLimitController {

    /**
     * QPS流量控制 https://github.com/alibaba/Sentinel/wiki/%E6%B5%81%E9%87%8F%E6%8E%A7%E5%88%B6
     * <p>
     * --- 直接拒绝
     * 直接拒绝（RuleConstant.CONTROL_BEHAVIOR_DEFAULT）方式是默认的流量控制方式，当QPS超过任意规则的阈值后，新的请求就会被立即拒绝，拒绝方式为抛出FlowException。
     * 这种方式适用于对系统处理能力确切已知的情况下，比如通过压测确定了系统的准确水位时。具体的例子参见 https://github.com/alibaba/Sentinel/blob/master/sentinel-demo/sentinel-demo-basic/src/main/java/com/alibaba/csp/sentinel/demo/flow/FlowQpsDemo.java。
     * <p>
     * --- Warm Up
     * Warm Up（RuleConstant.CONTROL_BEHAVIOR_WARM_UP）方式，即预热/冷启动方式。当系统长期处于低水位的情况下，当流量突然增加时，直接把系统拉升到高水位可能瞬间把系统压垮。
     * 通过"冷启动"，让通过的流量缓慢增加，在一定时间内逐渐增加到阈值上限，给冷系统一个预热的时间，避免冷系统被压垮。
     * 详细文档可以参考 流量控制 - Warm Up 文档 https://github.com/alibaba/Sentinel/wiki/%E9%99%90%E6%B5%81---%E5%86%B7%E5%90%AF%E5%8A%A8
     * 具体的例子可以参见 WarmUpFlowDemo https://github.com/alibaba/Sentinel/blob/master/sentinel-demo/sentinel-demo-basic/src/main/java/com/alibaba/csp/sentinel/demo/flow/WarmUpFlowDemo.java
     * <p>
     * -- 匀速排队
     * 匀速排队（RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER）方式会严格控制请求通过的间隔时间，也即是让请求以均匀的速度通过，对应的是漏桶算法。
     * 详细文档可以参考 流量控制 - 匀速器模式，https://github.com/alibaba/Sentinel/wiki/%E6%B5%81%E9%87%8F%E6%8E%A7%E5%88%B6-%E5%8C%80%E9%80%9F%E6%8E%92%E9%98%9F%E6%A8%A1%E5%BC%8F
     * 具体的例子可以参见 PaceFlowDemo。https://github.com/alibaba/Sentinel/blob/master/sentinel-demo/sentinel-demo-basic/src/main/java/com/alibaba/csp/sentinel/demo/flow/PaceFlowDemo.java
     *
     * @return
     */
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    /**
     * @return
     */
    @GetMapping("/testB")
    public String testB() {
        log.info("{} 执行了：------testB", Thread.currentThread().getName());
        return "------testB";
    }

    /**
     * 熔断 https://github.com/alibaba/Sentinel/wiki/%E7%86%94%E6%96%AD%E9%99%8D%E7%BA%A7
     * <p>
     * 慢调用比例 (SLOW_REQUEST_RATIO)：选择以慢调用比例作为阈值，需要设置允许的慢调用 RT（即最大的响应时间），请求的响应时间大于该值则统计为慢调用。
     * 当单位统计时长（statIntervalMs）内请求数目大于设置的最小请求数目，并且慢调用的比例大于阈值，则接下来的熔断时长内请求会自动被熔断。
     * 经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态），若接下来的一个请求响应时间小于设置的慢调用 RT 则结束熔断，若大于设置的慢调用 RT 则会再次被熔断。
     * <p>
     * 异常比例 (ERROR_RATIO)：当单位统计时长（statIntervalMs）内请求数目大于设置的最小请求数目，并且异常的比例大于阈值，则接下来的熔断时长内请求会自动被熔断。
     * 经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态），若接下来的一个请求成功完成（没有错误）则结束熔断，否则会再次被熔断。
     * 异常比率的阈值范围是 [0.0, 1.0]，代表 0% - 100%
     * <p>
     * 异常数 (ERROR_COUNT)：当单位统计时长内的异常数目超过阈值之后会自动进行熔断。
     * 经过熔断时长后熔断器会进入探测恢复状态（HALF-OPEN 状态），若接下来的一个请求成功完成（没有错误）则结束熔断，否则会再次被熔断。
     *
     * @return
     */
    @GetMapping("/testC")
    public String testC() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{} 执行了：------testC", Thread.currentThread().getName());
        return "------testC";
    }


    @GetMapping("/testD")
    public String testD() {
        int i = 1 / 0;
        log.info("{} 执行了：------testD", Thread.currentThread().getName());
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        int i = 1 / 0;
        log.info("{} 执行了：------testE", Thread.currentThread().getName());
        return "------testE";
    }

    /**
     * 热点参数限流：https://github.com/alibaba/Sentinel/wiki/%E7%83%AD%E7%82%B9%E5%8F%82%E6%95%B0%E9%99%90%E6%B5%81
     * 何为热点？热点即经常访问的数据。很多时候我们希望统计某个热点数据中访问频次最高的 Top K 数据，并对其访问进行限制。比如：
     * <p>
     * 商品 ID 为参数，统计一段时间内最常购买的商品 ID 并进行限制
     * 用户 ID 为参数，针对一段时间内频繁访问的用户 ID 进行限制
     * 热点参数限流会统计传入参数中的热点参数，并根据配置的限流阈值与模式，对包含热点参数的资源调用进行限流。热点参数限流可以看做是一种特殊的流量控制，仅对包含热点参数的资源调用生效。
     * 当代码体发生异常，Sentinel不会帮我们提供解决方案，他只针对参数控制的规则
     * 结论：从@HystrixCommand 到 @SentinelResource
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }


    /**
     * 自定义通用的限流处理逻辑，
     * blockHandlerClass = CustomerBlockHandler.class
     * blockHandler = handleException2
     * 上述配置：找CustomerBlockHandler类里的handleException2方法进行兜底处理
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult<String> customerBlockHandler() {
        return new CommonResult<String>(200, "按客户自定义限流处理逻辑");
    }

    @GetMapping(value = "/rateLimit/byUrl")
    public String byUrl() {
        return "------------byUrl";
    }

}
