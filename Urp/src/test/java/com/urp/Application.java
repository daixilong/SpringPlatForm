package com.urp;

/**
 * Created by a on 2018/5/22.
 */
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 通过jetty直接运行项目
 */
public class Application {
    public  static  void  main(String [] args){
        Server server=new Server(8010);
        WebAppContext context=new WebAppContext();
        context.setResourceBase("D:\\Workspaces1\\Urp\\target\\Platform");
        try {
            server.setHandler(context);
            server.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
