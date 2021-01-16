package my.homework.mq.activemq;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.usage.SystemUsage;

public class ActiveMQServer {

    public static void main(String[] args) throws Exception {
        BrokerService brokerService=new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");

        SystemUsage memoryManager = new SystemUsage();
        memoryManager.getMemoryUsage().setLimit(1024 * 50);
        //memoryManager.getMemoryUsage().(1024 * 50);
        brokerService.setSystemUsage(memoryManager);
        //brokerService.setUseShutdownHook(false);
        brokerService.start();
    }
}
