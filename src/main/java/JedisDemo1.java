import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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

    /**
     * 连接池方式连接
     */
    @Test
    public void demo2() {
        // 获得连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        //设置最大连接数
        jedisPoolConfig.setMaxTotal(30);

        //设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(30);

        //获得连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"139.9.251.246",6379);

        //获得核心对象
        Jedis jedis = null;

        try {
            //通过连接池来获得连接
            jedis = jedisPool.getResource();

            //设置数据
            jedis.set("name","张三");

            //获取数据
            String value = jedis.get("name");
            System.out.println(value);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (jedis != null) {
                jedis.close();
            }
            if (jedisPool != null) {
                jedis.close();
            }
        }


    }
}
