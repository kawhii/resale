package mongodb;

import com.carl.resale.ui.bean.SysArea;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.junit.Test;

/**
 * @author Carl
 * @date 2016/9/25
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class Helloworld {

    @Test
    public void test() throws Exception {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);

        MongoDatabase database = mongoClient.getDatabase("database");
        MongoCollection<SysArea> areaMongoCollection = database.getCollection("sys_file", SysArea.class);
        FindIterable<SysArea> it = areaMongoCollection.find();
        it.forEach(new Block<SysArea>() {
            public void apply(SysArea area) {
                System.out.println(area.getName());
            }
        });
        mongoClient.close();
    }
}
