package javaBasics;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: xinghaifang
 * Date: 2019/12/16
 * Time: 11:28
 */
public class LinkBlockingQueueDemo {
    private String orgCode;
    private String batId;
    //根据类型判断
    volatile int buildSingleCacheType = 0;

    //构造函数;
    public LinkBlockingQueueDemo(String orgCode,String batId){
        this.orgCode = orgCode;
        this.batId = batId;
    }

    //从db中查询记录,status为
    private static LinkedBlockingQueue<String> tableQueue = new LinkedBlockingQueue<String>(4);
    //List stddb entity
    private static LinkedBlockingQueue<List<String>> stddbQueue = new LinkedBlockingQueue<List<String>>(12);
    //List empi entity
    private static LinkedBlockingQueue<List<String>> empiQueue = new LinkedBlockingQueue<List<String>>(4);
    //List ehr emr entity
    private static LinkedBlockingQueue<List<String>> ehrEmrQueue = new LinkedBlockingQueue<List<String>>(4);
    //分批次跑数据,把mysql中的数据跑到mongo中;
    public void buildSingleHugeBatch(String orgCode,String batId,String type){
        //健康浏览器生产者
        addToDbQueue();
        takeDbWork();

        //empi 生产者empiQueue
        addToEmpiQueue();
        //ehr emr生产者 ehrEmrQueue
        addToEhrEmrQueue();

        //stddbQueue  empiQueue  ehrEmrQueue 消费者;
        handleStddbQueueAndWork();
    }

    private void addToEhrEmrQueue() {
        new Thread(()->{
            if (buildSingleCacheType == IndexConstantTableName.ONLY_EMPI) {
                return;
            }
            Thread.currentThread().setName("ehr emr 数据加载");
            try{
                int pageNo = 0;
                int pageSize = 50000;
                int counter = 0;
                List<String> ehrEmrEntityList;
                do{
                    ehrEmrEntityList = findEhrEmrEntityListAllByBatId(batId);
                    counter = counter + ehrEmrEntityList.size();
                    ehrEmrQueue.put(ehrEmrEntityList);
                    try {
                        TimeUnit.SECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }while (ehrEmrEntityList.size()==50000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }



    private void addToEmpiQueue() {
        new Thread(()->{
            if (buildSingleCacheType == IndexConstantTableName.ONLY_INDEX) {
                return;
            }
            Thread.currentThread().setName("empi 数据加载");
            try{
                int pageNo = 0;
                int pageSize = 50000;
                int counter = 0;
                List<String> empiEntityList;
                do{
                    empiEntityList = findEmpiEntityListAllByBatId(batId);
                    counter = counter + empiEntityList.size();
                    empiQueue.put(empiEntityList);
                    try {
                        TimeUnit.SECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }while (empiEntityList.size()==50000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }



    private void handleStddbQueueAndWork() {
        for (int i = 0; i < 8; i++) {

        }
        new Thread(()->{
            while (true){
                Long initWaitTimeOut = 0L;
                if(buildSingleCacheType == IndexConstantTableName.ONLY_EMPI){
                    initWaitTimeOut = 200l;
                }else {
                    initWaitTimeOut = 100l;
                }
                try {
                    TimeUnit.SECONDS.sleep(initWaitTimeOut);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(stddbQueue.isEmpty() && empiQueue.isEmpty() && ehrEmrQueue.isEmpty()){
                    //继续等待一会儿;
                    Long idleWaitTimeOut = 0L;
                    if(buildSingleCacheType == IndexConstantTableName.ONLY_EMPI){
                        idleWaitTimeOut = 200l;
                    }else {
                        idleWaitTimeOut = 2500l;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(idleWaitTimeOut);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(stddbQueue.isEmpty()){
                        break;
                    }

                }

                switch (buildSingleCacheType){
                    case IndexConstantTableName.BOTH:
                        bulidSingleHugeIndex();
                        bulidSingleHugeEMPI();
                        break;
                    case IndexConstantTableName.ONLY_INDEX:
                        bulidSingleHugeIndex();
                        break;
                    case IndexConstantTableName.ONLY_EMPI:
                        bulidSingleHugeEMPI();
                    default:
                        break;
                }

            }
        }).start();
    }




    /**
     *
     * 1 处理每张表
     * 2 放入dealTableQueue队列中;
     */
    private void takeDbWork() {
        for (int i = 0; i < 4; i++) {

        }
        new Thread(()->{

            System.out.println("DB worker in execution.....");
            while (true) {
                //每个执行休眠5s;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (tableQueue.isEmpty()) {
                    System.out.println("dbQueue 为空, 不需要处理");
                    try {
                        //休眠25s等待queue put
                        TimeUnit.SECONDS.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //再次判断是否需要处理;
                    if (tableQueue.isEmpty()) {
                        //跳出while循环;
                        break;
                    }
                }

                //不空的时候;
                String tableName = null;
                try {
                    tableName = tableQueue.take();

                    System.out.println("取出表名" + tableName);
                    List<String> entityList;
                    int pageNo = 0;
                    int pageSize = 50000;
                    int counter = 0;
                    do {
                        //从数据库中查询出50000条数据;
                        entityList = finaAllByBatId(pageNo, pageSize);
                        BuildBean buildBean = new BuildBean();
                        buildBean.setTableName(tableName);
                        buildBean.setEntityList(entityList);
                        counter = entityList.size();
                    } while (entityList.size() == 50000);
                    System.out.println("单表的每条数据放入到新的队列中");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
}

    /**
     * 把table放入到队列中;
     */
    public void addToDbQueue() {
        new Thread(()->{
            //empi不需要放表名称;
            if(buildSingleCacheType == 1){
                return;
            }
            Thread.currentThread().setName("ehr ehr需要mysql同步mogon的表名线程开始");
            for (String tableName :IndexConstantTableName.ehrEmrTableList.keySet()){
                try {
                    tableQueue.put(tableName);
                    System.out.println("表名" + tableName +"已经放入处理队列中");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private List<String> finaAllByBatId(int pageNo, int pageSize) {
        return null;
    }
    private List<String> findEmpiEntityListAllByBatId(String batId) {
        return null;
    }
    private List<String> findEhrEmrEntityListAllByBatId(String batId) {
        return null;
    }
    private void bulidSingleHugeEMPI() {

    }
    private void bulidSingleHugeIndex() {

    }


}
