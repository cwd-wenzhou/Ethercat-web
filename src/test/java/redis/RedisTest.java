package redis;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {
    @Test
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        System.out.println("Server is running: "+jedis.ping());
        jedis.set("java test","ee");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","cwd");
        jsonObject.put("location","imc412");
        jsonObject.put("school","hust");
        String res = jsonObject.toJSONString();
        jedis.set("json",res);
        //System.out.println("Server is running: "+jedis.hget("rediscomcn","name"));

    }
}
