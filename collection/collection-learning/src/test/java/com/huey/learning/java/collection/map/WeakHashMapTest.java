package com.huey.learning.java.collection.map;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author huey
 */
public class WeakHashMapTest {

    @Test
    public void testWeakHashMap() throws Exception {

        Path path = Paths.get("/etc/hosts");
        BigFileKey bigFileKey = new BigFileKey(path.toAbsolutePath().toString());
        BigFile bigFile = new BigFile(path);

        // creates a WeakHashMap instance and puts an entry
        Map<BigFileKey, BigFile> fileCache = new WeakHashMap<>();
        fileCache.put(bigFileKey, bigFile);

        Assert.assertTrue(fileCache.containsKey(bigFileKey));

        bigFileKey = null;
        bigFile = null;
        System.gc();

        TimeUnit.SECONDS.sleep(1);

        Assert.assertTrue(fileCache.isEmpty());

    }

    public class BigFile {

        private byte[] data;

        public BigFile(Path path) throws IOException {
            this.data = Files.readAllBytes(path);
        }

    }

    public class BigFileKey {

        private String bfKey;

        public BigFileKey(String bfKey) {
            this.bfKey = bfKey;
        }

    }

}
