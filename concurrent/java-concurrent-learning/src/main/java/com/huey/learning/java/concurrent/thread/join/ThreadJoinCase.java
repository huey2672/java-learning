package com.huey.learning.java.concurrent.thread.join;

import java.util.Date;

/**
 * @author huey
 */
public class ThreadJoinCase {

    public static void main(String[] args) throws Exception {

        // creates the loading tasks
        Thread dataSourcesLoader = new Thread(new DataSourcesLoader());
        Thread networkConnectionsLoader = new Thread(new NetworkConnectionsLoader());

        // runs the tasks
        dataSourcesLoader.start();
        networkConnectionsLoader.start();

        // waits for those threads to die.
        dataSourcesLoader.join();
        networkConnectionsLoader.join();

        // does other things
        System.out.printf("Main: Configuration has been loaded: %s\n", new Date());

    }

}
