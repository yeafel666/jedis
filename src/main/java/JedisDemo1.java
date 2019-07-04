import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author Yeafel
 * Jedis的测试
 * 2019/7/4 22:58
 * Do or Die,To be a better man!
 */
public class JedisDemo1 {

    @Test
    /**
     * 单实例测试
     */
    public void demo1() {
        //1、设置ip地址和端口
        Jedis jedis = new Jedis("139.9.251.246",6379);

        //2、保存数据
        jedis.set("name","yeafel");

        //3、获取数据
        String value = jedis.get("name");
        System.out.println(value);

        //4、释放资源
        jedis.close();

    }
}
